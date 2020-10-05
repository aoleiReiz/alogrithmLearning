package binarysearch;

import java.util.Arrays;

public class Solution {

    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r){
            int mid = l + (r -l) / 2;
            if (eatingTime(piles, mid) <= H){
                r = mid;
            }
            else
                l = mid + 1;
        }
        return l;
    }
    private int eatingTime(int []piles, int k){
        int res = 0;
        for (int pile : piles){
            res += pile / k + (pile % k > 0 ? 1 : 0);
        }
        return res;
    }


    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l < r){
            int mid = l + (r - l)/ 2;
            if (isPossibleShipping(weights, D, mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean isPossibleShipping(int []weights, int D, int W){
        int count = 1;
        int curSum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (curSum + weights[i] <= W){
                curSum += weights[i];
            }else{
                curSum = weights[i];
                count += 1;
            }
        }
        return count <= D;
    }


    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (r - l)/ 2 + l;
            if (nums[mid] < target){
                l = mid + 1;
            }else if (nums[mid] > target){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int mySqrt(int x) {
        int l = 1, r = x, ans = -1;
        while (l <= r){
            int mid = (r -l) / 2 + l;
            long curSquared = (long) mid * mid;
            if (curSquared <= x){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }

    public int searchRotate(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        if (nums[0] > target && nums[n - 1] < target) return -1;
        int l = 0, r = n-1;
        while (l <= r){
            int mid = (r -l)/ 2 + l;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            else{
                if (nums[mid] < target && target <= nums[n-1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
