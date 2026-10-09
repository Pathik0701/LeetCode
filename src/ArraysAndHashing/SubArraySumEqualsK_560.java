package ArraysAndHashing;

import java.util.HashMap;

public class SubArraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        prefixMap.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }

            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
