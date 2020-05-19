package org.edgar.neo.adapter.demo.passport.adapter1;

public class Test {
    public static void main(String[] args) {
        PassportAdapter adapter = new PassportAdapter();
        adapter.login("tom","123456");
        adapter.loginForQQ("sjooguwoersdfjhasjfsa");
        adapter.loginForWeChat("slfsjoljsdo8234ssdfs");
    }
}
