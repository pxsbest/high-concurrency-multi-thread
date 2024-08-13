import org.junit.jupiter.api.Test;
import org.pinery.MyMainAPP;
import org.pinery.enumm.Singleton;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author gensci
 * @DateTime 2024/8/9 9:48
 * @Description
 **/
@SpringBootTest(classes = MyMainAPP.class)
public class testCase {


    @Test
    void testList() {
        String s1 = (1* 100 / 3) + "%";
        System.out.println(s1);


        List<Integer> of = new ArrayList<>();
        of.add(1);of.add(2);of.add(3);
        String s = of.toString();
        System.out.println(s);
    }

    @Test
    void testEnum() {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

    }

    @Test
    void test() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

}
