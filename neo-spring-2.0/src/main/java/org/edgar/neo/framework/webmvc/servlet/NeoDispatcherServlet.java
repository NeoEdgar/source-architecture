package org.edgar.neo.framework.webmvc.servlet;

import org.edgar.neo.framework.annotation.NeoController;
import org.edgar.neo.framework.annotation.NeoRequestMapping;
import org.edgar.neo.framework.context.NeoApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 委派模式
 * 职责：负责任务调度，请求分发
 */
public class NeoDispatcherServlet extends HttpServlet {

    private NeoApplicationContext applicationContext;

    private List<NeoHandlerMapping> handlerMappings = new ArrayList<NeoHandlerMapping>();

    private Map<NeoHandlerMapping, NeoHandlerAdapter> handlerAdapters = new HashMap<NeoHandlerMapping, NeoHandlerAdapter>();

    private List<NeoViewResolver> viewResolvers = new ArrayList<NeoViewResolver>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //6、委派,根据URL去找到一个对应的Method并通过response返回
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            try {
                processDispatchResult(req, resp, new NeoModelAndView("500"));
            } catch (Exception e1) {
                e1.printStackTrace();
                resp.getWriter().write("500 Exception,Detail : " + Arrays.toString(e.getStackTrace()));
            }
        }
    }

    /**
     * 完成了对HandlerMapping的封装
     * 完成了对方法返回值的封装ModelAndView
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //1、通过URL获得一个handlerMapping
        NeoHandlerMapping handlerMapping = getHandler(req);
        if (handlerMapping == null) {
            processDispatchResult(req, resp, new NeoModelAndView("404"));
            return;
        }

        //2、根据handlerMapping获得一个handlerAdapter
        NeoHandlerAdapter adapter = getHandlerAdapter(handlerMapping);

        //3、解析某一个方法的形参和返回值之后，统一封装为ModelAndView
        NeoModelAndView mv = adapter.handler(req, resp, handlerMapping);

        //4、把ModeAndView变成一个ViewResolver
        processDispatchResult(req, resp, mv);

    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, NeoModelAndView mv) throws Exception {
        if (null == mv || this.viewResolvers.isEmpty()) {
            return;
        }

        for (NeoViewResolver viewResolver : viewResolvers) {
            NeoView view = viewResolver.resolveViewName(mv.getViewName());
            //直接往浏览器输出
            view.render(mv.getModel(), req, resp);
            return;
        }

    }

    private NeoHandlerAdapter getHandlerAdapter(NeoHandlerMapping handlerMapping) {
        if (this.handlerAdapters.isEmpty()) {
            return null;
        }
        return this.handlerAdapters.get(handlerMapping);
    }

    private NeoHandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMappings.isEmpty()) {
            return null;
        }

        String uri = req.getRequestURI();//返回站点的根路径+path
        String contextPath = req.getContextPath();//返回站点的根路径。也就是项目的名字

        uri = uri.replaceAll(contextPath, "").replaceAll("/+", "/");
        for (NeoHandlerMapping handlerMapping : handlerMappings) {
            Matcher matcher = handlerMapping.getPattern().matcher(uri);
            if (!matcher.matches()) {
                continue;
            }
            return handlerMapping;
        }
        return null;
    }

    /**
     * init
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

        //初始化Spring核心Ioc容器
        //包含了加载配置文件-->解析扫描封装BeanDefinition-->缓存BeanDefinition ioc-->getBean()调用时实力化beans
        applicationContext = new NeoApplicationContext(config.getInitParameter("contextConfigLocation"));

        //完成Ioc、DI、MVC部分对接

        //初始化九大组件
        initStrategies(applicationContext);

        System.out.println("Neo Spring framework is init.");
    }

    private void initStrategies(NeoApplicationContext context) {
//                多文件上传的组件
//                initMultipartResolver(context);
//                初始化本地语言环境
//                initLocaleResolver(context);
//                初始化模板处理器
//                initThemeResolver(context);
//              handlerMapping
        initHandlerMappings(context);
//              初始化参数适配器
        initHandlerAdapters(context);
//                初始化异常拦截器
//                initHandlerExceptionResolvers(context);
//                初始化视图预处理器
//                initRequestToViewNameTranslator(context);
//              初始化视图转换器
        initViewResolvers(context);
//                FlashMap管理器
//                initFlashMapManager(context);

    }

    // todo
    private void initViewResolvers(NeoApplicationContext context) {
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File templateRootDir = new File(templateRootPath);
        for (File file : templateRootDir.listFiles()) {
            viewResolvers.add(new NeoViewResolver(templateRootDir));//简单初始化几个ViewResolver？
        }
    }

    private void initHandlerAdapters(NeoApplicationContext context) {

        for (NeoHandlerMapping handlerMapping : handlerMappings) {
            handlerAdapters.put(handlerMapping, new NeoHandlerAdapter());
        }
    }

    private void initHandlerMappings(NeoApplicationContext context) {

        if (applicationContext.getBeanDefinitionCount() == 0) {
            return;
        }
        /**
         * todo 之所以mapping重复 是全类名与simpleName ioc引用重复
         */
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            Object bean = applicationContext.getBean(beanName);
            Class<?> clazz = bean.getClass();
            //从controller中取requestMapping的URL（类和方法上）
            if (!clazz.isAnnotationPresent(NeoController.class)) {
                continue;
            }

            //相当于提取 class上配置的url
            String baseUrl = "";
            if (clazz.isAnnotationPresent(NeoRequestMapping.class)) {
                NeoRequestMapping requestMapping = clazz.getAnnotation(NeoRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            //只获取public的方法
            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(NeoRequestMapping.class)) {
                    continue;
                }
                //提取每个方法上面配置的url
                NeoRequestMapping requestMapping = method.getAnnotation(NeoRequestMapping.class);

                // //demo//query
                String regex = ("/" + baseUrl + "/" + requestMapping.value().replaceAll("\\*", ".*")).replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(regex);
                //handlerMapping.put(url,method);
                handlerMappings.add(new NeoHandlerMapping(pattern, method, bean));
                System.out.println("Mapped : " + regex + "," + method);
            }

        }
    }

}
