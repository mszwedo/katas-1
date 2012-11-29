package com.lesd.poker;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 10/30/12
 * Time: 12:28 PM
 */
public class PokerHandResult implements Comparable<PokerHandResult>
{
   public PokerHandResult(PokerHandType handType, List<Rank> orderedRankList)
   {
      this.handType = handType;
      this.orderedRankList = orderedRankList;
   }

   public PokerHandType getHandType()
   {
      return handType;
   }

   public List<Rank> getOrderedRankList()
   {
      return orderedRankList;
   }

   public int compareTo(PokerHandResult result)
   {
      return new PokerHandResultComparator().compare(this, result);
   }

   private PokerHandType handType;
   private List<Rank> orderedRankList;
}