package org.edgar.neo.adapter.demo.passport;

import lombok.Data;

@Data
public class Member {

    private String username;
    private String password;
    private String mid;
    private String info;

    public Member() {
    }

    public Member(String username) {
        this.username = username;
    }
}
