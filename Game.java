import java.util.Scanner;

public class Game {

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        String input, playerName;

        System.out.println("Iveskite savo varda:");
        input = scanner.next();
        playerName = input;

        Hand player = new Hand (playerName);
        Hand dealer = new Hand ("Dealer");

        player.takeCard(deck);
        dealer.takeCard(deck);
        player.takeCard(deck);
        dealer.takeCard(deck);

        System.out.println(playerName + "'s cards:");
        player.playerDeck();
        System.out.println();
        System.out.println("Dealer's cards:");
        dealer.dealerDeck();
        System.out.println();

        boolean playerStays = false;
        boolean dealerStays = false;

        while (!playerStays || !dealerStays){
            if (!playerStays){

                System.out.println("Hit or stay? (H/S):");
                input = scanner.next();
                System.out.println();
                if (input.compareToIgnoreCase("H")==0) {
                    player.takeCard(deck);
                }
                    else{
                    playerStays=true;
                }
            }

            if (!dealerStays){
                if (dealer.handSum()<17) {
                    dealer.takeCard(deck);
                    if (dealer.handSum()>=21) dealerStays=true;
                } else dealerStays = true;
            }
            System.out.println(playerName + "'s cards:");
            player.playerDeck();
            System.out.println();
            System.out.println("Dealer's cards:");
            dealer.dealerDeck();
            System.out.println();
        }

        System.out.println(playerName + "'s cards:");
        player.playerDeck();
        System.out.println();
        System.out.println("Dealer's cards:");
        dealer.playerDeck();
        System.out.println();

        if (player.handSum()>dealer.handSum() && player.handSum()<=21 || dealer.handSum()>21){
            System.out.println("***CONGRATULATIONS! YOU WIN!***");
        } else {
            System.out.println("***OOOW... DEALER WINS. BETTER LUCK NEXT TIME!***");
        }
        scanner.close();
    }
}