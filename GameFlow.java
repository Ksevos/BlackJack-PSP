package GameClasses;

import java.util.Scanner;

public class GameFlow {

    public GameFlow(){}

    public void start() {

        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Screen screen = new Screen();
        String input, playerName;

        System.out.println("Enter player's name:");
        input = scanner.next();
        playerName = input;

        Hand player = new Player(playerName);
        Dealer dealer = new Dealer();

        screen.deal(player, dealer, deck);
        screen.printDecks(playerName, player, dealer, false);

        boolean playerStays = player.ifEnough();

        while (!playerStays || !dealer.stayCondition()) {
            if (!playerStays) {
                playerStays = screen.playerTurn(scanner, screen, player, deck);
            }
            if (!dealer.stayCondition()) dealer.takeCard(deck);
            screen.printDecks(playerName, player, dealer, false);
        }

        screen.printDecks(playerName, player, dealer, true);
        screen.endGame(player, dealer);
        scanner.close();

    }

}
