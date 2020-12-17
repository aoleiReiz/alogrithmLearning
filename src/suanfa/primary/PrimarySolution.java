package suanfa.primary;

public class PrimarySolution {

    public int removeDuplicates(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (k == -1 || nums[i] != nums[k]){
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }

    //买卖股票的最佳时机II
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0 || prices.length == 1)
            return 0;
        // greedy
//        int profit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            if(prices[i] > prices[i-1]){
//                profit += prices[i] - prices[i-1];
//            }
//        }
//        return profit;
        // dp
        int prev_0 = 0;
        int prev_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            prev_0 = Math.max(prev_0, prev_1 + prices[i]);
            prev_1 = Math.max(prev_0-prices[i], prev_1);
        }
        return prev_0;
    }

    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public int maxProfit(int[] prices, int fee) {
        if(null == prices || prices.length == 0 || prices.length == 1)
            return 0;
        int prev_0 = 0;
        int prev_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            prev_0 = Math.max(prev_0, prev_1 + prices[i] - fee);
            prev_1 = Math.max(prev_0-prices[i], prev_1);
        }
        return prev_0;
    }


    private void reverseArray(int []nums, int l, int r){
        int i = l, j = r;
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        if (null == nums || nums.length == 0||k==0) return;
        k = k % nums.length;
        reverseArray(nums,0, nums.length-1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length-1);
    }
}
