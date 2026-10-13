package ArraysAndHashing;

import java.util.HashMap;

public class ContinuousSubarraySum_523{
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store the first occurrence of a remainder: {remainder -> index}
        HashMap<Integer, Integer> remainderMap = new HashMap<>();

        // Initialize with 0 -> -1 to handle subarrays starting from index 0
        remainderMap.put(0, -1);

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // Calculate remainder
            int remainder = currentSum % k;

            // Handle cases where remainder might be negative
            if (remainder < 0) {
                remainder += Math.abs(k);
            }

            // If the remainder has been seen before
            if (remainderMap.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - remainderMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Only store the first occurrence to preserve the maximum subarray length
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }
}
