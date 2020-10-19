package daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailySolution {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#'){
                if (!stack1.empty()){
                    stack1.pop();
                }
            }else {
                stack1.push(c);
            }
        }

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#'){
                if (!stack2.empty()){
                    stack2.pop();
                }
            }else {
                stack2.push(c);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        while (!stack1.empty()){
            sb1.append(stack1.pop());
        }
        StringBuilder sb2 = new StringBuilder();
        while (!stack2.empty()){
            sb2.append(stack2.pop());
        }

        return sb1.toString().equals(sb2.toString());
    }

    public void reorderList(ListNode head) {
        if (null == head || head.next == null)
            return;
        List<ListNode> list = new ArrayList<>();
        ListNode p =  head;
        while (p != null){
            list.add(p);
            p = p.next;
        }
        ListNode cur = new ListNode(-1);
        int i = 0, j = list.size()-1;
        while (i < j){
            ListNode p1 = list.get(i);
            ListNode p2 = list.get(j);
            p1.next = p2;
            cur.next = p1;
            cur = p2;
            i ++;
            j --;
        }
        if (i ==j) {
            cur.next = list.get(i);
            cur = cur.next;
        }
        cur.next = null;
    }
}
