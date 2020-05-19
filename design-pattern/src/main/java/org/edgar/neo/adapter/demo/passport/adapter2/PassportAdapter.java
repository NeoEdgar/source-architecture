package org.edgar.neo.adapter.demo.passport.adapter2;

import org.edgar.neo.adapter.demo.passport.PassportService;
import org.edgar.neo.adapter.demo.passport.ResultMsg;
import org.edgar.neo.adapter.demo.passport.adapter2.adapters.ILoginAdapter;
import org.edgar.neo.adapter.demo.passport.adapter2.adapters.LoginForQQAdapter;
import org.edgar.neo.adapter.demo.passport.adapter2.adapters.LoginForWechatAdapter;
import org.edgar.neo.adapter.demo.passport.adapter2.decorator.Decorator;

public class PassportAdapter implements IPassportForThird {

//    private PassportService passportService;


    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    public ResultMsg loginForWeChat(String openId) {
        return processLogin(openId, LoginForWechatAdapter.class);
    }

    public ResultMsg loginForToken(String token) {
        return null;
    }

    public ResultMsg loginForTelephone(String phone, String code) {
        return null;
    }

//    public ResultMsg loginForWhat(String id){
//        return processLogin(id, )
//    }


    public PassportAdapter(String openid, ILoginAdapter decorator) {
        processLogin2(openid, decorator.getClass());
    }

    private ResultMsg processLogin2(String id, Class<? extends ILoginAdapter> clazz) {
        ILoginAdapter adapter = null;
        try {
            adapter = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (adapter.support(adapter)) {
            return adapter.login(id, adapter);
        }
        return null;
    }

    private ResultMsg processLogin(String id, Class<? extends ILoginAdapter> clazz) {
        ILoginAdapter adapter = null;
        try {
            adapter = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (adapter.support(adapter)) {
            return adapter.login(id, adapter);
        }
        return null;
    }
}
