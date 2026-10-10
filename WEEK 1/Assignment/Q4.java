public void analyzeInventory(int[] sectionA, int[] sectionB) {
    int totalA = 0;
    int totalB = 0;
    int maxQuantity = -1;
    String maxSection = "";
    int maxIndex = -1;

    for (int i = 0; i < sectionA.length; i++) {
        totalA += sectionA[i];
        if (sectionA[i] > maxQuantity) {
            maxQuantity = sectionA[i];
            maxSection = "Section A";
            maxIndex = i + 1;
        }
    }

    for (int i = 0; i < sectionB.length; i++) {
        totalB += sectionB[i];
        if (sectionB[i] > maxQuantity) {
            maxQuantity = sectionB[i];
            maxSection = "Section B";
            maxIndex = i + 1;
        }
    }

    String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

    System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
            totalA, totalB, status, maxQuantity, maxSection, maxIndex);
}