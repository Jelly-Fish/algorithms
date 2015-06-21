/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.utils;

import java.util.Arrays;

/**
 *
 * @author thw
 */
public class CheckUtils {
    
    /**
     * Compare 2arrays for strict equality after use of java.util.Arrays.sort method.
     * @param a
     * @param b
     * @return 
     */
    public static boolean compare(final int[] a, final int[] b) {
        
        if (a == null || b == null) {
            return false;
        }
        
        int[] lA = a;
        int[] lB = b;
        Arrays.sort(lA);
        Arrays.sort(lB);
        return Arrays.equals(lA, lB);
    }
    
}
