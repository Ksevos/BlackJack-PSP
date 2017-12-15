import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> Cards = new ArrayList<Card>();

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
                Cards.add(new Card(suitName, j));
            }
        }
        Collections.shuffle(Cards);
    }

    public Card DealACard (){
        Card toDeal = Cards.get(0);
        Cards.remove(0);
        return toDeal;
    }
}