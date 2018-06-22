/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 1.5
 * there are three types of edits that can be performed on strings, insert a charcter, remove a character or
 * replace a character. Given two strings, wite a function to check if they are one edit away
 * 
 */
public class CTCI_1_5_One_Away {
    
    public boolean oneAway(String s1, String s2){
        int[] arr = new int[128];
        
        for(int i=0; i<s1.length(); i++){
            arr[s1.charAt(i)]++;
        }
        
        for(int i=0; i<s2.length(); i++){
            arr[s2.charAt(i)]--;
        }
        
        int sum = 0;
        for(int a: arr){
            if(a>0){
                sum += a;
            }
        }
        
        if (sum > 1) return false;
        return true;
    }
    
    public static void main(String[] args){
        CTCI_1_5_One_Away cI_1_5_One_Away = new CTCI_1_5_One_Away();
        System.out.println(cI_1_5_One_Away.oneAway("aple", "apple"));
    }
    
}
