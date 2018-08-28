/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
import java.util.*;
public class Leetcode_6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<StringBuilder> maplist = new ArrayList<>();
        
        for (int i=0; i<Math.min(numRows, s.length()); i++) maplist.add(new StringBuilder());
        
        int row = 0;
        boolean flag = true;
        for (char c: s.toCharArray()) {
            maplist.get(row).append(c);
            
            if (flag) {
                if (row == numRows-1) {
                    row--;
                    flag = false;
                }
                else row ++;
            }
            else {
                if(row == 0) {
                    row++;
                    flag = true;
                }
                else row--;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder st: maplist) {
            result.append(st);
        }
        
        return result.toString();
    }
}
