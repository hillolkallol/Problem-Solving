/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode_771;

/**
 *
 * @author KD
 * 
 * 771. Jewels and Stones
 * 
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */
public class Leetcode_771_Jewels_and_Stones {
    
}
// class Solution{
//     public int numJewelsInStones(String J, String S){
//         HashMap<Character, Integer> hm = new HashMap<>();
//         char newChar;
//         int num;
        
//         for (int i=0; i<S.length(); i++){
//             newChar = S.charAt(i);
//             if(hm.containsKey(newChar)){
//                 num = hm.get(newChar);
//                 num++;
//                 hm.put(newChar, num);
//             }
//             else
//                 hm.put(newChar, 1);
//         }
        
//         int count = 0;
//         for (int j=0; j<J.length(); j++){
//             if(hm.containsKey(J.charAt(j)))
//                 count += hm.get(J.charAt(j));
//         }
//         return count;
//     }
// }

class Solution{
    public int numJewelsInStones(String J, String S){
        int[] arr = new int[128];
        int count = 0;
        
        for(char c: S.toCharArray())
            arr[c]++;
        
        for(char c: J.toCharArray())
            count += arr[c];
        
        return count;
    }
}

