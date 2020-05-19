package org.edgar.neo.framework.webmvc.servlet;

import java.util.Map;

public class NeoModelAndView {

    private String viewName;
    private Map<String, ?> model;

    public NeoModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public NeoModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }
}
