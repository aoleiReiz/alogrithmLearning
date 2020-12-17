package algo;

import java.util.*;

public class Solution {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i : nums){
            single = single ^ i;
        }
        return single;
    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();

        for (int i : nums){
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i,count);
        }
        for (Map.Entry<Integer,Integer>entry : map.entrySet()){
            if (entry.getValue() > nums.length / 2)
                return entry.getKey();
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r = m-1, c = 0;
        while (r >= 0 && c < n){
            if (matrix[r][c] == target)return true;
            else if (matrix[r][c] > target) r--;
            else c++;
        }
        return false;
    }

    private void wordBreakTB(String s, int start, boolean []flags, Set<String>wordDict){
        if (start == s.length()){
            flags[0] = true;
            return;
        }
        if (!flags[0]){
            for (int i = start + 1; i <= s.length(); i++) {
                String w = s.substring(start, i);
                if (wordDict.contains(w)){
                    wordBreakTB(s, i, flags, wordDict);
                }
            }
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>words = new HashSet<>(wordDict);
        boolean []flags = new boolean[1];
        wordBreakTB(s, 0, flags, words);
        return flags[0];
    }
}
