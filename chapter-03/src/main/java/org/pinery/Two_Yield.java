package org.pinery;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author gensci
 * @DateTime 2024/6/26 12:52
 * @Description
 **/
public class Two_Yield {
    public static void main(String[] args) throws InterruptedException {
        //包含0不包含2
        //mapToObj(): 0,1 两个元素分别作为参数 调用 create()方法, 返回结果是调用上述方法之后的返回结果

        for (int i = 0; i <10; i++) {
            System.out.println("===========");
            IntStream.range(0, 2).mapToObj(Two_Yield::create)
                    .forEach(Thread::start);
            TimeUnit.MILLISECONDS.sleep(500);
        }


    }

    /**
     * yield 仅主动告诉CPU调度器释放 原本属于自己的资源,
     * 但是 这只是一个提示(hint),CPU调度器并不会担保每次都能满足 yield 提示
     */
    private static Thread create(int index) {
        Thread thread = new Thread(() -> {
            if (index == 0) {
                Thread.yield();
            }
            System.out.println(index);
        });

        System.out.println("线程ID:"+thread.getId());
        System.out.println("线程默认级别:"+thread.getPriority());
        return thread;
    }


}
