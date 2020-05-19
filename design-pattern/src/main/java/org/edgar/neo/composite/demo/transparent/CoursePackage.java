package org.edgar.neo.composite.demo.transparent;

import java.util.ArrayList;
import java.util.List;

public class CoursePackage extends CourseComponent {

    // 传统
//    private List<Course> items = new ArrayList<Course>();

    private List<CourseComponent> items = new ArrayList<CourseComponent>();

    private String name;

    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent component) {
        items.add(component);
    }

    @Override
    public void removeChild(CourseComponent component) {
        items.remove(component);
    }

    @Override
    public String getName(CourseComponent component) {
        return this.name;
    }


    @Override
    public void print() {
        System.out.println(this.name);
        for (CourseComponent c : items) {
            if (this.level != null){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("   ");
                }
                for (int i = 0; i < this.level; i++) {
                    System.out.print("-");
                }
            }
            c.print();
        }
    }
}
