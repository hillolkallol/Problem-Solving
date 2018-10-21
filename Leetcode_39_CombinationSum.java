/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 39. Combination Sum
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
import java.util.*;
public class Leetcode_39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                helper(res, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
