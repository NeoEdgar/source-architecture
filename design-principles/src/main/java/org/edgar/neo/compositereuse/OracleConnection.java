package org.edgar.neo.compositereuse;

public class OracleConnection extends DBConnection {

    @Override
    public String getConnect() {
        return "Oracle connect";
    }
}
