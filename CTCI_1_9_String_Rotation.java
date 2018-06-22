/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * cracking the coding interview 1.9
 * 
 * assume you have a method isSubstring which checks if one word is a substring of another. given two strings, s1 and s2, write 
 * code to check if s2 is a rotation of s1 using only one call to isSubstring.
 * 
 */
public class CTCI_1_9_String_Rotation {
    
    boolean isRotation(String s1, String s2){
        int len = s1.length();
        
        if (len == s2.length() && len > 0){
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1s1, String s2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
