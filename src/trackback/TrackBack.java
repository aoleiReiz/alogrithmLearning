package trackback;

import java.util.*;


public class TrackBack {

    public List<String> letterCombinations(String digits) {
        List<String>res = new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        letterCombinationsTrackbackHelper(digits, "", 0, map, res);

        return res;
    }
    private void letterCombinationsTrackbackHelper(String digits, String cur, int index,
                                                   Map<Character,String>map, List<String>res){
        if (index >= digits.length()){
            if (!cur.equals(""))
                res.add(cur);
            return;
        }
        char key = digits.charAt(index);
        if (map.containsKey(key)){
            String value = map.get(key);
            for (char c : value.toCharArray()){
                letterCombinationsTrackbackHelper(digits, cur + c, index + 1, map, res);
            }
        }
        return;
    }

    private boolean is_valid_ip_number(String num){
        if (num.startsWith("0") && num.length() > 1)
            return false;
        return Integer.parseInt(num) >= 0 && Integer.parseInt(num) <= 255;
    }
    private void restoreIpAddressesBTHelper(String s, String cur, List<String>path, int index, List<String> res){
        if (index >= s.length() && path.size() == 4){
            res.add(String.join(".",path));
            return;
        }
        if (path.size() >= 4)
            return;

        for (int i = index + 1; i <= index + 3; i++) {
            if (i > s.length())
                continue;
            cur = s.substring(index, i) ;
            if (is_valid_ip_number(cur)){
                path.add(cur);
                restoreIpAddressesBTHelper(s, "", path,i, res);
                path.remove(path.size()-1);
            }
        }
        return;
    }
    //https://leetcode-cn.com/problems/restore-ip-addresses/
    public List<String> restoreIpAddresses(String s) {
        List<String>res = new ArrayList<>();
        if (s.length()>3){
            restoreIpAddressesBTHelper(s,"", new ArrayList<>(),0, res);
        }
        return res;
    }

    private boolean isPalindrome(String s){
        if (s.length()<=1) return true;
        int i = 0, j = s.length()-1;

        while (i < j){
            if (s.charAt(i)!=s.charAt(j))
                return false;
            i ++;
            j --;
        }
        return true;
    }
    private void partitionHelper(String s, int index, List<String>path, List<List<String>>res){
        if (index >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index+1; i <= s.length(); i++) {
            String s1 = s.substring(index, i);
            if (isPalindrome(s1)){
                path.add(s1);
                partitionHelper(s, i, path,res);
                path.remove(path.size()-1);
            }
        }
    }
    //https://leetcode-cn.com/problems/palindrome-partitioning/
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (null != s && s.length() > 0){
            partitionHelper(s, 0, new ArrayList<>(), res);
        }
        return res;
    }

    private void permuteHelper(int []nums, int index, boolean []used, List<Integer>list, List<List<Integer>>res){
        if (index >= nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                list.add(nums[i]);
                used[i] = true;
                permuteHelper(nums, index +1, used, list, res);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
    //https://leetcode-cn.com/problems/permutations/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean []used = new boolean[nums.length];
        permuteHelper(nums, 0, used, new ArrayList<>(), res);
        return res;
    }

    private void permuteIIHelper(int []nums, int index, boolean []used, List<Integer>list, List<List<Integer>>res){
        if (index >= nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]&& !used[i-1])
                continue;
            if (!used[i]){
                list.add(nums[i]);
                used[i] = true;
                permuteIIHelper(nums, index +1, used, list, res);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
    //https://leetcode-cn.com/problems/permutations-ii/
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean []used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteIIHelper(nums, 0, used, new ArrayList<>(), res);
        return res;
    }


    private void combineHelper(int n, int k, int start, List<Integer>curPath, List<List<Integer>> res){
        if (curPath.size() == k){
            res.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = start; i <=n ; i++) {
            curPath.add(i);
            combineHelper(n, k, i+1, curPath, res);
            curPath.remove(curPath.size()-1);
        }
        return;
    }
    //https://leetcode-cn.com/problems/combinations/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n > 0 && k > 0){
            combineHelper(n, k, 1, new ArrayList<>(), res);
        }
        return res;
    }

}
