/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.utils;

/**
 *
 * @author thw
 */
public class DisplayUtils {
    
    //<editor-fold defaultstate="collapsed" desc="print functions">
    /**
     * Print each time on a new line.
     * @param a array to print.
     */
    public static void printlnIntegerArray(final int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("i[" + i + "]=" + a[i]);
        }
    }
    
    /**
     * Print 30 elements per line.
     * @param a array to print.
     */
    public static void printIntegerArray(final int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "/");
            if (i > 0 && i % 30 == 0) {
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }
    
    /**
     * Print profiling data.
     * @param start
     * @param end
     * @param fCalls function calls.
     * @param checkResult check result of assets used.
     */
    public static void printProfiling(final long start, final long end, final long fCalls, 
            final boolean checkResult) {
         System.out.println(">> function call count = " + fCalls + 
                "\n>> function ns duration = " + (end - start) + 
                "\n>> function ms duration = " + ((double)(end - start) / 1000000) +
                "\n>> assets check result = " + checkResult);
    }
    //</editor-fold>
    
}
