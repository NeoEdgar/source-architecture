package org.edgar.neo.adapter.demo.passport.adapter2.adapters;

import org.edgar.neo.adapter.demo.passport.PassportService;
import org.edgar.neo.adapter.demo.passport.ResultMsg;

public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {
    protected ResultMsg loginForRegist(String username, String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        System.out.println(super.regist(username,password));
        return super.login(username,password);
    }
}
