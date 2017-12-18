package GameClasses;

import GameClasses.Card;
import GameClasses.Hand;

import java.util.ArrayList;

public class Player extends Hand {

    public Player(String handName) {
        super();
        setPlayerName(handName);
    }

    public void setPlayerName(String pName){
        this.playerName = pName;
    }
}
