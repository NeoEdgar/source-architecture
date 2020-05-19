package org.edgar.neo.demo.action;

import org.edgar.neo.demo.service.IQueryService;
import org.edgar.neo.framework.annotation.NeoAutowired;
import org.edgar.neo.framework.annotation.NeoController;
import org.edgar.neo.framework.annotation.NeoRequestMapping;
import org.edgar.neo.framework.annotation.NeoRequestParam;
import org.edgar.neo.framework.webmvc.servlet.NeoModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 公布接口url
 * @author Tom
 *
 */
@NeoController
@NeoRequestMapping("/")
public class PageAction {

    @NeoAutowired
    IQueryService queryService;

    @NeoRequestMapping("/first.html")
    public NeoModelAndView query(@NeoRequestParam("teacher") String teacher){
        String result = queryService.query(teacher);
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("teacher", teacher);
        model.put("data", result);
        model.put("token", "123456");
        return new NeoModelAndView("first.html",model);
    }

}
