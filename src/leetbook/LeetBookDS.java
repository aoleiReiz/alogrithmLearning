package leetbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetBookDS {

    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        reversePrintHelper(head, res);
        int size = res.size();
        int []ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    private void reversePrintHelper(ListNode node, List<Integer> res){
        if (null == node)
            return;
        if (node.next != null)
            reversePrintHelper(node.next, res);
        res.add(node.val);
    }

    //请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
    public boolean isNumber(String s) {
        s = s.toLowerCase().trim();
        if (s.equals(""))
            return false;
        int i = 0;
        boolean hasSingnalFalg = false;
        if (s.startsWith("+") || s.startsWith("-")){
            if (s.length()==1){
                return false;
            }else{
                i++;
            }
            hasSingnalFalg = true;
        }
        int countDot = 0;
        int digitCount = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (c == '+' || c=='-'){
                if (hasSingnalFalg)
                    return false;
                if (c == '-' && s.charAt(i-1) != 'e')
                    return false;
            }
            if (c == 'e'){
                if (hasSingnalFalg && i != 2)
                    return false;
                if (!hasSingnalFalg && i != 1)
                    return false;
            }
            if (c == '.'){
                countDot ++;
                if (countDot > 1)
                    return false;
            }
            if (Character.isLetter(c) || Character.isSpaceChar(c))
                return false;
            if (Character.isDigit(c))
                digitCount++;
            i++;
        }
        return digitCount >= 1;
    }

    //给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int []ret = new int[n - k + 1];
        int idx = 0;
        for (int l = 0; l <= n-k ; l++) {
            int curMax = Integer.MIN_VALUE;
            for (int i = l; i < l+k; i++) {
                if (nums[i] > curMax)
                    curMax = nums[i];
            }
            ret[idx++] = curMax;
        }
        return ret;
    }
}
