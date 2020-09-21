package jianzhioffer;

public class Solution {
    public int[] constructArr(int[] a) {
        if (null == a || a.length == 0)
            return new int[]{};
        int n = a.length;
        int []prev = new int[n];
        int []after = new int[n];
        int []b = new int[n];
        prev[0] = 1;
        for (int i = 1; i < n; i++) {
           prev[i] = prev[i-1] * a[i-1];
        }
        after[n-1] = 1;
        for (int i = n-2; i >= 0 ; i--) {
            after[i] = after[i+1] * a[i+1];
        }

        for (int i = 0; i < n; i++) {
            b[i] = prev[i] * after[i];
        }
        return b;
    }
}
