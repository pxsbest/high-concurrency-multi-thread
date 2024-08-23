import org.junit.jupiter.api.Test;
import org.omg.CORBA.TIMEOUT;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/8/15 11:22
 * @Description
 **/
public class test {


    @Test
    void testThread() {
        Object mutex=new Object();

        new Thread(()->{
            System.out.println("线程2启动");
            synchronized (mutex) {
                try{
                    System.out.println("线程2 进入");
                    TimeUnit.SECONDS.sleep(50);

                }catch (InterruptedException e){

                }
            }

        }).start();

        new Thread(()->{
            System.out.println("线程1启动");
            synchronized (mutex) {
                try{
                    System.out.println("线程1 进入");
                    TimeUnit.SECONDS.sleep(100);

                }catch (InterruptedException e){

                }
            }
        }).start();

        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {

        }
    }



    @Test
    void test() {
        String t = null;
        String s = Optional.ofNullable(t).orElse("666");
        System.out.println(s);
        //System.out.println(123);
    }


    @Test
    void testDis() {
        System.out.println(1 * 100 / 3);
        System.out.println(Math.floor(2 * 100 / 3) );
        System.out.println(Math.ceil(2 * 100 / 3) );
        System.out.println(Math.round(2 * 100.0 / 3) );


    }



}
