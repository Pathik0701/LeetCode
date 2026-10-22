package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ImageOverlap_835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        // Step 1: Collect coordinates of all 1s from both matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    list1.add(new int[]{i, j});
                }
                if (img2[i][j] == 1) {
                    list2.add(new int[]{i, j});
                }
            }
        }

        // Step 2 & 3: Count the frequencies of each transformation vector
        Map<String, Integer> map = new HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                // Calculate the row and column differences
                int rowShift = p2[0] - p1[0];
                int colShift = p2[1] - p1[1];

                // Create a unique key for the displacement vector
                String key = rowShift + "," + colShift;

                // Update frequency map
                map.put(key, map.getOrDefault(key, 0) + 1);

                // Step 4: Track the maximum overlap found so far
                maxOverlap = Math.max(maxOverlap, map.get(key));
            }
        }

        return maxOverlap;
    }
}
