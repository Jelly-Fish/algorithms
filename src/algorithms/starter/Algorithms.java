/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.starter;

import algorithms.utils.DisplayUtils;
import algorithms.utils.CheckUtils;
import algorithms.sorting.ArraySort;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thw
 */
public class Algorithms {

    private static Random rand;
    private static final int RAND_FACTOR = 10;
    private static final int ARRAY_LENGTH = 1000;
    private static final boolean DISPLAY = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------");
        System.out.println("-- Algorithm testing ------------------------------");
        System.out.println("-- Array length = " + Algorithms.ARRAY_LENGTH);
        System.out.println("-- Random factor (array.length * factor) = " + Algorithms.RAND_FACTOR);
        System.out.println("-- >> random window : " + 0 + " to " + 
                ((Algorithms.ARRAY_LENGTH * Algorithms.RAND_FACTOR) - 1));
        System.out.println("-- Display all data param = " + Algorithms.DISPLAY);
        System.out.println("---------------------------------------------------");

        try {
            Algorithms.runSortAlgorithms(ArraySort.class, Algorithms.ARRAY_LENGTH, DISPLAY);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                InvocationTargetException ex) {
            Logger.getLogger(Algorithms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param c
     * @param arrayLength
     * @param display
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private static void runSortAlgorithms(final Class c, final int arrayLength,
            final boolean display) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        Object lC = c.newInstance();
        final Method[] m = c.getDeclaredMethods();

        for (Method lM : m) {

            if (Modifier.isPublic(lM.getModifiers())) {
                
                System.out.println("\n---------------------------------------------------");
                System.out.println("-- Method : " + lM.toString());
                System.out.println("---------------------------------------------------");
                
                lC = c.newInstance();
                Algorithms.rand = new Random();

                int[] a = new int[arrayLength];
                int[] aBis = new int[arrayLength];
                for (int i = 0; i < a.length; i++) {
                    a[i] = Algorithms.rand.nextInt(arrayLength * Algorithms.RAND_FACTOR);
                    aBis[i] = a[i];
                }

                if (display) {
                    DisplayUtils.printIntegerArray(a);
                }

                long startTime = System.nanoTime(); // Profiling start.
                lM.invoke(lC, a);
                long endTime = System.nanoTime(); // Profiling end.

                if (display) {
                    DisplayUtils.printlnIntegerArray(a);
                }

                DisplayUtils.printProfiling(startTime, endTime, ArraySort.calls,
                        CheckUtils.compare(a, aBis));
            }
        }
        
        // Compare with java.util.Arrays.sort() :
        Algorithms.javaUtilSort(arrayLength, display);
        
        System.out.println("\n-- END --------------------------------------------");

    }

    //<editor-fold defaultstate="collapsed" desc="java.util.Arrays.sort(a) for profiling reference">
    /**
     * With java.util.Arrays.sort method.
     *
     * @param arrayLength
     * @param display
     */
    private static void javaUtilSort(final int arrayLength, final boolean display) {

        System.out.println("\n---------------------------------------------------");
        System.out.println("-- java.util.Arrays.sort() reference --------------");
        System.out.println("---------------------------------------------------");

        int[] a = new int[arrayLength];
        int[] aBis = new int[arrayLength];
        for (int i = 0; i < a.length; i++) {
            a[i] = Algorithms.rand.nextInt(arrayLength * Algorithms.RAND_FACTOR);
            aBis[i] = a[i];
        }
        if (display) {
            DisplayUtils.printIntegerArray(a);
        }

        long startTime = System.nanoTime(); // Profiling start.
        Arrays.sort(a);
        long endTime = System.nanoTime(); // Profiling end.

        if (display) {
            DisplayUtils.printlnIntegerArray(a);
        }

        DisplayUtils.printProfiling(startTime, endTime, -1,
                CheckUtils.compare(a, aBis));
    }
    //</editor-fold>

}
