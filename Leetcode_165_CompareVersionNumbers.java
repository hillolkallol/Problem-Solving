/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 165. Compare Version Numbers
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1

 */
public class Leetcode_165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        boolean flagv1 = false, flagv2 = false;
        while (i < v1.length || i < v2.length) {
            if (i < v1.length && i < v2.length) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) return -1;
                else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) return 1;
            }
            else if (i < v1.length && Integer.parseInt(v1[i]) > 0) flagv1 = true;
            else if (i < v2.length && Integer.parseInt(v2[i]) > 0) flagv2 = true;
            i++;
        }
        if (flagv1) return 1;
        if (flagv2) return -1;
        
        return 0;
    }
}
