/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 1.1
 * Given two strings, write a method to decide if one is a permutation of other
 * 
 */
import java.util.*;
public class CTCI_1_2_Check_Permutation {
    public boolean checkPermutation(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        
        for(int i=0; i<s1.length(); i++){
            Integer value = hashMap.get(String.valueOf(s1.charAt(i)));
            if(value != null){
                hashMap.put(String.valueOf(s1.charAt(i)), value + 1);
            }
            else
                hashMap.put(String.valueOf(s1.charAt(i)), 1);
        }
        
        for(int i=0; i<s2.length(); i++){
            if((hashMap.get(String.valueOf(s2.charAt(i))) == null) || (hashMap.get(String.valueOf(s2.charAt(i))) == 0)){
                return false;
            }
            hashMap.put(String.valueOf(s2.charAt(i)), hashMap.get(String.valueOf(s2.charAt(i))) - 1);
        }
        return true;
    }
    
    public static void main(String[] args){
        CTCI_1_2_Check_Permutation cI_1_2_Check_Permutation = new CTCI_1_2_Check_Permutation();
        System.out.println(cI_1_2_Check_Permutation.checkPermutation("hel lol hh", "hhh ell ol"));
    }
}
