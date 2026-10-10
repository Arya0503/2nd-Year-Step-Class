public void classifyWordLengths(String review) {
    String[] words = review.split("\\s+");
    int shortCount = 0;
    int mediumCount = 0;
    int longCount = 0;

    for (String word : words) {
        String cleanWord = word.replaceAll("[^a-zA-Z]", "");
        int len = cleanWord.length();
        if (len >= 1 && len <= 4) {
            shortCount++;
        } else if (len >= 5 && len <= 8) {
            mediumCount++;
        } else if (len >= 9) {
            longCount++;
        }
    }

    System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
}