package org.pinery.loader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BrokerDelegateClassLoader extends ClassLoader {
    private final Path classDir;

    //指定class路径的同时,指定父类加载器
    public BrokerDelegateClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }
    //重写父类的findClass方法,这是至关重要的步骤
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //读取class类的二进制数据
        byte[] bytes = this.readClassBytes(name);
        if (null == bytes || bytes.length == 0) {
            throw new ClassNotFoundException("Can not load the class " + name);
        }
        //调用defineClass方法定义 class
        return this.defineClass(name, bytes, 0, bytes.length);
    }

    //将class文件读入内存
    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        //将包名分隔符转换为文件路径分隔符
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("The class " + name + " not found.");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("load the class " + name + " occur error.", e);
        }
    }

    @Override
    public String toString() {
        return "My ClassLoader";
    }

    //#region 绕过双亲委托机制
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        //1.根据类的全路径名称进行加锁,确保每一个类在多线程的情况下只被加载一次
        synchronized (getClassLoadingLock(name)) {
            //2.到已加载的类缓存中查看该类是否已经被加载,如果已加载则直接返回
            if (name.indexOf("Hello") < 0) {
                return super.loadClass(name, resolve);
            }
            Class<?> klass = findClass(name);
            if (klass == null) {
                //3,4.若缓存中没有被加载的类,则需要对其进行首次加载,如果类的全路径以java和javax开头,则直接委托给系统类加载器对其进行加载.
                if (name.startsWith("java") || name.startsWith("javax")) {
                    try {
                        klass = getSystemClassLoader().loadClass(name);
                    } catch (Exception e) {
                        //
                    }
                } else {
                    //5.若类不是以java或javax开头,则尝试用我们自定义的类加载器进行加载
                    try {
                        klass = this.findClass(name);
                    } catch (ClassNotFoundException e) {
                        //
                    }
                    if (klass == null) {
                        //6.若自定义类加载器仍旧没有完成对类的加载,则委托给其父为加载器进行加载或者系统类加载器进行加载
                        if (getParent() != null) {
                            klass = getParent().loadClass(name);
                        } else {
                            klass = getSystemClassLoader().loadClass(name);
                        }
                    }
                }
            }
            //7.经过若干次的尝试之后,如果还是无法对类进行加载,则抛出无法找到类的异常.
            if (null == klass) {
                throw new ClassNotFoundException("The class " + name + " not found.");
            }
            if (resolve) {
                resolveClass(klass);
            }
            return klass;
        }
    }


    //#endregion
}
