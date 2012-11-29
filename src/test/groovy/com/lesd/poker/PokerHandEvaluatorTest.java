package com.lesd.poker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/25/12
 * Time: 12:42 PM
 */
public class PokerHandEvaluatorTest
{

   @Test
   public void testFindHighRank()
   {
      PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();

      PokerHand hand = HandFactory.createHand("2H 3D 5S 9C KD");
      assertEquals(Rank.KING, pokerHandEvaluator.findHighRank(hand));

      PokerHand hand1 = HandFactory.createHand("KH 3D 5S 9C KD");
      assertEquals(Rank.KING, pokerHandEvaluator.findHighRank(hand1));
   }

   @Test
   public void testResultEvaluatorHighCard()
   {
      PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();

      PokerHand hand = HandFactory.createHand("2H 3D 5S 9C KD");
      PokerHandResult pokerHandResult = pokerHandEvaluator.evaluate(hand);
      assertEquals(PokerHandType.HIGHCARD, pokerHandResult.getHandType());

      List<Rank> orderedRankList = pokerHandResult.getOrderedRankList();
      assertEquals(5, orderedRankList.size());
      assertEquals(Rank.KING, orderedRankList.get(0));
      assertEquals(Rank.NINE, orderedRankList.get(1));
      assertEquals(Rank.FIVE, orderedRankList.get(2));
      assertEquals(Rank.THREE, orderedRankList.get(3));
      assertEquals(Rank.TWO, orderedRankList.get(4));
   }

   @Test
   public void testResultEvaluatorPair()
   {
      PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();

      PokerHand hand = HandFactory.createHand("2H 2D 5S 9C KD");
      PokerHandResult pokerHandResult = pokerHandEvaluator.evaluate(hand);
      assertEquals(PokerHandType.PAIR, pokerHandResult.getHandType());

      List<Rank> orderedRankList = pokerHandResult.getOrderedRankList();
      assertEquals(4, orderedRankList.size());
      assertEquals(Rank.TWO, orderedRankList.get(0));
      assertEquals(Rank.KING, orderedRankList.get(1));
      assertEquals(Rank.NINE, orderedRankList.get(2));
      assertEquals(Rank.FIVE, orderedRankList.get(3));
   }

   @Test
   public void testResultEvaluatorTwoPair()
   {
      PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();

      PokerHand hand = HandFactory.createHand("2H 2D 5S 5C KD");
      PokerHandResult pokerHandResult = pokerHandEvaluator.evaluate(hand);
      assertEquals(PokerHandType.TWOPAIR, pokerHandResult.getHandType());

      List<Rank> orderedRankList = pokerHandResult.getOrderedRankList();
      assertEquals(3, orderedRankList.size());
      assertEquals(Rank.FIVE, orderedRankList.get(0));
      assertEquals(Rank.TWO, orderedRankList.get(1));
      assertEquals(Rank.KING, orderedRankList.get(2));
   }

   @Test
   public void testResultEvaluatorThreeOfAKind()
   {
      PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();

      PokerHand hand = HandFactory.createHand("2H 2D 2S 9C KD");
      PokerHandResult pokerHandResult = pokerHandEvaluator.evaluate(hand);
      assertEquals(PokerHandType.THREEOFAKIND, pokerHandResult.getHandType());

      List<Rank> orderedRankList = pokerHandResult.getOrderedRankList();
      assertEquals(3, orderedRankList.size());
      assertEquals(Rank.TWO, orderedRankList.get(0));
      assertEquals(Rank.KING, orderedRankList.get(1));
      assertEquals(Rank.NINE, orderedRankList.get(2));
   }
   @Test
   public void testResultEvaluatorStraight()
   {
      PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();

      PokerHand hand = HandFactory.createHand("2H 3D 4S 5C 6D");
      PokerHandResult pokerHandResult = pokerHandEvaluator.evaluate(hand);
      assertEquals(PokerHandType.STRAIGHT, pokerHandResult.getHandType());

      List<Rank> orderedRankList = pokerHandResult.getOrderedRankList();
      assertEquals(1, orderedRankList.size());
      assertEquals(Rank.SIX, orderedRankList.get(0));
   }

   @Test
   public void testResultEvaluatorStraightAceLow()
   {
      PokerHandEvaluator pokerHandEvaluator = new PokerHandEvaluator();

      PokerHand hand = HandFactory.createHand("AH 2D 3S 4C 5D");
      PokerHandResult pokerHandResult = pokerHandEvaluator.evaluate(hand);
      assertEquals(PokerHandType.STRAIGHT, pokerHandResult.getHandType());

      List<Rank> orderedRankList = pokerHandResult.getOrderedRankList();
      assertEquals(1, orderedRankList.size());
      assertEquals(Rank.FIVE, orderedRankList.get(0));
   }

}
