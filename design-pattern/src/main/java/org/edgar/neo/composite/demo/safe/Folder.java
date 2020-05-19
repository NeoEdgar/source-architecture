package org.edgar.neo.composite.demo.safe;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Directory {

    private List<Directory> directors;

    private Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
        this.directors = new ArrayList<Directory>();
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (Directory c : directors) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("   ");
                }
                for (int i = 0; i < this.level; i++) {
                    System.out.print("-");
                }
            }
            c.show();
        }
    }

    public boolean add(Directory director) {
        return this.directors.add(director);
    }


    public boolean remove(Directory director) {
        return this.directors.remove(director);
    }


    public Directory get(int index) {
        return this.directors.get(index);
    }

    public void list() {
        for (Directory dir : directors) {
            System.out.println(dir.name);
        }
    }
}
