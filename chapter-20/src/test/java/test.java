import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 *
 **/

public class test {

    @Test
    void testThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try{
                TimeUnit.SECONDS.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        thread.setDaemon(false);
        thread.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程结束");

    }
}
