package com.lesd.primefactors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static com.lesd.primefactors.PrimeFactors.generate;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 12/8/11
 * Time: 2:45 PM
 */
public class PrimeFactorsTest
{
   private List<Integer> list(int...ints)
   {
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (int i : ints)
         list.add(i);
      return list;
   }

   @Test
   public void testOne()
   {
      assertEquals(list(), generate(1));
   }

   @Test
   public void testTwo()
   {
      assertEquals(list(2), generate(2));
   }

   @Test
   public void testThree()
   {
      assertEquals(list(3), generate(3));
   }

   @Test
   public void testFour()
   {
      assertEquals(list(2,2), generate(4));
   }

   @Test
   public void testSix()
   {
      assertEquals(list(2,3), generate(6));
   }

   @Test
   public void testEight()
   {
      assertEquals(list(2,2,2), generate(8));
   }

   @Test
   public void testNine()
   {
      assertEquals(list(3,3), generate(9));
   }
}
