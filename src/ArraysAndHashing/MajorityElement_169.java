package ArraysAndHashing;

class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // If count falls to 0, pick the current number as the new candidate
            if (count == 0) {
                candidate = num;
            }

            // Increment count if the number matches the candidate, decrement otherwise
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}