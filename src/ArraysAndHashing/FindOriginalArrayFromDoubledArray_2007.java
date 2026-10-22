package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FindOriginalArrayFromDoubledArray_2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        // 1. A doubled array must have an even number of elements
        if (n % 2 != 0) {
            return new int[0];
        }

        // 2. Build a frequency map to count occurrences safely
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 3. Sort the array to match the smallest elements first
        Arrays.sort(changed);

        int[] original = new int[n / 2];
        int index = 0;

        for (int num : changed) {
            // If this element was already used as a double for a smaller element, skip it
            if (freq.get(num) == 0) {
                continue;
            }

            int twice = num * 2;

            // 4. Check if the required double element exists and is still available
            if (freq.getOrDefault(twice, 0) == 0) {
                return new int[0];
            }

            // Special handling for 0: it needs at least 2 available instances to pair with itself
            if (num == 0 && freq.get(0) < 2) {
                return new int[0];
            }

            // Record the valid original element
            original[index++] = num;

            // Consume one instance of both the element and its double
            freq.put(num, freq.get(num) - 1);
            freq.put(twice, freq.get(twice) - 1);
        }

        return original;
    }
}