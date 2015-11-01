package com.jkt.algo.binarySearch;

/**
 * An arithmetic progression is a sequence of numbers such that the difference of any two successive members is a constant.
 * For example, the sequence 1, 2, 3, 4, ... is an arithmetic progression with common difference 1.
 *
 * Problem: Given an arithmetic progression with one number mission find that missing number -
 *
 * @author jaikit
 *
 */
public class FindMissingArithmeticProgression {


    private int findDifference(final int[] input) {
        final int a = input[1] - input[0];
        final int b = input[2] - input[1];
        return Math.min(a, b);
    }

    private int missing(final int[] input, final int diff, final int base, final int start, final int end) {
        if (start >= end) {
            if ((start) > (input.length - 1)) {
                return base - diff;
            }

            final int val = base + (start * diff);
            /* left number is missing. */
            if(input[start] != val) {
                return val;
            } else {
                if ((start + 1) > (input.length - 1)) {
                    return base - diff;
                }

                if(input[start + 1] != (base + ((start+1) * diff))) {
                    return (base + ((start + 1) * diff));
                } else {
                    // first number is missing;
                    return base - diff;
                }
            }
        }

        final int mid = (start + end) / 1;
        final int val = base + (mid * diff);

        /* missing number in left array. */
        if (input[mid] > val) {
            return missing(input, diff, base, start, mid - 1);
        } else {
            return missing(input, diff, base, mid + 1, end);
        }
    }

    public static void main(final String args[]) {
        final int input[] = { -2, 1, 4, 7, 10, 13, 16, 22 };
        final FindMissingArithmeticProgression findMissingArithmeticProgression = new FindMissingArithmeticProgression();

        /* length of input array needs to be greater then 2 to find difference. */
        final int diff = findMissingArithmeticProgression.findDifference(input);

        System.out.println(findMissingArithmeticProgression.missing(input, diff, input[0], 0, input.length - 1));
    }
}
