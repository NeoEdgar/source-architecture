package org.edgar.neo.framework.beans;

public class NeoBeanWrapper {

    private Object wrapperInstance;
    private Class<?> wrapperClass;

    public NeoBeanWrapper(Object instance) {
        this.wrapperInstance = instance;
        this.wrapperClass = instance.getClass();
    }

    public Object getWrapperInstance() {
        return wrapperInstance;
    }

    public Class<?> getWrapperClass() {
        return wrapperClass;
    }
}
