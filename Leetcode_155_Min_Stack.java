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
public class Leetcode_155_Min_Stack {
    Stack<TrackMin> st = new Stack<>();
    // int newMin = Integer.MAX_VALUE;

    /** initialize your data structure here. */
//    public MinStack() {
//        
//    }
    
    public void push(int x) {
        int newMin = Integer.MAX_VALUE;
        if(!st.empty()) newMin = st.peek().newMin;
        if(newMin > x) newMin = x;
        st.push(new TrackMin(x, newMin));
    }
    
    public void pop() {
        if(!st.empty()) st.pop();
    }
    
    public int top() {
        if(!st.empty()) return st.peek().val;
        return 0;
    }
    
    public int getMin() {
        return st.peek().newMin;
    }
}
class TrackMin {
    int val;
    int newMin;
    TrackMin(int v, int m){
        val = v;
        newMin = m;
    }
}