package com.lesd.poker;

public enum Suit
{
   HEARTS('H'), SPADES('S'), DIAMONDS('D'), CLUBS('C');

   public static Suit getSuitForChar(char c)
   {
      for (Suit suit : values())
      {
         if (suit.getSuitChar() == c)
            return suit;
      }

      throw new RuntimeException("No suit for char");
   }

   public char getSuitChar()
   {
      return suit;
   }

   private Suit(char suit)
   {

      this.suit = suit;
   }

   private char suit;
}
