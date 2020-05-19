package org.edgar.neo.flyweight.general;

import java.util.HashMap;
import java.util.Map;

/**
 * 连接池
 * String 常量池
 * Integer 缓存-128～127
 */
public class FlyWeightFactory {

    private static Map<String, IFlyWeight> pool = new HashMap<String, IFlyWeight>();

    public static IFlyWeight getFlyWeight(String intrinsicState) {
        if (!pool.containsKey(intrinsicState)) {
            ConcreteFlyWeight concreteFlyWeight = new ConcreteFlyWeight(intrinsicState);
            pool.put(intrinsicState, concreteFlyWeight);
        }
        return pool.get(intrinsicState);
    }
}
