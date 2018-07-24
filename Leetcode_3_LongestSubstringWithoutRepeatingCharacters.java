/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class Leetcode_3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int ans = 0, t_len = s.length();
        
        for(int i = 0, j = 0; j < t_len; j++){
            i = Math.max(arr[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            arr[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
