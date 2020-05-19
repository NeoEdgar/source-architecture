package org.edgar.neo.adapter.demo.passport;

public class PassportService {


    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username,String password){
        return  new ResultMsg(200,"注册成功",new Member(username));
    }

    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        System.out.println(new ResultMsg(200, username + "登录成功", new Member(username)));
        return null;
    }
}
