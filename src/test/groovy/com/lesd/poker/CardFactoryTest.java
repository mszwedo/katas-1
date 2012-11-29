package com.lesd.poker;

import junit.framework.Assert;
import org.junit.Test;

public class CardFactoryTest
{
   public CardFactoryTest()
   {
   }

   @Test
   public void testCreateCard()
   {
      Card card = CardFactory.createCard("2H");
      Assert.assertEquals(card.getRank(), Rank.TWO);
      Assert.assertEquals(card.getSuit(), Suit.HEARTS);

      card = CardFactory.createCard("3H");
      Assert.assertEquals(card.getRank(), Rank.THREE);
      Assert.assertEquals(card.getSuit(), Suit.HEARTS);

      card = CardFactory.createCard("KD");
      Assert.assertEquals(card.getRank(), Rank.KING);
      Assert.assertEquals(card.getSuit(), Suit.DIAMONDS);
   }
}