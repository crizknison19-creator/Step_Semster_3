import java.util.*;
public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final int TOTAL_ROUNDS = 5;

    public static String generateComputerMove() {
        Random random = new Random();
        int index = random.nextInt(MOVES.length);
        return MOVES[index];
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }
    public static void printScoreboard(int[] roundNumbers, String[] playerMoves,
                                        String[] computerMoves, String[] results) {
        System.out.println("\nRound | Player Move | Computer Move | Result");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < roundNumbers.length; i++) {
            System.out.printf("%-5d | %-11s | %-14s | %s%n",
                    roundNumbers[i], playerMoves[i], computerMoves[i], results[i]);
        }
    }


    public static void printFinalSummary(int wins, int losses, int draws, int totalRounds) {
        double winPercentage = (wins * 100.0) / totalRounds;
        System.out.printf("%nFinal Summary (after %d rounds)%n", totalRounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        String[] predefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        int[] roundNumbers = new int[TOTAL_ROUNDS];
        String[] playerMoves = new String[TOTAL_ROUNDS];
        String[] computerMoves = new String[TOTAL_ROUNDS];
        String[] results = new String[TOTAL_ROUNDS];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        try {
            for (int i = 0; i < TOTAL_ROUNDS; i++) {
                String playerMove = predefinedPlayerMoves[i];
                String computerMove = generateComputerMove();
                String result = playRound(playerMove, computerMove);

                roundNumbers[i] = i + 1;
                playerMoves[i] = playerMove;
                computerMoves[i] = computerMove;
                results[i] = result;

                if (result.equals("Player Wins")) {
                    wins++;
                } else if (result.equals("Computer Wins")) {
                    losses++;
                } else {
                    draws++;
                }
            }

            printScoreboard(roundNumbers, playerMoves, computerMoves, results);
            printFinalSummary(wins, losses, draws, TOTAL_ROUNDS);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Not enough predefined player moves for the requested rounds.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}