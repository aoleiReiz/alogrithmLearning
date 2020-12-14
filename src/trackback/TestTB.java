package trackback;

import org.junit.Test;

import java.util.List;

public class TestTB {

    @Test
    public void test(){
        TrackBack t = new TrackBack();

        List<List<Integer>> r = t.combine(4, 2);
        for (List<Integer> x : r) {
            for (int s : x) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
