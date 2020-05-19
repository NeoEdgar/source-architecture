package org.edgar.neo.flyweight.ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketFactory {

    // key可以重复利用
    private static Map<String, ITicket> pool = new HashMap<String, ITicket>();

    public static ITicket queryTicket(String from, String to) {
        String key = from + "->" + to;
        if (pool.containsKey(key)) {
            System.out.println("使用缓存" + key);
            return pool.get(key);
        }
        System.out.println("首次查询，创建对象：" + key);
        TrainTicket ticket = new TrainTicket(from, to);
        pool.put(key, ticket);
        return ticket;
    }
}
