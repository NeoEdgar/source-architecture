package org.edgar.neo.factory.simplefactory;

/**
 * 简单工厂
 */
public class CourseFactory {

    public ICourse createByName(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        }else if ("python".equals(name)){
            return new PythonCourse();
        }else {
            return null;
        }
    }

    public ICourse createClassForName(String className) {

        if (!(null == className || "".equals(className))) {
            try {
                return (ICourse) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public ICourse create(Class<? extends ICourse> clazz) {

        if (null != clazz) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
