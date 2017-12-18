package TestClasses;

import GameClasses.Dealer;
import GameClasses.Deck;
import GameClasses.Hand;
import org.junit.Assert;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    public void checkDealersName() {
        String d = "Dealer";

        Dealer test = new Dealer();

        Assert.assertEquals(d, test.getPlayerName());
    }

    @Test
    public void ifHandIsLessThanBJ() {
        Hand test = new Hand();

        Deck test1 = new Deck();

        for (int i=0; i<=1; i++){
            test.takeCard(test1);
        }

        Assert.assertTrue(test.handSum()<=21);
    }
}
