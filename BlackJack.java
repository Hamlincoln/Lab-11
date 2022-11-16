import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) throws InterruptedException {
        Deck deck = new Deck();
        Scanner scnr = new Scanner(System.in);
        boolean playAgain = false;

        int houseTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
        int playerTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);

        System.out.println("The House is showing: " + houseTotal);

        System.out.println("Do you want to play a round of BlackJack?");
        String response = scnr.next();
        scnr.nextLine();

        if (response.equals("yes")) {
            playAgain = true;
        }

        while (playAgain) {
            while (playerTotal <= 21 && houseTotal <= 21) {
                Thread.sleep(500);
                System.out.println("Player is showing: " + playerTotal);
                System.out.print("Would you like to hit or stand?\nEnter 1 for hit or 0 for stand: ");
                int choice = scnr.nextInt();

                if (choice == 0) {
                    // do nothing
                } else if (choice == 1) {
                    Thread.sleep(500);
                    Card nextCard = deck.drawCard();
                    System.out.println("Player draws the " + nextCard.declareCard());
                    playerTotal += nextCard.getValue(true);
                } else {
                    System.out.println("Invalid option, try again. ");
                }

                if (playerTotal > 21) {
                    Thread.sleep(500);
                    System.out.println("The Player has busted!");
                } else {
                    System.out.println("\nThe Player stands with " + playerTotal + " points.");
                    System.out.println("The House will play next. ");
                }

                if (houseTotal < 17) {
                    Card nextCard = deck.drawCard();
                    Thread.sleep(500);
                    System.out.println("House draws the " + nextCard.declareCard());
                    houseTotal += nextCard.getValue(true);
                } else if (houseTotal >= 17 && houseTotal <= 21) {
                    Thread.sleep(500);
                    System.out.println("\nThe House stands with " + houseTotal + " points.");
                } else if (houseTotal > 21) {
                    Thread.sleep(500);
                    System.out.println("The House has busted. ");
                }
            }

            if (houseTotal > 21) {
                Thread.sleep(500);
                System.out.println("The Player wins!");
            } else if (houseTotal > playerTotal) {
                Thread.sleep(500);
                System.out.println("The House wins!");
            } else if (houseTotal < playerTotal) {
                Thread.sleep(500);
                System.out.println("The Player wins!");
            } else if (houseTotal == playerTotal) {
                Thread.sleep(500);
                System.out.println("It's a tie!");
            }

            System.out.println("Do you want to play a round of BlackJack?");
            response = scnr.next();
            scnr.nextLine();

            if (response.equals("yes")) {
                playAgain = true;
            } else if (response.equals("no")) {
                playAgain = false;
            }
        }

        scnr.close();

    }

}
