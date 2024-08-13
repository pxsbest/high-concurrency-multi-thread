package org.pinery.loader;

import org.apache.tomcat.jni.File;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//自定义类加载器 必须是 ClassLoader的直接或间接子类
public class MyClassLoader extends ClassLoader {
    //定义默认的class存放路径
    static final String classpath = MyClassLoaderTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    private final static Path DEFAULT_CLASS_DIR = Paths.get("D:\\IT\\Java\\high-concurrency-multi-thread\\multi-thread", "classloader1");

    private final Path classDir;

    //使用默认的class路径
    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    //允许传入指定路径的class路径
    public MyClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }

    //指定class路径的同时,指定父类加载器
    public MyClassLoader(String classDir, ClassLoader parent) {
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




}
