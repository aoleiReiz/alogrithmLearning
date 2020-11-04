package daily;

import com.sun.source.doctree.StartElementTree;

import java.util.*;

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

    public boolean isLongPressedName(String name, String typed) {
        if (null == name && null == typed) return true;
        if (null != name && name.equals(typed)) return true;
        if (null != name && name.length() > typed.length()) return false;
        if (null == name) return false;
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()){
            if (name.charAt(i) != typed.charAt(j))
                return false;
            if (i == name.length() - 1 && j==typed.length()-1){
                return true;
            }else if (i == name.length() - 1 && j<typed.length() - 1){
                while (j < typed.length() && typed.charAt(j) == name.charAt(i))
                    j++;
                if (j == typed.length())
                    return true;
                return false;
            }else{
                if (name.charAt(i) == name.charAt(i+1)){
                    i++;
                    j++;
                }else {

                    while (j < typed.length() && typed.charAt(j) == name.charAt(i))
                        j++;
                    if (j == typed.length())
                        return false;
                    i ++;
                }
            }
        }
        return true;
    }

    public List<Integer> partitionLabels(String S) {
        int []last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i)-'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }

        return partition;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer>countMap = new HashMap<>();
        for (int i : arr) {
            if (countMap.containsKey(i)){
                int c = countMap.get(i) + 1;
                countMap.put(i, c);
            }else{
                countMap.put(i, 1);
            }
        }
        Set<Integer>set = new HashSet<>();
        for (int i : countMap.values()){
            if (set.contains(i)){
                return false;
            }else {
                set.add(i);
            }
        }
        return true;
    }

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(null == root) return 0;
        sumNumbersHelper(root, "");
        return sum;
    }

    private void sumNumbersHelper(TreeNode node, String curSum){
        curSum += node.val;
        if (node.left != null) {
            sumNumbersHelper(node.left, curSum);

        }
        sumNumbersHelper(node.right, curSum);
        curSum = curSum.substring(0, curSum.length()-1);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String>wordSet, int index, Map<Integer,List<List<String>>>map){
        if (!map.containsKey(index)){
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length){
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index+1; i <= length ; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)){
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String>nextWordBreak : nextWordBreaks){
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>wordSet = new HashSet<>(wordList);
        Set<Character>characterSet = new HashSet<>();
        Set<String>visited = new HashSet<>();

        for (String word : wordList){
            for (char c : word.toCharArray()){
                characterSet.add(c);
            }
        }
        Queue<String>queue = new ArrayDeque<>();
        visited.add(beginWord);
        for (int i = 0; i < beginWord.length(); i++) {
            for (char c : characterSet){
                String newWord = beginWord.substring(0,i) + c + beginWord.substring(i+1);
                if (newWord.equals(endWord)){
                    return 2;
                }
                if (wordSet.contains(newWord)) {
                    queue.add(newWord);
                    visited.add(newWord);
                }
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.remove();
                for (int j = 0; j < curWord.length(); j++) {
                    for (char c : characterSet){
                        String newWord = curWord.substring(0,j) + c + curWord.substring(j+1);
                        if (newWord.equals(endWord)){
                            return count + 2;
                        }
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
