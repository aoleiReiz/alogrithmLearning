package array;

public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int l = 0; int r = -1; //arr[l,...,r] sum
        int res = nums.length + 1;
        int sum = 0;
        while (l < nums.length){
            if (r + 1 < nums.length && sum < s){
                sum += nums[++r];
            }else{
                sum -= nums[l++];
            }
            if (sum >= s){
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == nums.length + 1)
            return 0;
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int []freq = new int[256];
        int res = 0;
        int l = 0; int r = -1; //s[l,...r]是不重复子串
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r+1) - '0'] == 0){
                freq[s.charAt(++r) - '0']++;
            }else{
                freq[s.charAt(l++) - '0']--;
            }
            res = Math.max(res, r -l + 1);
        }
        return res;
    }
}
