package com.lesd.poker;

import java.util.Comparator;
import java.util.List;

public class PokerHandResultComparator implements Comparator<PokerHandResult>
{
   public int compare(PokerHandResult result1, PokerHandResult result2)
   {
      int comparison = result1.getHandType().compareTo(result2.getHandType());

      if (comparison != 0)
         return comparison;

      List<Rank> orderedRankList1 = result1.getOrderedRankList();
      List<Rank> orderedRankList2 = result2.getOrderedRankList();
      for (int i = 0; i < orderedRankList1.size(); i++)
      {
         comparison = orderedRankList1.get(i).compareTo(orderedRankList2.get(i));
         if (comparison != 0)
            return comparison;
      }

      return 0;
   }
}
