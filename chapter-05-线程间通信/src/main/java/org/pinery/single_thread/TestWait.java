package org.pinery.single_thread;

/**
 * @Author gensci
 * @DateTime 2024/7/11 17:01
 * @Description
 **/
public class TestWait {
    public static void main(String[] args) {
        TestWait obj=new TestWait();
        try {
            /*
            * 报错: wait()和notify()方法必须在 同步方法中执行
            * */
            obj.wait();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
