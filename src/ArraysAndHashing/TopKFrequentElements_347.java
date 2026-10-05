package ArraysAndHashing;

import java.util.*;

public class TopKFrequentElements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count the frequency of each element
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 2. Create buckets where the array index represents the frequency
        // The maximum possible frequency is nums.length
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : countMap.keySet()) {
            int frequency = countMap.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        // 3. Collect the top k frequent elements from right (highest frequency) to left
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}