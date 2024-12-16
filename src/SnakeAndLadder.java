public class SnakeAndLadder {
    public static void main(String[] args){
        System.out.println("Welcome to Snake and Ladder Simulator");

        int playerPosition =0;
        //Rolling die
        int dieRoll= (int)(Math.random()*6)+1;
        System.out.println("Player rolls die: "+ dieRoll);

        // Options: 0 -> No Play, 1 -> Ladder, 2 -> Snake
        int option = (int) (Math.random() * 3);
        switch (option) {
            case 0:
                System.out.println("No Play: Player stays at the same position.");
                break;
            case 1:
                playerPosition += dieRoll;
                System.out.println("Ladder: Player moves ahead to position " + playerPosition);
                break;
            case 2:
                playerPosition -= dieRoll;
                if (playerPosition < 0) playerPosition = 0;
                System.out.println("Snake: Player moves back to position " + playerPosition);
                break;
        }

    }
}
