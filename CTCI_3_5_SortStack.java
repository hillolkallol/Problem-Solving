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

public class CTCI_3_5_SortStack {
    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> new_stack = new Stack<>();
        
        while(!stack.isEmpty()) {
            int stack_item = stack.pop();
            while (!new_stack.isEmpty() && stack_item < new_stack.peek()) {
                stack.push(new_stack.pop());
            }
            new_stack.push(stack_item);
        }
        
        while (!new_stack.isEmpty()) {
            stack.push(new_stack.pop());
        }
    }
}
