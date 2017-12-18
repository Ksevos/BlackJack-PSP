package GameClasses;

import java.util.Scanner;

public class Screen {

    Screen (){}

    public void printDecks(String playerName, Hand player, Hand dealer, boolean endgame) {

        if(!endgame) {
            System.out.println(playerName + "'s score:");
            System.out.println(player.handSum());
            System.out.println(playerName + "'s cards:");
            player.playerDeck();
            System.out.println();
            System.out.println("Dealer's cards:");
            dealer.dealerDeck(endgame);
            System.out.println();
        }

        else{
            System.out.println(playerName + "'s score:");
            System.out.println(player.handSum());
            System.out.println(playerName + "'s cards:");
            player.playerDeck();
            System.out.println();
            System.out.println("Dealer's score:");
            System.out.println(dealer.handSum());
            System.out.println("Dealer's cards:");
            dealer.dealerDeck(endgame);
            System.out.println();
        }
    }

    public void deal(Hand player, Hand dealer, Deck deck){
        player.takeCard(deck);
        dealer.takeCard(deck);
        player.takeCard(deck);
        dealer.takeCard(deck);
    }

    public String hitOrStay (Scanner scanner) {
        String i;
        System.out.println("Hit or stay? (H/S):");
        i = scanner.next();
        System.out.println();
        return  i;
    }

    public boolean playerTurn(Scanner scanner, Screen screen, Hand player, Deck deck){
        String input = screen.hitOrStay(scanner);
        while (input.compareToIgnoreCase("H")!=0 && input.compareToIgnoreCase("S")!=0){
            input = screen.hitOrStay(scanner);
        }

        if (input.compareToIgnoreCase("H")==0) {
            player.takeCard(deck);
            System.out.println("Player's score: " + player.handSum() + ". Player's cards");
            player.playerDeck();
        }

        else if (input.compareToIgnoreCase("S")==0) {
            return true;
        }

        if (player.handSum()>=21) return true;
        else return false;
    }

    public void endGame(Hand player, Dealer dealer){
        if (player.handSum()>21 && dealer.handSum()>21){
            System.out.println("***BOTH BUSTED! DRAW***");
        }

        else if (player.handSum()>21 && dealer.handSum()<=21){
            System.out.println("***BUSTED! DEALER WINS!***");
        }

        else if (player.handSum()>dealer.handSum()){
            System.out.println("***CONGRATULATIONS! YOU WIN!***");
        }

        else if (player.handSum()<dealer.handSum()){
            System.out.println("***OOOW... DEALER WINS. BETTER LUCK NEXT TIME!***");
        }

        else System.out.println("***DRAW!***");
    }

}
