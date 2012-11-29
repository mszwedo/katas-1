package com.lesd.bowlinggame;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/6/12
 * Time: 12:08 PM
 */
public class BowlingGameTest
{
   @Test
   public void allGutters()
   {
      BowlingGame game = new BowlingGame();
      rollMany(game, 0, 20);
      assertEquals(0, game.score());
   }
   @Test
   public void allOnes()
   {
      BowlingGame game = new BowlingGame();
      rollMany(game, 1, 20);
      assertEquals(20, game.score());
   }

   @Test
   public void oneSpare()
   {
      BowlingGame game = new BowlingGame();
      game.roll(5);
      game.roll(5);
      game.roll(5);
      rollMany(game, 0, 17);
      assertEquals(20, game.score());

   }

   private BowlingGame rollMany(BowlingGame game, int scoreEachRoll, int numOfRolls)
   {
      for (int i = 0; i < numOfRolls; i++)
      {
         game.roll(scoreEachRoll);
      }
      return game;
   }
}
