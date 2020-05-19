package org.edgar.neo.adapter.demo.passport.adapter2;

import org.edgar.neo.adapter.demo.passport.ResultMsg;

/**
 * 适配目标对象(扩展，不改代码的情况下，加装饰器/委派)
 */
public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWeChat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelephone(String phone, String code);
}
