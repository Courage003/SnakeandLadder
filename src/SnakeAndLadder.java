public class SnakeAndLadder {
    private static final int WINNING_POSITION = 100;

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Simulator");

        int playerPosition = 0;
        int diceRollCount = 0;

        while (playerPosition < WINNING_POSITION) {
            // Rolling the die
            int dieRoll = (int) (Math.random() * 6) + 1;
            diceRollCount++;

            // Options: 0 -> No Play, 1 -> Ladder, 2 -> Snake
            int option = (int) (Math.random() * 3);

            switch (option) {
                case 0: // No Play
                    break;

                case 1: // Ladder
                    if (playerPosition + dieRoll <= WINNING_POSITION) {
                        playerPosition += dieRoll;
                    }
                    break;

                case 2: // Snake
                    playerPosition -= dieRoll;
                    if (playerPosition < 0) playerPosition = 0;
                    break;
            }

            System.out.println("Player rolled: " + dieRoll + ", Current position: " + playerPosition);
        }

        System.out.println("Player reached the winning position in " + diceRollCount + " rolls!");
    }
}
