package dp;

import daily.ListNode;

public class DPSolution {

    private int max3(int a, int b, int c){
        int x = Math.max(a, b);
        return Math.max(x, c);
    }

    public int integerBreak(int n) {
        int []memo = new int[n+1];
        memo[1] = 1;
        for (int i = 2; i<= n; i++){
            for (int j = 1; j < i; j++) {
                memo[i] = max3(memo[i], j * (i-j), j * memo[i-j]);
            }
        }
        return memo[n];
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int []dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
               if (nums[j] < nums[i]){
                   dp[i] = Math.max(dp[i],dp[j] + 1);
               }
            }
          maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
