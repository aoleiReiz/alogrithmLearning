package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n) return head;
        int curIndex = 0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (curIndex != m-1){
            prev = prev.next;
            curIndex ++;
        }
        ListNode temp = prev.next;
        ListNode prev1 = prev.next;
        ListNode cur = prev1.next;
        curIndex ++;
        while (curIndex < n){
            ListNode next = cur.next;
            cur.next = prev1;
            prev1 = cur;
            cur = next;
            curIndex ++;
        }

        temp.next = cur;
        prev.next = prev1;
        return dummyHead.next;

    }

    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val+ "->");
            head = head.next;
        }
        System.out.println("->null");
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode cur1 = dummyHead;
        ListNode cur2 = dummyHead2;

        while (head != null){
            if (head.val >= x){
                cur2.next = head;
                cur2 = head;
            }else {
                cur1.next = head;
                cur1 = head;
            }
            head = head.next;
        }
        cur1.next = dummyHead2.next;
        cur2.next = null;
        return dummyHead.next;
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p = root;
        int len = 0;
        while (p != null){
            len ++;
            p = p.next;
        }
        int x = len/ k;
        int y = len - x * k;

        ListNode []res = new ListNode[k];
        if (len == 0)return res;
        int resIndex = 0;
        p = root;
        while (resIndex < y){
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            int i = 1;
            while (i <= x + 1){
                cur.next = p;
                cur = p;
                p = p.next;
                i++;
            }
            cur.next = null;
            res[resIndex++] = dummyHead.next;
        }
        while (p != null){
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            int i = 1;
            while (i <= x){
                cur.next = p;
                cur = p;
                p = p.next;
                i++;
            }
            cur.next = null;
            res[resIndex++] = dummyHead.next;
        }
        return res;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        ListNode ret = null;
        Set<ListNode>set = new HashSet<>();
        while (p1 != null){
            set.add(p1);
            p1 = p1.next;
        }
        while (p2 != null){
            if (set.contains(p2)){
                ret = p2;
                break;
            }
            p2 = p2.next;
        }

        return ret;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        int len = 0;
        while (p1 != null){
            p1 = p1.next;
            len ++;
        }
        if (len <= 1)return true;
        p1 = head;
        int i = 0;
        int halfIndex = len % 2 == 0 ? len / 2 : len / 2;
        while (i < halfIndex){
            p1 = p1.next;
            i++;
        }

        ListNode prev = head, cur = head.next;
        while (cur != p1 ){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        ListNode p2 = prev;
        if (len % 2 == 1)
            p1 = p1.next;
        while (p1 != null){
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
