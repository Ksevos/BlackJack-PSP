import java.util.ArrayList;

public class Hand {
    private String playerName;
    private ArrayList<Card> playerCards;

    public Hand (String handName){
        playerName = handName;
        playerCards = new ArrayList<Card>();
    }

    public void takeCard (Deck d){
        playerCards.add(d.DealACard());
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
                sum += 11;
            } else if (id > 10){
                sum += 10;
            } else {
                sum += id;
            }
        }

        while (sum > 21 && aces > 0){
            sum -= 10;
            aces--;
        }

        return sum;
    }

    public void playerDeck (){
        for (int i=0; i<playerCards.size(); i++) {
            Card printCard = playerCards.get(i);
            System.out.println("  " + printCard.toString());
        }
    }

    public void dealerDeck (){
        for (int i=0; i<playerCards.size(); i++) {
            Card printCard = playerCards.get(i);
            if (i==0) System.out.println("  " + printCard.toString());
            else System.out.println(" [hidden]");
        }
    }

    public boolean stayCondition(){
        if (this.handSum()>=21){
            return  true;
        }
        else return false;
    }
}