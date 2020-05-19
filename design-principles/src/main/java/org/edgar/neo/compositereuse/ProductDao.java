package org.edgar.neo.compositereuse;

public class ProductDao {

    // 聚合
    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String connect = dbConnection.getConnect();
        System.out.println(connect);
    }
}
