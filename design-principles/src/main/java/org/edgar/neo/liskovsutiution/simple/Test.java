package org.edgar.neo.liskovsutiution.simple;

public class Test {

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("Width"+rectangle.getWidth() + "\n" + "Height" + rectangle.getHeight()) ;
        }
        System.out.println("Resize End: Width"+rectangle.getWidth() + "\n" + "Height" + rectangle.getHeight()) ;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(20);
        resize(rectangle);
    }
}
