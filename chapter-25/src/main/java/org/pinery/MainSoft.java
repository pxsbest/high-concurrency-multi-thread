package org.pinery;

import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/9/3 8:21
 * @Description
 **/
public class MainSoft {
    public static void main(String[] args) throws InterruptedException {
        SoftLRUCache<Integer, Reference> cache = new SoftLRUCache<>(1000, key -> new Reference());
        System.out.println(cache);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            cache.get(i);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The "+i+" reference stored at cache.");
        }
    }
}
