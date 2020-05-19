package org.edgar.neo.adapter.demo.passport.adapter2.adapters;

import org.edgar.neo.adapter.demo.passport.ResultMsg;

public class LoginForQQAdapter extends AbstractAdapter {

    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        if (!support(adapter)){
            return null;
        }
        return super.loginForRegist(id, null);
    }
}
