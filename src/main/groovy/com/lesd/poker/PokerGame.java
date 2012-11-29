package com.lesd.poker;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 10/9/12
 * Time: 12:43 PM
 */
public class PokerGame
{
   private final PokerHand hand1;
   private final PokerHand hand2;

   public PokerGame(PokerHand hand1, PokerHand hand2)
   {
      this.hand1 = hand1;
      this.hand2 = hand2;
   }

   public Winner winner()
   {
      PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();

      PokerHandResult result1 = pokerHandEvaluator.evaluate(hand1);
      PokerHandResult result2 = pokerHandEvaluator.evaluate(hand2);

      int comparison = result1.compareTo(result2);

      if (comparison > 0)
         return Winner.PLAYER1;
      if (comparison < 0)
         return Winner.PLAYER2;

      return Winner.TIE;
   }
}
