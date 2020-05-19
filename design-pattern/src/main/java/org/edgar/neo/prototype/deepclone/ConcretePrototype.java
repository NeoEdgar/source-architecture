package org.edgar.neo.prototype.deepclone;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.*;
import java.util.List;

@Data
public class ConcretePrototype implements Cloneable, Serializable {

    private int age;

    private String name;

    private List<String> hobbies;

    @Override
    protected ConcretePrototype clone() {
        try {
            return (ConcretePrototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 缺点：性能问题、占有IO
     *
     */
    public ConcretePrototype deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            return (ConcretePrototype)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
                bis.close();
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //json的实现
    public ConcretePrototype deepCloneJson() {
        ConcretePrototype concretePrototype = this;
        ConcretePrototype concretePrototypeCopy = JSON.toJavaObject((JSON) JSON.toJSON(concretePrototype), ConcretePrototype.class);
        return concretePrototypeCopy;
    }


}
