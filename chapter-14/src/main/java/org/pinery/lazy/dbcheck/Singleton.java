package org.pinery.lazy.dbcheck;

import java.io.File;

/**
 * 懒加载-双重检查
 **/
public final class Singleton {

    private static Singleton instances=null;
    public File file;

    private Singleton() {
        file = new File("");
    }

    public static Singleton getInstances() {
        if (instances == null) {
            synchronized (Singleton.class) {
                if (instances == null) {
                    instances = new Singleton();
                }
            }
        }
        return instances;
    }
}
