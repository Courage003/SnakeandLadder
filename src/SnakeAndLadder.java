public class SnakeAndLadder {
    private static final int WINNING_POSITION = 100;

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Simulator");

        // Initialize players' positions
        int player1Position = 0;
        int player2Position = 0;
        int player1DiceRolls = 0;
        int player2DiceRolls = 0;

        boolean isPlayer1Turn = true; // Start with Player 1

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            // Roll the dice
            int dieRoll = (int) (Math.random() * 6) + 1;

            // Switch turn between players
            if (isPlayer1Turn) {
                player1DiceRolls++;
                System.out.println("Player 1 rolled: " + dieRoll);

                // Determine the action (No Play, Ladder, Snake)
                player1Position = determineAction(player1Position, dieRoll);

                System.out.println("Player 1's position: " + player1Position);

                // If Player 1 hits a ladder, they get another turn
                if (player1Position < WINNING_POSITION && !hitLadder()) {
                    isPlayer1Turn = false;
                }
            } else {
                player2DiceRolls++;
                System.out.println("Player 2 rolled: " + dieRoll);

                // Determine the action (No Play, Ladder, Snake)
                player2Position = determineAction(player2Position, dieRoll);

                System.out.println("Player 2's position: " + player2Position);

                // If Player 2 hits a ladder, they get another turn
                if (player2Position < WINNING_POSITION && !hitLadder()) {
                    isPlayer1Turn = true;
                }
            }
        }

        // Determine the winner
        if (player1Position == WINNING_POSITION) {
            System.out.println("Player 1 wins the game in " + player1DiceRolls + " rolls!");
        } else {
            System.out.println("Player 2 wins the game in " + player2DiceRolls + " rolls!");
        }
    }

    /**
     * Determines the player's new position based on the die roll and the action.
     *
     * @param currentPosition The current position of the player.
     * @param dieRoll         The number rolled on the die.
     * @return The new position of the player.
     */
    private static int determineAction(int currentPosition, int dieRoll) {
        // Options: 0 -> No Play, 1 -> Ladder, 2 -> Snake
        int option = (int) (Math.random() * 3);

        switch (option) {
            case 0: // No Play
                System.out.println("No Play: Player stays at the same position.");
                break;

            case 1: // Ladder
                System.out.println("Ladder: Player climbs up " + dieRoll + " steps.");
                if (currentPosition + dieRoll <= WINNING_POSITION) {
                    currentPosition += dieRoll;
                }
                break;

            case 2: // Snake
                System.out.println("Snake: Player goes down " + dieRoll + " steps.");
                currentPosition -= dieRoll;
                if (currentPosition < 0) {
                    currentPosition = 0;
                }
                break;
        }

        return currentPosition;
    }

    /**
     * Simulates whether the player hit a ladder.
     *
     * @return True if the player hit a ladder, otherwise false.
     */
    private static boolean hitLadder() {
        int option = (int) (Math.random() * 3);
        return option == 1; // Ladder case
    }
}
