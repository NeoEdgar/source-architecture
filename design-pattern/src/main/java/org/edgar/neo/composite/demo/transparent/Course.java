package org.edgar.neo.composite.demo.transparent;

public class Course extends CourseComponent {

    private String name;

    private Double price;

    public Course(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent componet) {
        return this.name;
    }

    @Override
    public Double getPrice(CourseComponent componet) {
        return this.price;
    }


    public void print(){
        System.out.println(name+"($" + price + ")");
    }
}
