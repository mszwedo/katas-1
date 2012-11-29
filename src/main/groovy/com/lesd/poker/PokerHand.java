package com.lesd.poker;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/18/12
 * Time: 11:59 AM
 */
public class PokerHand
{
   private List<Card> cards;

   public PokerHand(List<Card> cards)
   {
      this.cards = cards;
   }

   public List<Card> getCards()
   {
      return cards;
   }
}
