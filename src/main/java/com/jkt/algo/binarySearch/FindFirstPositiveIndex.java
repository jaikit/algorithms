package com.jkt.algo.binarySearch;

public class FindFirstPositiveIndex {

    private int missing(final int[] input) {
        int start = 0;
        int end = input.length - 1;

        while (start < end) {
            final int mid = (start + end) / 2;

            if ((input[mid] >= 0) && ((mid - 1) >= 0) && (input[mid - 1] >= 0)) {
                end = mid - 1;
            } else if ((input[mid] < 0) && ((mid + 1) <= end) && (input[mid + 1] < 0)) {
                start = mid + 1;
            } else {
                if (input[mid] >= 0) {
                    return mid;
                } else if ((mid + 1) <= end) {
                    return mid + 1;
                } else {
                    break;
                }
            }
        }

        return -1;
    }

    public static void main(final String args[]) {
        final int input[] = { -20, -10, -9, 1, 4, 7, 10, 13, 16, 22 };
        final FindFirstPositiveIndex findMissingArithmeticProgression = new FindFirstPositiveIndex();

        System.out.println(findMissingArithmeticProgression.missing(input));
    }

}
