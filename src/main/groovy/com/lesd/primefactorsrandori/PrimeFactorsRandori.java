package com.lesd.primefactorsrandori;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 8/28/12
 * Time: 12:47 PM
 */
public class PrimeFactorsRandori
{
   public static List<Integer> generate(int number)
   {

      List<Integer> primes = new ArrayList<Integer>();

      if (number > 1)
      {
         if (number % 2 == 0)
         {
            primes.add(2);
            number = number / 2;
         }

         if (number > 1)
            primes.add(number);

      }

      return primes;

   }
}
