package GameClasses;

import GameClasses.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Deck() {
        for (int i=1; i<=4; i++){
            String suitName = null;

            switch (i){
                case 1:
                    suitName = "Hearts";
                    break;
                case 2:
                    suitName = "Spades";
                    break;
                case 3:
                    suitName = "Clubs";
                    break;
                case 4:
                    suitName = "Diamonds";
                    break;
            }

            for (int j=1; j<=13; j++){
                cards.add(new Card(suitName, j));
            }
        }

        Collections.shuffle(cards);
    }

    public Card dealACard (){
        Card toDeal = cards.get(0);
        cards.remove(0);
        return toDeal;
    }
}