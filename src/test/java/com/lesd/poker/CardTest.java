package com.lesd.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 10/4/12
 * Time: 12:34 PM
 */
public class CardTest
{

   @Test
   public void cardEqualTest()
   {
      Card card1 = CardFactory.createCard("2D");
      Card card2 = CardFactory.createCard("2D");
      assertEquals(card1, card2);
   }

}
