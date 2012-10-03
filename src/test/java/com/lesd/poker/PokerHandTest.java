package com.lesd.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/25/12
 * Time: 12:52 PM
 */
public class PokerHandTest
{

   @Test
   public static void testFindHighCard()
   {
      PokerHand hand = HandFactory.createHand("2H 3D 5S 9C KD");
      Card cardKD = CardFactory.createCard("KD");
      assertEquals(cardKD, PokerHandEvaluator.evaluateHand(hand));
   }

}
