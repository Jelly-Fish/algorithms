/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sorting;

/**
 *
 * @author thw
 */
public class ArraySort {

    public static int calls = 1;

    public ArraySort() {
        ArraySort.calls = 1;
    }

    //<editor-fold defaultstate="collapsed" desc="recursive bubble sorting 1 : recursiveBubbleSort1">
    /**
     * bubble sort algorithm with recursive calls.
     *
     * @param a array to sort
     */
    public void recursiveBubbleSort1(final int[] a) {

        int lowValue, tmp = 0;
        boolean sorted = true;

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i + 1] < a[i]) {
                tmp = a[i];
                lowValue = a[i + 1];
                a[i] = lowValue;
                a[i + 1] = tmp;
                sorted = false;
            }
        }

        if (!sorted) {
            ++ArraySort.calls;
            this.recursiveBubbleSort1(a);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="bubble sorting 2 : recursiveBubbleSort1">
    /**
     * bubble sort algorithm with calls to getLowestValuesIndex function.
     *
     * @param a array to sort
     */
    public void classicBubbleSort(final int[] a) {

        int index, tmp = 0;

        for (int i = 0; i < a.length - 1; i++) {
            tmp = a[i];
            index = getLowestValuesIndex(a, i);
            a[i] = a[index];
            a[index] = tmp;
        }
    }
    
    /**
     * Get index of lowest integer value in an integer array.
     *
     * @param a int array.
     * @param k start index.
     * @return index.
     */
    private int getLowestValuesIndex(final int[] a, int k) {

        int index = k;
        int lowVal = Integer.MAX_VALUE;

        while (k < a.length) {
            if (a[k] < lowVal) {
                lowVal = a[k];
                index = k;
            }
            ++k;
        }

        ++ArraySort.calls;
        return index;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="recursive bubble sorting 3 with index slidding : slideSort1">
    /**
     * bubble sort algorithm with call to sort1 after array low values index
     * slidding to first array index. The array is scanned once in this way,
     * then sort3 calls sort1 to recursivly bubble sort the array.
     *
     * @see ArraySort.sort1
     * @param a array to sort
     */
    public void slideSort1(final int[] a) {

        int lowValue, tmp = 0;

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i + 1] < a[i]) {

                lowValue = a[i + 1];

                if (i > 0 && a[0] > lowValue) {

                    // Then slip foward all indexes starting from lowValue's index
                    // towards index 1. 
                    for (int j = i + 1; j > 0; j--) {
                        tmp = a[j - 1];
                        a[j] = tmp;
                    }
                    // Finally lowValue goes to index 0.
                    a[0] = lowValue;
                } else {

                    // Then classic permutation.
                    tmp = a[i];
                    a[i] = lowValue;
                    a[i + 1] = tmp;
                }
            }
        }

        ++ArraySort.calls;
        this.recursiveBubbleSort1(a);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Recursive merge sort algorithm 1">
    /**
     * Top down merge sort 1.
     *
     * @param a array to sort.
     */
    public void mergeSort1(int[] a) {
        ArraySort.calls = 0;
        this.splitMerge(a, 0, a.length, new int[a.length]);
    }

    /**
     * iBegin is inclusive; iEnd is exclusive (a[iEnd] is not in the set)
     *
     * Top down split merge.
     * 
     * @param a
     * @param iBegin
     * @param iEnd
     * @param b
     */
    private void splitMerge(int[] a, final int iBegin, int iEnd, int[] b) {

        ++ArraySort.calls;
        
        if (iEnd - iBegin < 2) { 
            // if run size == 1 >> sorted
            return;
        }
        
        // recursively split runs into two halves until run size == 1,
        // then merge them and return back up the call chain.
        int iMiddle = (iEnd + iBegin) / 2; // set middle index.
        this.splitMerge(a, iBegin, iMiddle, b); // split / merge left half.
        this.splitMerge(a, iMiddle, iEnd, b); // split / merge right half.
        this.merge(a, iBegin, iMiddle, iEnd, b); // merge the two half runs.
        
        // copy the merged runs back to a[]
        // Here, System.arraycopy is not to be used to ease porting to other 
        // languages.
        for (int i = iBegin; i < iEnd; i++) {
            a[i] = b[i];
        }
    }

    /**
     * left half is a[iBegin : iMiddle-1] right half is a[iMiddle : iEnd-1].
     *
     * Top down merge.
     * 
     * @param a
     * @param iBegin
     * @param iMiddle
     * @param iEnd
     * @param b
     */
    private void merge(int[] a, final int iBegin, final int iMiddle, 
            final int iEnd, int[] b) {

        // iS = start index. iM = middle index.
        int iS = iBegin, iM = iMiddle;

        // While there are elements in the left or right runs
        for (int i = iBegin; i < iEnd; i++) {
            
            // If left run head exists and is <= existing right run head.
            if (iS < iMiddle && (iM >= iEnd || a[iS] <= a[iM])) {
                b[i] = a[iS];
                ++iS;
            } else {
                b[i] = a[iM];
                ++iM;
            }
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Recursive merge sort algorithm 2">
    public void mergeSort2(int[] a) {
        // TODO : code this.
        this.recursiveBubbleSort1(a);
    }
    
    /**
     * Sub-function used by mergeSort2.
     * @param a
     * @param startI
     * @param endI 
     */
    private void mergeSort2SubFunc(int[] a, int startI, int endI) {
        
    }
    //</editor-fold>
    
}
