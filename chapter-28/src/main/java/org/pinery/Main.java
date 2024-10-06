package org.pinery;

import org.pinery.test.SimpleSubscriber1;
import org.pinery.test.SimpleSubscriber2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author gensci
 * @DateTime 2024/9/20 14:51
 * @Description
 **/
public class Main {
    public static void main(String[] args) {
//syncBusTest();
asyncBusTest();
    }

    static void syncBusTest() {
        Bus bus = new EventBus("TestBus");
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("Hello");
        System.out.println("--------------");
        bus.post("Hello", "test");
    }

    static void asyncBusTest() {
        Bus bus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("Hello");
        System.out.println("--------------");
        bus.post("Hello", "test");
    }
}





