package org.edgar.neo.adapter.demo.passport.adapter1;

import org.edgar.neo.adapter.demo.passport.ResultMsg;

/**
 * 适配目标对象
 */
public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWeChat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelephone(String phone,String code);
}
