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
 * 261. Graph Valid Tree
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */

import java.util.*;
public class Leetcode_261_GraphValidTree {
    
}

class Solutionwwe {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for (int[] edge: edges) {
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);
            
            if (x == y) return false;
            nums[x] = y;
        }
            
        return edges.length == n-1;
    }
    
    public int find(int[] nums, int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}

class Solutioneww {
    public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=0; i<n; i++) adj.add(new ArrayList<Integer>());
        
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        queue.offer(0);
        visited[0] = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int s: adj.get(current)) {
                if (visited[s] == 1) return false;
                if (visited[s] == 0) {
                    visited[s] = 1;
                    queue.offer(s);
                }
            }
            visited[current] = 2;
        }
        
        for (int v: visited) if(v == 0) return false;
        return true;
    }
}