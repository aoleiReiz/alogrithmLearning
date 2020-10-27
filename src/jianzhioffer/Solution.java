package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

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


    private int binarySearch(int []nums, int target){
        int l = 0, r = nums.length-1;
        while (l <= r){
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0)return 0;
        int idx = binarySearch(nums, target);
        if (idx == -1) return 0;
        int i= idx - 1, j = idx + 1, count = 1;
        while (i >=0 && nums[i]==target){
            i--;
            count++;
        }
        while (j < nums.length && nums[j] == target){
            j++;
            count++;
        }
        return count;
    }

    public int[][] findContinuousSequence(int target) {
        int n = target / 2 + 1;
        List<int []> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int curSum = i + i + 1;
            int j = i + 2;
            while (j <= n && curSum < target){
                curSum += j;
                j++;
            }
            if (curSum == target){
                int []r = new int[j - i];
                for (int k = i; k < j; k++) {
                    r[k - i] = k;
                }
                list.add(r);
            }
        }
        int [][]ret = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int[][] findContinuousSequence2(int target) {
        int left = 1, right = 2;
        List<int []>res = new ArrayList<>();
        while (left < right){
            int sum = (right + left) * (right - left + 1)/ 2;
            if (sum == target){
                int []r = new int[right - left + 1];
                for (int i = left; i <= right ; i++) {
                    r[i - left] = i;
                }
                res.add(r);
                left++;
            }
            else if (sum < target){
                right ++;
            }else{
                left ++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
