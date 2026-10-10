public void checkDuplicateSeats(int[] seatNumbers) {
    boolean found = false;
    boolean[] printed = new boolean[seatNumbers.length];

    for (int i = 0; i < seatNumbers.length; i++) {
        if (printed[i]) continue;
        boolean isDuplicate = false;

        for (int j = i + 1; j < seatNumbers.length; j++) {
            if (seatNumbers[i] == seatNumbers[j]) {
                isDuplicate = true;
                printed[j] = true;
            }
        }

        if (isDuplicate) {
            System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No Duplicate Seats Found");
    }
}