/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
import java.util.*;

public class CTCI_3_4_QueueViaStacks {
    
}

class MyQueue<T> {
    Stack<T> newStack, oldStack;
    
    public MyQueue() {
        newStack = new Stack<>();
        oldStack = new Stack<>();
    }
    
    public int size() {
        return newStack.size() + oldStack.size();
    }
    
    public void push(T value) {
        newStack.push(value);
    }
    
    public void shiftStacks() {
        if (oldStack.isEmpty()) {
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
        }
    }
    
    public T peek() {
        shiftStacks();
        return oldStack.peek();
    }
    
    public T pop() {
        shiftStacks();
        return oldStack.pop();
    }
}
