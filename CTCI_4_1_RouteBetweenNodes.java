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
public class CTCI_4_1_RouteBetweenNodes {
    
    boolean search(Node start, Node end){
        LinkedList<Node> nextToVisit = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        nextToVisit.add(start);
        
        while(!nextToVisit.isEmpty()) {
            Node n = nextToVisit.remove();
            visited.add(n);
            if (n == end) return true;
            if (visited.contains(n)) continue;
            for(Node s: n.adjacent){
                nextToVisit.add(s);
            }
        }
        return false;
    }
}
