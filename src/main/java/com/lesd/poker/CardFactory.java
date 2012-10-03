package com.lesd.poker;

public class CardFactory
{
   public static Card createCard(String s)
   {
      char rankCharacter = s.charAt(0);
      char suitCharacter = s.charAt(1);

      return new Card(Rank.getRankOfChar(rankCharacter), Suit.getSuitForChar(suitCharacter));

   }
}