package com.lesd.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HandFactory
{

   public static PokerHand createHand(String s)
   {
      List<Card> cards;
      cards = new ArrayList<Card>();
      StringTokenizer st = new StringTokenizer(s, " "); // s = "2H 3D 5S 9C KD"
      while (st.hasMoreTokens())
      {
         cards.add(CardFactory.createCard(st.nextToken()));
      }

      return new PokerHand(cards);
   }
}