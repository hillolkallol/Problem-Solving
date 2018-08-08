/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class Testing {
    public int test(int i) {
        return i << 1;
    }
    public static void main(String args[]) {
        Testing testing = new Testing();
        System.out.println(testing.test(4));
    }
}
