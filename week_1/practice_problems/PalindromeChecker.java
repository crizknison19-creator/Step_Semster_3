
public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        String normalizedText = text.toLowerCase();
        int leftIndex = 0;
        int rightIndex = normalizedText.length() - 1;

        while (leftIndex < rightIndex) {
            if (normalizedText.charAt(leftIndex) != normalizedText.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        String normalizedText = text.toLowerCase();
        return checkPalindromeRecursively(normalizedText, 0, normalizedText.length() - 1);
    }

    private static boolean checkPalindromeRecursively(String text, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return true;
        }
        if (text.charAt(leftIndex) != text.charAt(rightIndex)) {
            return false;
        }
        return checkPalindromeRecursively(text, leftIndex + 1, rightIndex - 1);
    }


    public static boolean isPalindromeArrayReversal(String text) {
        String normalizedText = text.toLowerCase();
        char[] originalChars = normalizedText.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        String reversedText = new String(reversedChars);
        return normalizedText.equals(reversedText);
    }

    private static String describeResult(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void verifyAndPrint(String text) {
        try {
            if (text == null || text.isEmpty()) {
                throw new IllegalArgumentException("Input text cannot be null or empty.");
            }

            boolean iterativeResult = isPalindromeIterative(text);
            boolean recursiveResult = isPalindromeRecursive(text);
            boolean arrayReversalResult = isPalindromeArrayReversal(text);

            System.out.printf("Input: \"%s\"%n", text);
            System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n",
                    describeResult(iterativeResult),
                    describeResult(recursiveResult),
                    describeResult(arrayReversalResult));

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] sampleInputs = {"madam", "hello", "Racecar", "Java"};

        for (String sample : sampleInputs) {
            verifyAndPrint(sample);
        }
    }
}