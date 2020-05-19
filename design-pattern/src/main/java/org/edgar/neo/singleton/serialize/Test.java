package org.edgar.neo.singleton.serialize;

import java.io.*;

public class Test {

    public static void main(String[] args) {

        SerializeSingleton s1 = null;
        SerializeSingleton s2 = SerializeSingleton.getInstance();

        try {
            FileOutputStream fos = new FileOutputStream("SerializeSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializeSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SerializeSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
