package GameClasses;

import GameClasses.Card;
import GameClasses.Deck;

import java.util.ArrayList;

public class Hand {
    protected String playerName;
    protected ArrayList<Card> playerCards;
    protected int ace = 11, faceCardOrMinusAce = 10;
    protected int blackjack = 21;

    public Hand (){
        playerCards = new ArrayList<Card>();
    }

    public void takeCard (Deck d){
        playerCards.add(d.dealACard());
    }

    public int handSum (){
        int sum = 0;
        int aces = 0;
        int id;

        for (int i=0; i<playerCards.size(); i++){
            Card temp = playerCards.get(i);
            id = temp.getCard();

            if (id == 1){
                aces++;
                sum += ace;
            }

            else if (id > 10){
                sum += faceCardOrMinusAce;
            }

            else {
                sum += id;
            }
        }

        while (sum > 21 && aces > 0){
            sum -= faceCardOrMinusAce;
            aces--;
        }

        return sum;
    }

    public void playerDeck (){

        for (int i=0; i<playerCards.size(); i++) {
            Card printCard = playerCards.get(i);
            System.out.println("  " + printCard.toString());
            System.out.println();
        }
    }

    public void dealerDeck (boolean endgame){
        if (!endgame) {
            for (int i = 0; i < playerCards.size(); i++) {
                Card printCard = playerCards.get(i);
                if (i == 0) System.out.println("  " + printCard.toString());
                else System.out.println(" [hidden]");
            }
        }

        else {
            for (int i=0; i<playerCards.size(); i++) {
                Card printCard = playerCards.get(i);
                System.out.println("  " + printCard.toString());
            }
        }
    }

    public String getPlayerName(){
        return playerName;
    }

    public boolean ifEnough(){
        if (handSum()>=blackjack){
            return true;
        }

        else return false;
    }
}