/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 
 * Implement Stack using Queues
 * Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
import java.util.*;
public class Leetcode_225_ImplementStackusingQueues {
    
}
class MyStackaa{
    Queue<Integer> queue1, queue2;

    /** Initialize your data structure here. */
    public MyStackaa() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty() && queue2.isEmpty()) queue1.offer(x);
        else if (!queue1.isEmpty()) queue1.offer(x);
        else if (!queue2.isEmpty()) queue2.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) return -1;
        else if (queue1.isEmpty()) return popAll(queue2, queue1);
        else return popAll(queue1, queue2);
    }
    
    public int popAll(Queue<Integer> q1, Queue<Integer> q2) {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if (queue1.isEmpty() && queue2.isEmpty()) return -1;
        else if (queue1.isEmpty()) return topAll(queue2, queue1);
        else return topAll(queue1, queue2);
    }
    
    public int topAll(Queue<Integer> q1, Queue<Integer> q2) {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int res = q1.peek();
        q2.offer(q1.poll());
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */