package org.edgar.neo.compositereuse;

public class MysqlConnection extends DBConnection {
    @Override
    public String getConnect() {
        return "Mysql connect";
    }
}
