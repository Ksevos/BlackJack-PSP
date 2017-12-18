package GameClasses;

import GameClasses.Card;
import GameClasses.Hand;

import java.util.ArrayList;

public class Dealer extends Hand {

    final static int soft = 17;

    public Dealer() {
        super();
        setDealerName();
    }

    public boolean stayCondition(){
        if (this.handSum()>=soft) return true;

        else return false;
    }

    public void setDealerName(){
        playerName = "Dealer";
    }
}
