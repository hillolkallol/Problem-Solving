/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 295. Find Median from Data Stream
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
import java.util.*;
public class Leetcode_295_FindMedianfromDataStream {
    
}
class MedianFinder {
    Queue<Integer> lower;
    Queue<Integer> higher;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        lower = new PriorityQueue<>((a,b) -> b - a);
        higher = new PriorityQueue<>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        lower.offer(num); // adding
        higher.offer(lower.poll()); // balancing
        if (lower.size() < higher.size()) //maintain size
            lower.offer(higher.poll());
    }
    
    public double findMedian() {
        return lower.size() > higher.size() ? (double) lower.peek() : (double) (lower.peek() + higher.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */