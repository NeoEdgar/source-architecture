package org.edgar.neo.decorator.logger;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test {

    //private static final Logger logger = LoggerFactory.getLogger(Test.class);

    private static final JsonLogger jsonLogger = JsonLoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        jsonLogger.trace("追踪");
        jsonLogger.error("系统错误");

        //jdk应用
        try {
            FileInputStream fis = new FileInputStream("");
            //fis.read();

            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read();
            bis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
