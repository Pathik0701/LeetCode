package ArraysAndHashing;

class MinimumNumberofStepstoMakeTwoStringsAnagram_1347 {
    public int minSteps(String s, String t) {
        int[] charCounts = new int[26];
        int steps = 0;

        // Count character frequencies for both strings
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // Sum up the characters that t needs from s
        for (int count : charCounts) {
            if (count > 0) {
                steps += count;
            }
        }
        return steps;
    }
}
