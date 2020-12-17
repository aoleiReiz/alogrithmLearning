package suanfa;

import org.junit.Test;
import suanfa.primary.PrimarySolution;

public class TestAlgorithm {

    PrimarySolution ps = new PrimarySolution();

    @Test
    public void test(){
        int []nums = {1,2,3,4,5,6,7};
        ps.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
