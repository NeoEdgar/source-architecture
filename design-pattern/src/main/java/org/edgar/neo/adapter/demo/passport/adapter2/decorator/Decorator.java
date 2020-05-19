package org.edgar.neo.adapter.demo.passport.adapter2.decorator;

import org.edgar.neo.adapter.demo.passport.ResultMsg;
import org.edgar.neo.adapter.demo.passport.adapter2.adapters.AbstractAdapter;

public class Decorator extends AbstractAdapter {

    private AbstractAdapter abstractAdapter;

    public Decorator(AbstractAdapter abstractAdapter) {
        this.abstractAdapter = abstractAdapter;
    }

    public boolean support(Object object) {
        return abstractAdapter.support(object);
    }

    public ResultMsg login(String id, Object adapter) {
        return abstractAdapter.login(id, adapter);
    }
}
