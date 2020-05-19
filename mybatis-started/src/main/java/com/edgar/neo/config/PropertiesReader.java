package com.edgar.neo.config;

import java.util.ResourceBundle;

public class PropertiesReader {

    public static void main(String[] args) {
        ResourceBundle application = ResourceBundle.getBundle("application");
        System.out.println(application.getString("spring.datasource.password"));
    }
}
