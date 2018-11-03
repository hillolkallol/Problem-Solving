/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 346. Moving Average from Data Stream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
public class Leetcode_346_MovingAveragefromDataStream {
    
}
class MovingAverage {
    int size;
    int total;
    int idx;
    int currSize;
    int[] window;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        total = 0;
        idx = 0;
        int currSize = 0;
        window = new int[size];
    }
    
    public double next(int val) {
        total -= window[idx];
        total += val;
        window[idx] = val;
        idx = idx + 1 >= size ? 0 : idx + 1;
        currSize = currSize + 1 > size ? currSize : currSize + 1;
        
        return (double) total / currSize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */