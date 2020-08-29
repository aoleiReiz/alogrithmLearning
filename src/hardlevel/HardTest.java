package hardlevel;

public class HardTest {

    public static void main(String[] args) {
        int []nums = {8,2,3,5,10};
        Solution s = new Solution();
        s.mergeSort(nums,0,4);
        for (int i : nums)
            System.out.println(i);
    }
}
