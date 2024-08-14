package org.pinery;

/**
 * 任务(业务逻辑)在执行过程中,不同阶段触发不同的事件.
 **/
public interface TaskLifeCycle<T> {
    //任务启动时会触发onStart方法
    void onStart(Thread thread);

    //任务正在运行时会触发onRunning方法
    void onRunning(Thread thread);

    //任务运行结束时会触发onFinish方法,其中 result 是任务执行结束后的结果
    void onFinish(Thread thread, T result);

    //任务执行报错时会触发 onError方法
    void onError(Thread thread, Exception e);

    //生命周期接口的空实现(Adatper)
     class EmptyLifecycle<T> implements TaskLifeCycle<T> {

        @Override
        public void onStart(Thread thread) {
            System.out.println("触发:onStart");
        }

        @Override
        public void onRunning(Thread thread) {
            System.out.println("触发:onRunning");
        }

        @Override
        public void onFinish(Thread thread, T result) {
            System.out.println("触发:onFinish");
        }

        @Override
        public void onError(Thread thread, Exception e) {
            System.out.println("触发:onError");
        }

    }
}
