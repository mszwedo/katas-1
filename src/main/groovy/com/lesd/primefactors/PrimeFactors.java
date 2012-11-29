package com.lesd.primefactors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 12/8/11
 * Time: 2:47 PM
 */
public class PrimeFactors
{
   public static List<Integer> generate(int n)
   {
      ArrayList<Integer> primes = new ArrayList<Integer>();

      for (int candidate = 2; n > 1; candidate++)
         for(; n % candidate == 0; n /= candidate)
            primes.add(candidate);

      return primes;
   }
}
