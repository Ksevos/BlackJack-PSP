package GameClasses;

public class Card {

    private int cardID;
    private String cardSuit;
    private String cardName;

    public Card (String conSuit, int cardNumber){
        cardSuit = conSuit;
        cardID = cardNumber;
    }

    public int getCard () {
        return cardID;
    }

    public String toString() {
        cardName = new String();

        switch (cardID){
            case 1:
                cardName = "A";
                break;

            case 2:
                cardName = "2";
                break;

            case 3:
                cardName = "3";
                break;

            case 4:
                cardName = "4";
                break;

            case 5:
                cardName = "5";
                break;

            case 6:
                cardName = "6";
                break;

            case 7:
                cardName = "7";
                break;

            case 8:
                cardName = "8";
                break;

            case 9:
                cardName = "9";
                break;

            case 10:
                cardName = "10";
                break;

            case 11:
                cardName = "J";
                break;

            case 12:
                cardName = "Q";
                break;

            case 13:
                cardName = "K";
                break;

        }

        return  cardName + " of " + cardSuit;
    }
}