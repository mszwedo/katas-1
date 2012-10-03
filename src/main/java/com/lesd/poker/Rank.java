package com.lesd.poker;

public enum Rank
{
   TWO('2'),
   THREE('3'),
   FOUR('4'),
   FIVE('5'),
   SIX('6'),
   SEVEN('7'),
   EIGHT('8'),
   NINE('9'),
   TEN('T'),
   JACK('J'),
   QUEEN('Q'),
   KING('K'),
   ACE('A');

   public static Rank getRankOfChar(char rankCharacter)
   {
      for (Rank rank : values())
      {
         if (rank.getRankChar() == rankCharacter)
         {
            return rank;
         }
      }
      throw new IllegalArgumentException();
   }

   public char getRankChar()
   {
      return rank;
   }

   private Rank(char rank)
   {
      this.rank = rank;
   }

   private char rank;
}
