package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * LRU(Least Recently User,最近最少使用)
 **/
public class Main {
    public static void main2(String[] args) {
        int capacity = 50;
        LRUCache<String, Reference> cache = new LRUCache<>(capacity, key -> new Reference());
        cache.get("Alex");
        cache.get("Jack");
        cache.get("Gavin");
        cache.get("Dillon");
        cache.get("Leo");
        //Alex将被删除
        cache.get("Jenny");
        System.out.println(cache);
    }

    //测试内存溢出
    public static void main(String[] args) throws InterruptedException {
        int capacity = 200;
        LRUCache<Object, Reference> cache = new LRUCache<>(capacity, key -> new Reference());
        for (int i = 0; i < 100000; i++) {
            cache.get(i);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The " + i + " reference staored at cache");
        }
    }


}