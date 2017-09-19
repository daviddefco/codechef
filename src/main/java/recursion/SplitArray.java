package recursion;

/**
 * Given an array of ints, is it possible to divide the ints into two groups, so that the sums
 * of the two groups are the same. Every int must be in one group or the other. Write a
 * recursive helper method that takes whatever arguments you like, and make the initial call
 * to your recursive helper from splitArray(). (No loops needed.)
 *
 *       splitArray([2, 2]) → true
 *       splitArray([2, 3]) → false
 *       splitArray([5, 2, 3]) → true
 */

// O(2^n) exponential. Explores all possible split options
public class SplitArray {
    public boolean splitArray(int[] nums) {
        int arrayValue = 0;
        for(int i=0; i<nums.length; i++) {
            arrayValue += nums[i];
        }
        return isSplitPossible(0, nums, arrayValue);
    }

    public boolean isSplitPossible(int index, int[] array, int target) {
        if(index >= array.length) return target == 0;
        if(isSplitPossible(index +1, array, target)) return true;
        if(isSplitPossible(index +1, array, target - (2 * array[index]))) return true;
        return false;
    }
}
