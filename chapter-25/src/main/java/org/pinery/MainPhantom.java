package org.pinery;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 幻影引用
 **/
public class MainPhantom {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<Reference> queue = new ReferenceQueue<>();
        PhantomReference<Reference> reference = new PhantomReference<>(new Reference(), queue);
        System.out.println(reference.get());
        System.gc();
        java.lang.ref.Reference<? extends Reference> gcedRef = queue.remove();
        System.out.println(gcedRef);
        System.out.println("end");
    }



}
