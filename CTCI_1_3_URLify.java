
import java.util.Arrays;

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
 enght of the string* Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters and that you are given the true la
 */
public class CTCI_1_3_URLify {
    public String urlify(String s, int n){
        char[] arr = new char[s.length()];
        int i = n-1;
        int j = s.length() - 1;
        while(i>=0){
            if (s.charAt(i) == ' '){
                arr[j] = '0';
                arr[j-1] = '2';
                arr[j-2] = '%';
                j = j - 3;
            }
            else {
                arr[j] = s.charAt(i);
                j--;
            }
            i--;
        }
        return new String(arr);
    }
    
    public static void main(String[] args){
        CTCI_1_3_URLify cI_1_3_URLify = new CTCI_1_3_URLify();
        System.out.println(cI_1_3_URLify.urlify("Mr John Smith    ", 13));
    }
}
