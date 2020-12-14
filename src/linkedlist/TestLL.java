package linkedlist;

import org.junit.Test;

public class TestLL {

    @Test
    public void test(){
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(s.isPalindrome(l1));

    }
}
