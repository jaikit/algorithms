package com.jkt.algo.binarySearch;

public class SortedAndRotatedFind {

    public static void main(final String args[]) {
        final SortedAndRotatedFind circularBinarySearch = new SortedAndRotatedFind();

        final int arr1[] = { 110, 1, 2, 3, 6, 18, 23, 90, 100, 109, 110 };
        // 0 1 2 3 4 5 6 7 8
        final int out = circularBinarySearch.findClosest(arr1, 110);
        System.out.println(out);
    }

    private int findClosest(final int[] arr, final int key) {

        if (arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            final int value = arr[mid];
            if (key == value) {
                return mid;
            }
            /* right sorted. */
            if (value <= arr[end]) {
                if ((key > value) && (key <= arr[end])) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if ((key < value) && (key >= arr[start])) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

}
