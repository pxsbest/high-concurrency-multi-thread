package org.pinery;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author gensci
 * @DateTime 2024/8/30 8:33
 * @Description
 **/
public class LRUCache<K, V> {
    //用于记录 key值的顺序
    private final LinkedList<K> keyList = new LinkedList<>();
    //用于存放数据
    private final Map<K, V> cache = new HashMap<>();
    //cache的最大容量
    private final int capacity;
    //cacheLoader接口提供了一种加载数据的方式
    private final CacheLoader<K,V> cacheLoader;

    public LRUCache(int capacity,CacheLoader<K,V> cacheLoader) {
        this.capacity=capacity;
        this.cacheLoader = cacheLoader;
    }

    public void put(K key, V value) {
        //当元素数量超过容量时,将最老的数据清除
        if (keyList.size() >= capacity) {
            K eldestKey = keyList.removeFirst();
            cache.remove(eldestKey);
        }
        //数据已经存在,则从key的队列中清除
        if (keyList.contains(key)) {
            keyList.remove(key);
        }
        //将key放到队尾
        keyList.addLast(key);
        cache.put(key, value);
    }

    public V get(K key) {
        V value;
        //先将key从key list 中删除
        boolean success = keyList.remove(key);
        if (!success) {
            //如果删除失败则表明该数据不存在
            value = cacheLoader.load(key);
            //调用put方法cache数据
            this.put(key,value);
        }
        else {
            //如果删除成功,则从cache中返回数据,并且将key再次放到队尾
            value = cache.get(key);
            keyList.addLast(key);
        }
        return value;
    }

    @Override
    public String toString() {
        return this.keyList.toString();
    }
}
