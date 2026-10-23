package ArraysAndHashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall_554 {
    public int leastBricks(List<List<Integer>> wall) {
        // Change the key from Integer to Long to prevent overflow
        Map<Long, Integer> edgeCounts = new HashMap<>();
        int maxEdges = 0;

        for (List<Integer> row : wall) {
            // Change position tracking to long
            long currentPosition = 0;

            for (int i = 0; i < row.size() - 1; i++) {
                currentPosition += row.get(i);

                int currentCount = edgeCounts.getOrDefault(currentPosition, 0) + 1;
                edgeCounts.put(currentPosition, currentCount);

                if (currentCount > maxEdges) {
                    maxEdges = currentCount;
                }
            }
        }

        return wall.size() - maxEdges;
    }
}