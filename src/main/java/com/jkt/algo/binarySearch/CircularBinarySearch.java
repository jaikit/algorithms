package com.jkt.algo.binarySearch;

/**
 * Search an element in array which is first increasing then decreasing then increasing or other way round
 *
 * http://www.careercup.com/question?id=4877486110277632 Given a circle with N defined points and a point M outside the circle, find the point that is
 * closest to M among the set of N. O(LogN) Test cases 1) smallest element at center 2) smallest element at left/right end 3) largest element at
 * center 4) smallest element at left side 5) smallest element at right side
 *
 * @author jaikit
 *
 */
public class CircularBinarySearch {

    private int findClosest(final int[] arr1, final int key, final int start, final int end) {

        if (start > end) {
            return Integer.MAX_VALUE;
        } else if ((end - start) <= 1) {
            return Math.min(Math.abs(key - arr1[start]), Math.abs(key - arr1[end]));
        }

        final int mid = (start + end) / 2;

        if (arr1[mid] == key) {
            return 0;
        }
        // left sorted.
        final int close = Math.abs(arr1[mid] - key);

        if ((arr1[start] <= arr1[mid]) && ((mid - 1) >= 0) && (arr1[mid - 1] <= arr1[mid]) && ((mid + 1) <= (arr1.length - 1))
                && (arr1[mid] < arr1[mid + 1])) {
            int b, a;
            if (key < arr1[mid]) {
                b = findClosest(arr1, key, start, mid - 1);
                a = findClosest(arr1, key, mid + 1, end);
                b = Math.min(a, b);
            } else {
                b = findClosest(arr1, key, mid + 1, end);
            }
            return Math.min(close, b);
        } else if ((arr1[mid] <= arr1[end]) && ((mid + 1) <= (arr1.length - 1)) && (arr1[mid] < arr1[mid + 1]) && ((mid - 1) >= 0)
                && (arr1[mid - 1] <= arr1[mid])) {
            int b, a;
            if (key < arr1[mid]) {
                b = findClosest(arr1, key, start, mid - 1);
            } else {
                a = findClosest(arr1, key, start, mid - 1);
                b = findClosest(arr1, key, mid + 1, end);
                b = Math.min(a, b);

            }
            return Math.min(close, b);
        } else {
            final int a = findClosest(arr1, key, start, mid - 1);
            final int b = findClosest(arr1, key, mid + 1, end);
            return Math.min(close, Math.min(a, b));
        }
    }
    public static void main(final String args[]) {
        final CircularBinarySearch circularBinarySearch = new CircularBinarySearch();

        final int arr1[] = { 7, 10, 59, 40, 30, 20, 3, 5, 40, 45, 50, 51, 60, 74, 80 };

        final int out = circularBinarySearch.findClosest(arr1, 76, 0, arr1.length - 1);
        System.out.println(out);
    }

}
