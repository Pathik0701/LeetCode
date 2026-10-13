package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray_525 {
    public int findMaxLength(int[] nums) {
        // Maps the running balance to its first seen index
        Map<Integer, Integer> balanceMap = new HashMap<>();
        // Base case: a balance of 0 before the array starts at index -1
        balanceMap.put(0, -1);

        int maxLength = 0;
        int balance = 0;

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, and 1 as +1
            balance += (nums[i] == 1) ? 1 : -1;

            if (balanceMap.containsKey(balance)) {
                // Calculate the length of the valid subarray
                maxLength = Math.max(maxLength, i - balanceMap.get(balance));
            } else {
                // Store the first occurrence of this balance
                balanceMap.put(balance, i);
            }
        }
        return maxLength;
    }
}
