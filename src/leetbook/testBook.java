package leetbook;

public class testBook {
    public static void main(String[] args) {
        LeetBookDS leetBookDS = new LeetBookDS();
        int []nums = {1,3,-1,-3,5,3,6,7};
        int []ret = leetBookDS.maxSlidingWindow(nums, 3);
    }
}
