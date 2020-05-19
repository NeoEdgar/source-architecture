package org.edgar.neo.adapter.demo.passport.adapter2.adapters;

import org.edgar.neo.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForTelAdapter extends AbstractAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id,null);
    }

}
