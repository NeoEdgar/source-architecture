package org.edgar.neo.composite.demo.safe;

public class Test {
    public static void main(String[] args) {
        System.out.println("------安全模式");

        File qq = new File("QQ.exe");
        File wx = new File("WX.exe");

        Folder office = new Folder("办公软件", 2);

        File word = new File("Word.exe");
        File excel = new File("Excel.exe");
        File ppt = new File("PowerPoint.exe");

        office.add(word);
        office.add(excel);
        office.add(ppt);

        Folder root = new Folder("root", 1);
        root.add(qq);
        root.add(wx);
        root.add(office);

        root.show();

        System.out.println("------");

        root.list();
    }
}
