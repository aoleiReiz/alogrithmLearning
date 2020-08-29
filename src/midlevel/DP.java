package midlevel;

import java.util.Arrays;

public class DP {

    //跳跃游戏, beats 6.5%
    public boolean canJump(int[] nums) {
        if (null == nums || nums.length <= 1){
            return true;
        }
        int N = nums.length;
        boolean []r = new boolean[N];
        r[0] =  true;

        for (int i = 0; i < N - 1 ; i++) {
            if (!r[i]){
                return false;
            }
            int j = nums[i];
            if (i + j >= N-1)
                return true;
            for (int k = 1; k <= j && i + k < N ; k++) {
                r[i + k] = true;
            }
        }
        return false;
    }
    //跳跃游戏 , beats 79%
    public boolean canJump2(int[] nums) {
        if (null == nums || nums.length <= 1){
            return true;
        }
        int N = nums.length;
        int r = 0;

        for (int i = 0; i < N - 1 ; i++) {
            if (i > r){
                return false;
            }
            int j = nums[i];
            r = Math.max(i + j, r);
            if (r >= N-1)
                return true;
        }
        return false;
    }

    //不同路径
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int ret = 0;
        for (int i = coins.length - 1; i >= 0 ; i--) {
            ret += amount / coins[i];
            amount = amount % coins[i];
        }
        return amount == 0 ? ret : -1;
    }
}
