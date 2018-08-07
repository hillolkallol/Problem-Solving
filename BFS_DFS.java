/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */

import java.util.*;
class Node {
    int id;
    List<Node> adjacent = new LinkedList<>();
    public Node(int id) { 
        this.id = id;
    }
}
public class BFS_DFS {
    Map<Integer, Node> nodeLookup = new HashMap<>();
    
    public Node getNode(int id) {
        return nodeLookup.get(id);
    }
    
    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    } 
    
    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        Set<Node> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }
    
    public boolean hasPathDFS(Node source, Node destination, Set<Node> visited) {
        if (visited.contains(source)) return false;
        if (source == destination) return true;
        visited.add(source);
        
        for(Node n: source.adjacent) {
            if(hasPathDFS(n, destination, visited)) return true;
        }
        return false;
    }
    
    public boolean hasPathBFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        return hasPathBFS(s, d);
    }
    
    public boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        nextToVisit.add(source);
        
        while (!nextToVisit.isEmpty()) {
            Node n = nextToVisit.remove();
            if (n == destination) return true;
            if (visited.contains(n)) continue;
            visited.add(n);
            for (Node adj: n.adjacent) {
                nextToVisit.add(adj);
            }
        }
        return false;
    }
}
