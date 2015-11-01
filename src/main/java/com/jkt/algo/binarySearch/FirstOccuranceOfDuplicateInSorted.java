package com.jkt.algo.binarySearch;

/**
 * Given a sorted array with duplicates, find first occurrence of a given element -
 *
 * @author jaikit
 *
 */
public class FirstOccuranceOfDuplicateInSorted {

    public static void main(final String args[]) {
        final FirstOccuranceOfDuplicateInSorted firstOccuranceOfDuplicateInSorted = new FirstOccuranceOfDuplicateInSorted();
        final int input[] = { 12, 13, 15, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 89, 89, 89, 90, 101, 102 };
        System.out.println(firstOccuranceOfDuplicateInSorted.findPos(input, 89, 0, input.length - 1));
    }

    private int findPos(final int[] input, final int key, final int start, final int end) {
        if (start > end) {
            return -1;
        }

        final int mid = (start + end) / 2;

        final int value = input[mid];
        if (value == key) {
            if ((mid - 1) >= 0) {
                if (input[mid - 1] != key) {
                    return mid;
                } else {
                    return findFirstPos(input, key, start, mid - 1);
                }
            }

            return mid;
        } else if (key < value) {
            return findPos(input, key, start, mid - 1);
        } else {
            return findPos(input, key, mid + 1, end);
        }

    }

    private int findFirstPos(final int[] input, final int key, final int start, final int end) {

        if ((end - start) == 0) {
            return end;
        } else if ((end - start) == 1) {
            return (input[start] == key ? start : end);
        }

        final int mid = (start + end) / 2;
        if (input[mid] == key) {
            if((mid - 1) >= 0) {
                if(input[mid - 1] == key) {
                    return findFirstPos(input, key, start, mid - 1);
                } else {
                    return mid;
                }
            } else {
                return mid;
            }
        } else {
            return findFirstPos(input, key, mid + 1, end);
        }
    }

}
