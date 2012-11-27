package com.lesd.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/20/12
 * Time: 12:57 PM
 */
public class PokerHandEvaluator
{

   public Rank findHighRank(PokerHand hand)
   {
      Card highCard = hand.getCards().get(0);

      for (Card card : hand.getCards())
      {
         if (card.getRank().compareTo(highCard.getRank()) > 0)
            highCard = card;
      }

      return highCard.getRank();
   }

   public PokerHandResult evaluate(PokerHand hand)
   {
      List<Rank> rankList = new ArrayList<Rank>();
      for (Card card : hand.getCards())
      {
         rankList.add(card.getRank());
      }

      descendingSort(rankList);

      Map<Rank, Integer> rankCountMap = createRankMap(rankList);

      PokerHandResult pokerHandResult = checkAllPokerHandTypes(rankList, rankCountMap);

      return pokerHandResult;
   }

   private void descendingSort(List<Rank> rankList)
   {
      Collections.sort(rankList);
      Collections.reverse(rankList);
   }

   public PokerHandResult checkAllPokerHandTypes(List<Rank> rankList, Map<Rank, Integer> rankCountMap)
   {
      PokerHandResult pokerHandResult = null;

      pokerHandResult = checkStraight(rankList);
      if (pokerHandResult == null)
      {
         pokerHandResult = checkThreeOfAKind(rankList, rankCountMap);
      }
      if (pokerHandResult == null)
      {
         pokerHandResult = checkTwoPair(rankList, rankCountMap);
      }

      if (pokerHandResult == null)
      {
         pokerHandResult = checkPair(rankList, rankCountMap);
      }

      if (pokerHandResult == null)
      {
         pokerHandResult = new PokerHandResult(PokerHandType.HIGHCARD, rankList);
      }

      return pokerHandResult;
   }

   private PokerHandResult checkTwoPair(List<Rank> rankList, Map<Rank, Integer> rankCountMap)
   {
      List<Rank> newRankList = new ArrayList<Rank>();

      for (Rank rank : rankCountMap.keySet())
      {
         if (rankCountMap.get(rank) == 2)
         {
            newRankList.add(rank);
         }
      }

      if (newRankList.size() < 2)
      {
         return null;
      }

      descendingSort(newRankList);
      return new PokerHandResult(PokerHandType.TWOPAIR, createRankListAddingUnusedRanks(newRankList, rankList));
   }

   public PokerHandResult checkPair(List<Rank> rankList, Map<Rank, Integer> rankCountMap)
   {
      List<Rank> newRankList = new ArrayList<Rank>();

      for (Rank rank : rankCountMap.keySet())
      {
         if (rankCountMap.get(rank) == 2)
         {
            newRankList.add(rank);
            break;
         }
      }

      if (newRankList.isEmpty())
         return null;

      return new PokerHandResult(PokerHandType.PAIR, createRankListAddingUnusedRanks(newRankList, rankList));
   }

   public PokerHandResult checkThreeOfAKind(List<Rank> rankList, Map<Rank, Integer> rankCountMap)
   {
      List<Rank> newRankList = new ArrayList<Rank>();

      for (Rank rank : rankCountMap.keySet())
      {
         if (rankCountMap.get(rank) == 3)
         {
            newRankList.add(rank);
            break;
         }
      }

      if (newRankList.isEmpty())
         return null;

      return new PokerHandResult(PokerHandType.THREEOFAKIND, createRankListAddingUnusedRanks(newRankList, rankList));
   }

   public PokerHandResult checkStraight(List<Rank> rankList)
   {
      int startIndex = 0;

      if (rankList.get(0) == Rank.ACE && rankList.get(1) == Rank.FIVE)
         startIndex = 1;

      for (int i = startIndex; i < 4; i++)
      {
         int thisCard = rankList.get(i).ordinal();
         int nextCard = rankList.get(i + 1).ordinal();

         if (thisCard != nextCard + 1)
            return null;
      }

      List<Rank> newRankList = new ArrayList();
      newRankList.add(rankList.get(startIndex));

      return new PokerHandResult(PokerHandType.STRAIGHT, newRankList);
   }

   private List<Rank> createRankListAddingUnusedRanks(List<Rank> alreadyUsedRanks, List<Rank> ranksToCheck)
   {
      List<Rank> finalRankList = new ArrayList<Rank>(alreadyUsedRanks);
      for (Rank rank : ranksToCheck)
      {
         if (!finalRankList.contains(rank))
            finalRankList.add(rank);
      }

      return finalRankList;
   }

   private Map<Rank, Integer> createRankMap(List<Rank> rankList)
   {
      Map<Rank, Integer> rankMap = new HashMap<Rank, Integer>();
      for (Rank rank : rankList)
      {
         if (rankMap.get(rank) == null)
            rankMap.put(rank, 1);
         else
            rankMap.put(rank, rankMap.get(rank) + 1);
      }
      return rankMap;
   }

}
