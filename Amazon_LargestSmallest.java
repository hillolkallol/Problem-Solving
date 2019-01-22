/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class Amazon_LargestSmallest {
    public String secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        
        int smallest = Integer.MAX_VALUE;
        int secSmallest = Integer.MAX_VALUE;
        int thirdSmallest = Integer.MAX_VALUE;
        
        for (int val: arr) {
            if (val > largest) {
                thirdLargest = secLargest;
                secLargest = largest;
                largest = val;
            }
            else if (val > secLargest && val != largest) {
                thirdLargest = secLargest;
                secLargest = val;
            }
            else if (val > thirdLargest && val != secLargest && val != largest) 
                thirdLargest = val;
            
            //find smallest
            if (val < smallest) {
                thirdSmallest = secSmallest;
                secSmallest = smallest;
                smallest = val;
            }
            else if (val < secSmallest && val != smallest) {
                thirdSmallest = secSmallest;
                secSmallest = val;
            }
            else if (val < thirdSmallest && val != secSmallest && val != smallest)
                thirdSmallest = val;
        }
        return thirdLargest + "-" + thirdSmallest;
    }
    
    public static void main(String[] args) {
        Amazon_LargestSmallest als = new Amazon_LargestSmallest();
        System.out.println(als.secondLargest(new int[]{2,3,7,223,2,6,3,3,3,87,2,223,41,54}));
    }
}
