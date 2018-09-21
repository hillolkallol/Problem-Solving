/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 763. Partition Labels
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

 */
import java.util.*;
public class Leetcode_763_PartitionLabels {
    
}
class Solutionrr {
    
    public List<Integer> partitionLabels(String S) {
        int s_len = S.length();
        int[] str_arr = new int[26];
        
        for (int i = 0; i < s_len; i++) {
            str_arr[S.charAt(i) - 'a'] = i;
        } 
        
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i<s_len; i++) {
            end = Math.max(end, str_arr[S.charAt(i) - 'a']);
            
            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return ans;
    }
    
//     public List<Integer> partitionLabels(String S) {
//         int s_len = S.length();
//         List<Integer> list = new ArrayList<>();
//         if (S == null || s_len == 0) {
//             list.add(0);
//             return list;
//         }
//         if (s_len == 1) {
//             list.add(1);
//             return list;
//         }
        
//         int first_pointer = 0;
//         int second_pointer = 0;
        
//         for (int i = 0; i < s_len; i++) {
//             for (int j = second_pointer; j < s_len; j++) {
//                 if (S.charAt(i) == S.charAt(j))
//                     second_pointer = j;
//             }
//             if (i == second_pointer) {
//                 list.add(second_pointer-first_pointer+1);
//                 first_pointer = second_pointer+1;
//                 second_pointer = first_pointer;
//             }
//         }
        
//         return list;
//     }
}