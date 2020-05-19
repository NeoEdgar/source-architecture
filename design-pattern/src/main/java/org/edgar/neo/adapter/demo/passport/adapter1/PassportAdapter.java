package org.edgar.neo.adapter.demo.passport.adapter1;

import org.edgar.neo.adapter.demo.passport.PassportService;
import org.edgar.neo.adapter.demo.passport.ResultMsg;

/**
 * 通过继承实现
 */
public class PassportAdapter extends PassportService implements  IPassportForThird {

    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId, null);
    }

    public ResultMsg loginForWeChat(String openId) {
        return loginForRegist(openId, null);
    }

    public ResultMsg loginForToken(String token) {
        return loginForRegist(token, null);
    }

    public ResultMsg loginForTelephone(String phone, String code) {
        return loginForRegist(phone, null);
    }

    private ResultMsg loginForRegist(String username, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }
        super.regist(username, password);
        return super.login(username, password);
    }
}
