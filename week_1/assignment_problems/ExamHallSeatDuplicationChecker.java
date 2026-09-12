
public class ExamHallSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            throw new IllegalArgumentException("Seat numbers array cannot be null or empty.");
        }

        boolean duplicateFound = false;
        boolean[] alreadyReported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    alreadyReported[j] = true;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] seatsWithDuplicate = {101, 102, 103, 102, 105};
        int[] seatsWithoutDuplicate = {101, 102, 103, 104, 105};

        try {
            System.out.println("Test 1:");
            checkDuplicateSeats(seatsWithDuplicate);

            System.out.println("\nTest 2:");
            checkDuplicateSeats(seatsWithoutDuplicate);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}