
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class Amazon_DeliveryPlan {
    public int[][] deliveryPlan(int numDest, int[][] allLoc, int numDeli) {
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int[] loc: allLoc) {
            int dist = (loc[0]*loc[0]) + (loc[1]*loc[1]);
            map.put(dist, loc);
        }
        
        int[][] res = new int[numDeli][2];
        int i = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int key: list) {
            res[i] = map.get(key);
            if (i < numDeli - 1) i++;
            else break;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Amazon_DeliveryPlan am = new Amazon_DeliveryPlan();
        int[][] arr = am.deliveryPlan(3, new int[][]{{1, 2}, {3, 4}, {1, -1}}, 2);
        for (int[] a: arr) {
            System.out.print(a[0]);
            System.out.print(" ");
            System.out.println(a[1]);
        }
    }
}
