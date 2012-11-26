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

   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Card card = (Card) o;

      if (rank != card.rank) return false;
      if (suit != card.suit) return false;

      return true;
   }

   @Override
   public int hashCode()
   {
      int result = rank.hashCode();
      result = 31 * result + suit.hashCode();
      return result;
   }
}
