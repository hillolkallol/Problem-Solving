/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 1.4
 * Given a string, write a function to check if it is a permutation of a palindrome. Al palindrome is a word or pharase that is the same 
 * forwords and backwords. A permutation is a arrangement of letters. The palindrome does not need to be limit to just dictonary words
 * 
 * 
 */
public class CTCI_1_4_Palindrome_Permutation {
    public boolean palinPermu(String s){
        int[] letters = new int[128];
        int len = s.length();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                letters[Character.toLowerCase(s.charAt(i))]++;
            else
                len--;
        }
        
        boolean flag = false;
        if (len % 2 == 0){
            for(int i = 0; i < 128; i++){
                if(letters[i] != 0 && letters[i] % 2 != 0){
                    return false;
                }
            }
        }
        else{
            for(int i = 0; i < 128; i++){
                if(letters[i] != 0 && letters[i] % 2 != 0){
                    if(flag) return false;
                    flag = true;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        CTCI_1_4_Palindrome_Permutation cI_1_4_Palindrome_Permutation = new CTCI_1_4_Palindrome_Permutation();
        System.out.println(cI_1_4_Palindrome_Permutation.palinPermu("Tato Coa"));
    }
}
