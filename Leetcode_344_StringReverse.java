/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class Leetcode_344_StringReverse {
    // public String reverseString(String s) {
    //     int s_len = s.length();
    //     StringBuffer sb = new StringBuffer(s_len);
    //     for (int i = s_len - 1, j = 0; i >= 0; i--) {
    //         sb.append(s.charAt(i));
    //         j++;
    //     }
    //     return sb.toString();
    // }
    
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int low = 0, high = s.length() - 1;
        
        while(low < high) {
            char cr = arr[low];
            arr[low] = arr[high];
            arr[high] = cr;
            low++;
            high--;
        }
        return new String(arr);
    }
}
