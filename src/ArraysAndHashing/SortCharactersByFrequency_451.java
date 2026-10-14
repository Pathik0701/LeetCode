package ArraysAndHashing;

import java.util.*;

class SortCharactersByFrequency_451{
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());

        // 3. Sort the list by value (frequency) in descending order
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));

        // 4. Build the final string based on the sorted list
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char character = entry.getKey();
            int count = entry.getValue();

            // Append the character as many times as it appears
            for (int i = 0; i < count; i++) {
                result.append(character);
            }
        }
        return result.toString();
    }
}