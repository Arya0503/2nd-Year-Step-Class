import java.util.*;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        // Small fixed list of stop words to treat as filler[cite: 1]
        List<String> stopWordsList = Arrays.asList("the", "was", "and", "a", "is", "of", "in");
        Set<String> stopWords = new HashSet<>(stopWordsList);

        // Convert to lowercase and strip punctuation using replace()[cite: 1]
        String cleanedFeedback = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split cleaned text into words using whitespace pattern[cite: 1]
        String[] words = cleanedFeedback.split("\\s+");

        // Count frequency of every remaining unique word[cite: 1]
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            // Skip any word found in the stop-word list or empty strings[cite: 1]
            if (!stopWords.contains(word) && !word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        // Sort by count in descending order[cite: 1]
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCounts.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print each unique word with its count[cite: 1]
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String input = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(input);
    }
}