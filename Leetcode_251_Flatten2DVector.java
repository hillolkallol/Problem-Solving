/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 251. Flatten 2D Vector
Implement an iterator to flatten a 2d vector.

Example:

Input: 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
Output: [1,2,3,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,2,3,4,5,6].
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
import java.util.*;
public class Leetcode_251_Flatten2DVector {
    
}
class Vector2D implements Iterator<Integer> {
    int countListList;
    int countList;
    int length;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        countListList = 0;
        countList = 0;
        length = vec2d.size();
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        return vec2d.get(countListList).get(countList++);
        
    }

    @Override
    public boolean hasNext() {
        while (countListList < length) {
            if (countList < vec2d.get(countListList).size()){
                return true;
            }
            else {
                countListList++;
                countList = 0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */