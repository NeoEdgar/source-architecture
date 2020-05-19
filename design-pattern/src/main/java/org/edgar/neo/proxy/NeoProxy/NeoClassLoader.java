package org.edgar.neo.proxy.NeoProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class NeoClassLoader extends ClassLoader{

    private File classPathFile;

    public NeoClassLoader() {
        String path = NeoClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = NeoClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream fis = null;
                ByteArrayOutputStream out = null;

                try {
                    fis = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;

                    while ((len=fis.read(buff)) != -1){
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
