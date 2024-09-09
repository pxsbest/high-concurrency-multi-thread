package org.pinery;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/9/3 9:20
 * @Description
 **/
public class MainWeak {
    public static void main(String[] args) throws InterruptedException {
       // gcWeakReference();
        getGCReference();
    }


    //1.任何类型的GC都可导致WeakReference对象被回收
    static void gcWeakReference() {
        Reference ref = new Reference();
        WeakReference<Reference> reference = new WeakReference<>(ref);
        ref = null;
        System.gc();
    }

    //2.获取被垃圾回收器回收的对象
    static void getGCReference() throws InterruptedException {
        //被垃圾回收的Reference 会被加入到与之 关联的 Queue中
        ReferenceQueue<Reference> queue = new ReferenceQueue<>();
        Reference ref = new Reference();
        //定义 WeakReference 并且指定关联的 Queue
        WeakReference<Reference> reference = new WeakReference<>(ref, queue);
        ref = null;
        System.out.println(reference.get());

        //手动执行gc操作
        System.gc();
        //make sure GC thread triggered
        TimeUnit.SECONDS.sleep(1);
        //remove 方法是阻塞方法
        java.lang.ref.Reference<? extends Reference> gcedRef = queue.remove();
        //被垃圾回收之后,会从队列中获得
        System.out.println(gcedRef);
    }
}
