package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * 测试
 **/
public class Main {

    public static void main(String[] args) {
        final TaskLifeCycle<String> lifeCycle = new TaskLifeCycle.EmptyLifecycle<String>(){
            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("The result is "+ result);
            }
        };
        ObservableThread<String> observableThread = new ObservableThread<>(lifeCycle, () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(" finished done.");
            return "Hello Observer";
        });
        observableThread.start();
    }


    public static void main1(String[] args) {
        ObservableThread observableThread = new ObservableThread<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" finished done.");
            return null;
        });

        //线程开始执行,JVM调用线程 run方法
        observableThread.start();
    }
}