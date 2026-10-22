package ArraysAndHashing;

public class CustomSortString_791 {
    public String customSortString(String order, String s) {
        // Step 1: Count frequency of each character in s
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        // Step 2: Append characters in the sequence defined by 'order'
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            int index = ch - 'a';
            while (freq[index] > 0) {
                result.append(ch);
                freq[index]--;
            }
        }

        // Step 3: Append all remaining characters that were not in 'order'
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                result.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return result.toString();
    }
}
