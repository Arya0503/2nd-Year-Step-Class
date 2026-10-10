public void checkTypingAccuracy(String original, String typed) {
    int matchCount = 0;
    int firstMismatch = -1;
    char expected = ' ';
    char actual = ' ';

    for (int i = 0; i < original.length(); i++) {
        if (original.charAt(i) == typed.charAt(i)) {
            matchCount++;
        } else if (firstMismatch == -1) {
            firstMismatch = i + 1;
            expected = original.charAt(i);
            actual = typed.charAt(i);
        }
    }

    double accuracy = (double) matchCount / original.length() * 100;

    System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matchCount, original.length(), accuracy);
    if (firstMismatch == -1) {
        System.out.println("No Mismatches");
    } else {
        System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n", firstMismatch, expected, actual);
    }
}