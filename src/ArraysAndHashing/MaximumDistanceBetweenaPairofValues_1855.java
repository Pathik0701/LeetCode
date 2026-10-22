package ArraysAndHashing;

class MaximumDistanceBetweenaPairofValues_1855  {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int maxDist = 0;

        // Iterate through both arrays using two pointers
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                // If it's a valid pair, update the max distance
                maxDist = Math.max(maxDist, j - i);
                // Move the second pointer forward to try and find a larger distance
                j++;
            } else {
                // If nums1[i] > nums2[j], we need a smaller value from nums1.
                // Since nums1 is non-increasing, moving i forward gives a smaller or equal value.
                i++;
            }
        }
        return maxDist;
    }
}
