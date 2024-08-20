package org.pinery;

import java.util.concurrent.TimeUnit;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        //noHaveParam();
        //haveParam();
        callback();
    }

    //任务没有参数
    private static void noHaveParam() throws InterruptedException {
        FutureService<Void, Void> service = FutureService.newService();
        Future<?> future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("I am finish done.");
        });
        //get会使当前线程进入阻塞
        //future.get();
    }

    //任务有参数
    private static void haveParam() {
        FutureService<String, Integer> service = FutureService.newService();
        Future<Integer> future = service.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return input.length();
        }, "Hello");
        //
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //回调函数 接收结果
    private static void callback() {
        FutureService<String, Integer> service = FutureService.newService();
        Future<Integer> future = service.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "Hello",System.out::println);
    }
}
