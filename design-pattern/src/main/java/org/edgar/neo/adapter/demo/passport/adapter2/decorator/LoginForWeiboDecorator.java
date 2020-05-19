package org.edgar.neo.adapter.demo.passport.adapter2.decorator;

import org.edgar.neo.adapter.demo.passport.ResultMsg;
import org.edgar.neo.adapter.demo.passport.adapter2.adapters.AbstractAdapter;
import org.edgar.neo.adapter.demo.passport.adapter2.adapters.LoginForQQAdapter;

public class LoginForWeiboDecorator extends Decorator {

    public LoginForWeiboDecorator(AbstractAdapter abstractAdapter) {
        super(abstractAdapter);
    }

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {

        if (!support(adapter)){
            return null;
        }
        return super.loginForRegist(id, null);
    }

}
