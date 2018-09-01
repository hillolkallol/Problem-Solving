/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 93. Restore IP Addresses
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */
import java.util.*;
public class Leetcode_93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int s_len = s.length();
        
        for (int i = 1; i < 4 && i < s_len-2; i++) {
            for (int j = i; j < i + 4 && j < s_len-1; j++) {
                for (int k = j; k < j + 4 && k < s_len; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, s_len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        list.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        
        return list;
    }
    
    public boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || Integer.parseInt(s) > 255 || (s.charAt(0) == '0' && s.length() > 1))
            return false;
        return true;
    }
}
