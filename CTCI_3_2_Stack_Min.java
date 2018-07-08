/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 3.2
 * 
 * 3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * 
 * 
 */
import java.util.*;

class MyStack {
    int val;
    int min;
    public MyStack(int v, int m){
        val = v;
        min = m;
    }
}
public class CTCI_3_2_Stack_Min extends Stack<MyStack>{
    public void push(int value){
        int newMin = Math.min(value, min());
        super.push(new MyStack(value, newMin));
    }
    
    public int min(){
        if (this.isEmpty()){
            return Integer.MAX_VALUE;
        }
        else{
            return peek().min;
        }
    }
}
