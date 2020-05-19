package org.edgar.neo.adapter.demo.passport.adapter2;

import org.edgar.neo.adapter.demo.passport.adapter2.adapters.LoginForQQAdapter;
import org.edgar.neo.adapter.demo.passport.adapter2.decorator.Decorator;
import org.edgar.neo.adapter.demo.passport.adapter2.decorator.LoginForWeiboDecorator;

public class Test {
    public static void main(String[] args) {
        IPassportForThird adapter = new PassportAdapter("ssfsssda", new LoginForQQAdapter());
//        adapter.loginForQQ("ssfsssda");
//        adapter.loginForWeChat("sfsdfs");
    }
}
