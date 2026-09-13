import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // predefined for demo
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;
        int n = 5;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < n; i++) {
            computerMoves[i] = choices[random.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.printf("Round %d | %-11s | %-13s | %s\n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);

            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercentage = ((double) wins / n) * 100;

        System.out.println("\nFinal Summary (after 5 rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                wins, losses, draws, winPercentage);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}