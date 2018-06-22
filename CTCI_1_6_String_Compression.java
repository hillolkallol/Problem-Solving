/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * Cracking the coding interview 1.6
 * 
 * implrement a method to perform basic string compression using the counts of repeated characters. for example the string aabcccccaaa would 
 * be a2b1c5b3. if the compressed string would not become smaller than the original string, your method should
 * return the original string. you can assume the string has only uppercase and lowercase letter
 * 
 * 
 * 
 */
public class CTCI_1_6_String_Compression {
    public String stringCompression(String s){
        StringBuilder newString = new StringBuilder();
        int count = 1;
        char charc = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if (charc == s.charAt(i)){
                count++;
            }
            else{
                newString.append(charc);
                newString.append(count);
                charc = s.charAt(i);
                count = 1;
            }
        }
        newString.append(charc);
        newString.append(count);
        
        if(newString.length() >= s.length()) return s;
        return newString.toString();
    }
    
    public static void main(String[] args){
        CTCI_1_6_String_Compression cI_1_6_String_Compression = new CTCI_1_6_String_Compression();
        System.out.println(cI_1_6_String_Compression.stringCompression("aabcccccaaa"));
    }
}
