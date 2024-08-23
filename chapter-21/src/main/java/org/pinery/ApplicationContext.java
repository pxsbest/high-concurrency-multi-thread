package org.pinery;


public final class ApplicationContext {

    //采用Holder方式实现 单例
    private static class Holder {
        private static ApplicationContext instance = new ApplicationContext();
    }

    public static ApplicationContext getContext() {
        return Holder.instance;
    }

}