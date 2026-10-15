package ArraysAndHashing;

import java.util.*;

public class TopKFrequentElement_692 {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a Min-Heap to keep the top k frequent words
        // Custom comparator:
        // - If frequencies are different, the word with lower frequency stays at the top (Min-Heap behavior)
        // - If frequencies are the same, the word with higher lexicographical order stays at the top
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (w1, w2) -> counts.get(w1).equals(counts.get(w2)) ?
                        w2.compareTo(w1) : counts.get(w1) - counts.get(w2)
        );

        // Step 3: Maintain a heap size of k
        for (String word : counts.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent / lexicographically worst word
            }
        }

        // Step 4: Extract elements from the heap and reverse the list
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result); // Min-heap gives items in reverse order of final requirement

        return result;
    }
}