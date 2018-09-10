/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 
 * 127. Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
import java.util.*;
public class Leetcode_127_WordLadder {
    
}
class Solutions {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> nextToVisit = new HashSet<>();
        nextToVisit.add(beginWord);
        
        int count = 1;
        
        while (! nextToVisit.contains(endWord)) {
            Set<String> newNext = new HashSet<>();
            for (String word: nextToVisit) {
                for (int i=0; i<word.length(); i++) {
                    char[] wordarr = word.toCharArray();
                    for (char c = 'a'; c<='z'; c++) {
                        wordarr[i] = c;
                        
                        String s = new String(wordarr);
                        
                        if (wordSet.contains(s)) {
                            newNext.add(s);
                            wordSet.remove(s);
                        }
                    }
                }
            }
            
            count++;
            if (newNext.size() == 0) return 0;
            nextToVisit = newNext;
        }
        
        return count;
        
    }
}





// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> set = new HashSet<>();
//         for (String word: wordList) set.add(word);
        
//         return ladderLength(beginWord, endWord, set, 0);
//     }
    
//     public int ladderLength(String beginWord, String endWord, Set<String> set, int stage) {
//         if (beginWord.length() != endWord.length()) return 0;
        
//         if (beginWord == endWord) return stage;
        
//         for (int i = 0; i < beginWord.length(); i++) {
//             for (int c = 'a'; c <= 'z'; c++) {
//                 char newChar = (char) c;
//                 String newString = beginWord.substring(0, i) + newChar + beginWord.substring(i+1);
//                 if (set.contains(newString)) {
//                     int t = ladderLength(newString, endWord, set, stage + 1);
//                     if (t != 0) return t;
//                 }
//             }
//         }
        
//         return;
//     }
// }