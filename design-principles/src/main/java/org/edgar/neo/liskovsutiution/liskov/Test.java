package org.edgar.neo.liskovsutiution.liskov;

public class Test {

    public void resize(QuadRangle quadRangle){
        while (quadRangle.getHeight() >= quadRangle.getWidth()){
//            quadRangle.setHeight();
            System.out.println("Width"+quadRangle.getWidth() + "\n" + "Height" + quadRangle.getHeight()) ;
        }
        System.out.println("Resize End: Width"+quadRangle.getWidth() + "\n" + "Height" + quadRangle.getHeight()) ;
    }
}
