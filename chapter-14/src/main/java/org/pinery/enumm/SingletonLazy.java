package org.pinery.enumm;

/**
 * 枚举方式 懒加载
 **/
public class SingletonLazy {
    private byte[] data = new byte[1024];

    private SingletonLazy() {
    }

    private enum EnumHolder {
        INSTANCE;
        private SingletonLazy instance;

        EnumHolder() {
            this.instance = new SingletonLazy();
        }
        private SingletonLazy getSingleton() {
            return instance;
        }
    }

    public static SingletonLazy getInstance() {
        return EnumHolder.INSTANCE.getSingleton();
    }
}
