package com.lesd.romannumerals.fixtures;

import com.lesd.romannumerals.RomanNumeralConverter;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/24/12
 * Time: 9:57 AM
 */
public class RomanNumeralConverterFixture
{
   private int number;

   public void setNumber(int number)
   {
      this.number = number;
   }

   public String symbols()
   {
      return RomanNumeralConverter.convert(number);
   }
}
