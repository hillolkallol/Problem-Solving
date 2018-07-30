/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 49. Group Anagrams
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
* 
 */
import java.util.*;
public class Leetcode_49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str: strs) {
            char[] str_arr = str.toCharArray();
            Arrays.sort(str_arr);
            String new_str = new String(str_arr);
            
            if (map.containsKey(new_str)) {
                List<String> arrlist = map.get(new_str);
                arrlist.add(str);
            }
            else {
                List<String> arrlist = new ArrayList<>();
                arrlist.add(str);
                map.put(new_str, arrlist);
            }
        }
        
        List<List<String>> list = new ArrayList<>();
        for (List<String> value: map.values()) {
            list.add(value);
        }
        
        return list;
    }
}
