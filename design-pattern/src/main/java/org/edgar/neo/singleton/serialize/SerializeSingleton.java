package org.edgar.neo.singleton.serialize;

import java.io.Serializable;

public class SerializeSingleton implements Serializable {


    private SerializeSingleton() {
    }

    public static final SerializeSingleton serializeSingleton = new SerializeSingleton();

    public static SerializeSingleton getInstance() {
        return serializeSingleton;
    }

    // 序列化
    // 把内存中的对象的状态转换为字节码的形式
    // 把字节码通过IO输出流，写到磁盘上
    // 永久保存下来，持久化

    // 反序列化
    // 将持久化的字节码内容，通过IO输入流读到内存中
    // 转化成一个Java对象

    // ObjectInputStream readObject 判断你是否重写 readResolve方法
    // 如果有则将返回结果 赋值给对象
    private Object readResolve(){
        return serializeSingleton;
    }


}
