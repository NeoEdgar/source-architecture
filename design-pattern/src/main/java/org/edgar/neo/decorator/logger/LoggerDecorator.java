package org.edgar.neo.decorator.logger;

import com.sun.org.slf4j.internal.Logger;

public class LoggerDecorator extends Logger {

    public Logger logger;

    public LoggerDecorator(String s, Logger logger) {
        super(s);
        this.logger = logger;
    }

    @Override
    public void trace(String s) {
        super.trace(s);
    }

    @Override
    public void error(String s) {
        super.error(s);
    }
}
