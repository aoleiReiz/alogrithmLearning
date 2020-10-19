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

    public void reorderList(ListNode head) {

    }

}
