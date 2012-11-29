package com.lesd.poker;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/18/12
 * Time: 11:59 AM
 */
public class HandFactoryTest
{
//   @Test
//   public void testHighCardWins()
//   {
//      assertEquals("White wins. - with high card: Ace", PokerHand.evaluateBlackVsWhite("2H 3D 5S 9C KD", "2C 3H 4S 8C AH"));
//   }

   @Test
   public void testCreateHand()
   {
      PokerHand hand = HandFactory.createHand("2H 3D 5S 9C KD");
      assertEquals(hand.getCards().size(), 5);
      Assert.assertEquals(hand.getCards().get(0).getRank(), Rank.TWO);
      Assert.assertEquals(hand.getCards().get(0).getSuit(), Suit.HEARTS);
   }


}
