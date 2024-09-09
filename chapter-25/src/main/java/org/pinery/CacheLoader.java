package org.pinery;

/**
 * @Author gensci
 * @DateTime 2024/8/30 8:35
 * @Description
 **/
@FunctionalInterface
public interface CacheLoader<K, V> {
    //定义加载数据的方法
    V load(K k);
}
