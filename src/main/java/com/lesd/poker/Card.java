package com.lesd.poker;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/18/12
 * Time: 12:26 PM
 */
public class Card
{
   Rank rank;
   Suit suit;

   public Card(Rank rank, Suit suit)
   {
      this.rank = rank;
      this.suit = suit;
   }

   public Rank getRank()
   {
      return rank;
   }

   public Suit getSuit()
   {
      return suit;
   }
}
