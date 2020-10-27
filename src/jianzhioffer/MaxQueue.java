package jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {

    Queue<Integer>queue;
    Deque<Integer>deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.size() > 0 ? deque.peek() : -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (deque.size() > 0 && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        int head = queue.size() > 0 ? queue.poll() : -1;
        if(deque.size() > 0 && deque.peek().equals(head)){
            deque.poll();
        }
        return head;
    }
}

