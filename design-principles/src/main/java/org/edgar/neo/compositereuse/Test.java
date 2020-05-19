package org.edgar.neo.compositereuse;

public class Test {

    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new OracleConnection());
        productDao.addProduct();
    }
}
