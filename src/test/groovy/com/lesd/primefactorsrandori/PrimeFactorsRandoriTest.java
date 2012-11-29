package com.lesd.primefactorsrandori;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 8/28/12
 * Time: 12:43 PM
 */
public class PrimeFactorsRandoriTest
{
   @Test
   public void testOne()
   {
      Assert.assertEquals(list(), PrimeFactorsRandori.generate(1));
   }

   @Test
   public void testTwo()
   {
      assertEquals(list(2), PrimeFactorsRandori.generate(2));
   }

   @Test
   public void testThree()
   {
      assertEquals(list(3), PrimeFactorsRandori.generate(3));
   }

   @Test
   public void testFour()
   {
      assertEquals(list(2,2), PrimeFactorsRandori.generate(4));
   }

   private List<Integer> list(int... args)
   {
      ArrayList<Integer> primes = new ArrayList<Integer>();
      for (int prime : args)
         primes.add(prime);
      return primes;
   }
}
