package org.edgar.neo.decorator.logger;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class JsonLoggerFactory {

    public static JsonLogger getLogger(Class<?> var0) {
        Logger logger = LoggerFactory.getLogger(var0);
        return new JsonLogger(var0.getName(), logger);
    }
}
