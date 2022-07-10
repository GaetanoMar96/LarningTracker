package tracker;

import org.junit.jupiter.api.Test;
import tracker.controller.PointController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest {

    PointController pt = new PointController();
    @Test
    void test() {
        assertEquals(5, 2 + 3);
    }

    @Test
    void checkPoints() {
        List<String> data = new ArrayList<>();
        data.add("1000");
        data.add("600");
        data.add("400");
        data.add("0");
        data.add("0");
        String pattern = "^([0-9][0-9]{0,2}|1000)$";
        for (int i = 1; i < data.size(); i++) {
            System.out.println(i);
            if(data.get(i).matches(pattern))
                System.out.println("correct");
        }
    }
}
