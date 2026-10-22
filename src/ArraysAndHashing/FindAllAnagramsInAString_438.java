package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Edge case: if s is shorter than p, an anagram is impossible
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // Frequency arrays for characters 'a' through 'z'
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill frequency array for string p and the first window of s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Check if the first window matches
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window across the rest of string s
        for (int i = p.length(); i < s.length(); i++) {
            // Add the new character entering the window
            sCount[s.charAt(i) - 'a']++;

            // Remove the old character leaving the window
            sCount[s.charAt(i - p.length()) - 'a']--;

            // If the frequencies match, the anagram starts at (i - p.length() + 1)
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
