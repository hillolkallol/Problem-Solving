/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 207. Course Schedule
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
import java.util.*;
public class Leetcode_207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];
        int[] afterList = new int[numCourses];
        
        for (int i=0; i < prerequisites.length; i++) {
            int after = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            if (adj[pre][after] == 0) afterList[after]++;
            adj[pre][after] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<afterList.length; i++) {
            if (afterList[i] == 0) queue.offer(i);
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int ready = queue.poll();
            count++;
            
            for (int i = 0; i < numCourses; i++) {
                if (adj[ready][i] != 0) {
                    if (--afterList[i] == 0) queue.offer(i);
                }
            }
        }
        
        return count == numCourses;
    }
}
