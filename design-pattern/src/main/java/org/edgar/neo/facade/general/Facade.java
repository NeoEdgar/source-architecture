package org.edgar.neo.facade.general;

/**
 * 门面代言人
 *
 * 应用：
 * spring JdbcUtils
 */
public class Facade {

    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();
    private SubSystemC subSystemC = new SubSystemC();

    public void doA(){
        subSystemA.doA();
    }

    public void doB(){
        subSystemB.doB();
    }

    public void doC(){
        subSystemC.doC();
    }
}
