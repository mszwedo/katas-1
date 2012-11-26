package com.lesd.poker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.lesd.poker.PokerHandType.HIGHCARD;
import static com.lesd.poker.PokerHandType.PAIR;
import static com.lesd.poker.Rank.EIGHT;
import static com.lesd.poker.Rank.KING;
import static com.lesd.poker.Rank.NINE;
import static com.lesd.poker.Rank.SEVEN;
import static com.lesd.poker.Rank.SIX;
import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 11/13/12
 * Time: 12:31 PM
 */
public class PokerHandResultComparatorTest
{
   @Test
   public void handTypeCheckedFirstTest()
   {
      PokerHandResult player1Result = new PokerHandResult(HIGHCARD, new ArrayList<Rank>());
      PokerHandResult player2Result = new PokerHandResult(PAIR, new ArrayList<Rank>());

      PokerHandResultComparator pokerHandResultComparator = new PokerHandResultComparator();

      assertEquals(-1, pokerHandResultComparator.compare(player1Result, player2Result));
      assertEquals(1, pokerHandResultComparator.compare(player2Result, player1Result));
   }

   @Test
   public void tie()
   {
      List<Rank> orderedRankList1 = Arrays.asList(KING, EIGHT, SEVEN, SIX);
      List<Rank> orderedRankList2 = Arrays.asList(KING, EIGHT, SEVEN, SIX);

      PokerHandResult player1Result = new PokerHandResult(PAIR, orderedRankList1);
      PokerHandResult player2Result = new PokerHandResult(PAIR, orderedRankList2);

      PokerHandResultComparator pokerHandResultComparator = new PokerHandResultComparator();

      assertEquals(0, pokerHandResultComparator.compare(player1Result, player2Result));
   }

   @Test
   public void rankIsCheckedSecond()
   {
      List<Rank> orderedRankList1 = Arrays.asList(KING, NINE, SEVEN, SIX);
      List<Rank> orderedRankList2 = Arrays.asList(KING, EIGHT, SEVEN, SIX);

      PokerHandResult player1Result = new PokerHandResult(PAIR, orderedRankList1);
      PokerHandResult player2Result = new PokerHandResult(PAIR, orderedRankList2);

      PokerHandResultComparator pokerHandResultComparator = new PokerHandResultComparator();

      assertEquals(1, pokerHandResultComparator.compare(player1Result, player2Result));
      assertEquals(-1, pokerHandResultComparator.compare(player2Result, player1Result));
   }
}
