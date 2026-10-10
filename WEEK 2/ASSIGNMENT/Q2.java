public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        // Split the sentence into words using a single space
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Build the reverse of each word using StringBuilder
            StringBuilder reversedWord = new StringBuilder(words[i]);
            reversedWord.reverse();

            result.append(reversedWord.toString());

            // Join the reversed words back together with spaces[cite: 1]
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club")); // Expected: olleh bulc
    }
}