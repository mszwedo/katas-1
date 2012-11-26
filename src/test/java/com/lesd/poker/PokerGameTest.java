package com.lesd.poker;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 10/9/12
 * Time: 12:39 PM
 */
public class PokerGameTest
{
   @Test
   public void testHighCardWins()
   {
      PokerHand hand1 = HandFactory.createHand("2H 3D 5S 9C KD");
      PokerHand hand2 = HandFactory.createHand("KH 2D 6S 8C AD");
      PokerGame game = new PokerGame(hand1, hand2);
      assertEquals(Winner.PLAYER2, game.winner());

      hand1 = HandFactory.createHand("2H 3D 5S 9C AD");
      hand2 = HandFactory.createHand("KH 2D 6S 8C QD");
      game = new PokerGame(hand1, hand2);
      assertEquals(Winner.PLAYER1, game.winner());

      hand1 = HandFactory.createHand("KD 3D 5S 9C AD");
      hand2 = HandFactory.createHand("KH 2D 6S 8C AS");
      game = new PokerGame(hand1, hand2);
      assertEquals(Winner.PLAYER1, game.winner());
   }

   @Test
   public void testHighCardTie()
   {
      PokerHand hand1 = HandFactory.createHand("2H 3H 5H 9H KH");
      PokerHand hand2 = HandFactory.createHand("2D 3D 5D 9D KD");
      PokerGame game = new PokerGame(hand1, hand2);
      assertEquals(Winner.TIE, game.winner());
   }

   @Test
   public void testPairBeatsHighCard()
   {
      PokerHand hand1 = HandFactory.createHand("2H 2D 5H 9H KH");
      PokerHand hand2 = HandFactory.createHand("2S 3D 5D 9D KD");
      PokerGame game = new PokerGame(hand1, hand2);
      assertEquals(Winner.PLAYER1, game.winner());
   }

   @Test
   public void testHighPairBeatsLowPair()
   {
      PokerHand hand1 = HandFactory.createHand("2S 2D 5D 9D KD");
      PokerHand hand2 = HandFactory.createHand("3H 3D 5H 9H QH");
      PokerGame game = new PokerGame(hand1, hand2);
      assertEquals(Winner.PLAYER2, game.winner());
   }
}
