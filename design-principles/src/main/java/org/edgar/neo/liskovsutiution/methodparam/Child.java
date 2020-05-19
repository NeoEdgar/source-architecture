package org.edgar.neo.liskovsutiution.methodparam;

import java.util.HashMap;
import java.util.Map;

public class Child extends Base {

// 不滥用继承
//    @Override
//    public void method(HashMap map) {
//        System.out.println("执行子类HashMap入参");
//    }

    public void method(Map map){
        System.out.println("执行子类Map入参");
    }
}
