package org.edgar.neo.liskovsutiution.methodreturn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Child extends Base {

    @Override
    public HashMap mothod() {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", "child");
        System.out.println("执行子类");
        return hashMap;
    }
}
