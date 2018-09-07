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
 * 46. Permutations
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
* 
 */
import java.util.*;
public class Leetcode_46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), new HashSet<>(), result);
        return result;
    }
    
    public void permute(int[] nums, List<Integer> list, Set<Integer> set, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        else {
            for (int i= 0; i<nums.length; i++) {
                if (!set.contains(nums[i])) {
                    list.add(nums[i]);
                    set.add(nums[i]);
                    
                    permute(nums, list, set, result);
                    
                    set.remove(list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
