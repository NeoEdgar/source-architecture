package org.edgar.neo.adapter.demo.passport.adapter2.adapters;

import org.edgar.neo.adapter.demo.passport.ResultMsg;

public interface ILoginAdapter {
    boolean support(Object object);
    ResultMsg login(String id, Object adapter);
}
