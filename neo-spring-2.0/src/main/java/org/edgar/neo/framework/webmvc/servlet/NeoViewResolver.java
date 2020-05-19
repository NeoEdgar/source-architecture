package org.edgar.neo.framework.webmvc.servlet;

import java.io.File;

public class NeoViewResolver {
    private final String DEFAULT_TEMPLATE_SUFFIX = ".html";
    private File templateRootDir;

    public NeoViewResolver(File templateRootDir) {
        // String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        this.templateRootDir = templateRootDir;
    }

    public NeoView resolveViewName(String viewName) {

        if (null == viewName || "".equals(viewName.trim())) {
            return null;
        }
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFIX);

        File file = new File((templateRootDir.getPath() + "/" + viewName).replaceAll("/+", "/"));
        return new NeoView(file);
    }
}
