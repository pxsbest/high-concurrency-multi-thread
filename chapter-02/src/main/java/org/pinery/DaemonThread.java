package org.pinery;

/**
 * 守护进程
 **/
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while (true){
                try{
                    Thread.sleep(1);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });
        //将thread设置为守护线程
        thread.setDaemon(true);

        thread.start();
        Thread.sleep(2_000L);
        System.out.println("Main thread finished lifecycle.");
    }
}
