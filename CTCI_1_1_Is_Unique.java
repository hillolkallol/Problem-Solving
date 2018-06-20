/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * Cracking the coding interview 1.1
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structure.
 * 
 */
import java.util.*;

public class CTCI_1_1_Is_Unique {

//    using hashmap
//    public boolean isUnique(String s) {
//        HashMap hashMap = new HashMap();
//        for (int i = 0; i < s.length(); i++) {
//            if (hashMap.get(s.charAt(i)) != null) {
//                return false;
//            }
//            hashMap.put(s.charAt(i), s.charAt(i));
////              System.out.println(s.charAt(i));
//        }
//        return true;
//    }
    
    //using sorting
//    public boolean isUnique(String s) {
//        char temArr[] = s.toCharArray();
//        Arrays.sort(temArr);
//        for(int i=1; i<temArr.length; i++){
//            if(temArr[i-1] == temArr[i]){
//                return false;
//            }
//        }
//        
//        return true;
//    }
    
    public boolean isUnique(String s){
        int check = 0;
        for(int i = 0; i<s.length(); i++){
            System.out.println(check);
            int val = s.charAt(i) - 'a';
            System.out.println(val);
            System.out.println(Integer.toBinaryString(check));
            System.out.println(Integer.toBinaryString((1 << val)));
            System.out.println(Integer.toBinaryString(check & (1 << val)));
            System.out.println("---------------");
            
            if((check & (1 << val)) > 0) {
                return false;
            } 
            check |= (1 << val);
            System.out.println(Integer.toBinaryString(check));
            System.out.println("---------------");
        }
        return true;
    }

    public static void main(String[] args) {
        CTCI_1_1_Is_Unique ct = new CTCI_1_1_Is_Unique();
        System.out.println(ct.isUnique("helolo"));
    }
}
