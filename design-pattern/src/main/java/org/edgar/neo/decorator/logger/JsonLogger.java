package org.edgar.neo.decorator.logger;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.slf4j.internal.Logger;

public class JsonLogger extends LoggerDecorator {

    public JsonLogger(String s, Logger logger) {
        super(s, logger);
    }

    @Override
    public void trace(String s) {
        JSONObject result = newJSONObject();
        result.put("trace", s);
        logger.trace(result.toString());
    }

    @Override
    public void error(String s) {
        JSONObject result = newJSONObject();
        result.put("error", s);
        result.put("meg", s);
        logger.error(result.toString());
    }

    private JSONObject newJSONObject() {
        return new JSONObject();
    }
}
