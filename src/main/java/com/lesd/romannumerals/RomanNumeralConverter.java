package com.lesd.romannumerals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/13/12
 * Time: 11:40 AM
 */
public class RomanNumeralConverter
{
   private static enum RomanSymbol
   {
      M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);

      private RomanSymbol(int number)
      {
         this.number = number;
      }

      private int number;
   }

   public static String convert(int number)
   {
      StringBuilder romanNumber = new StringBuilder();

      for (RomanSymbol symbol : RomanSymbol.values())
      {
         while (number >= symbol.number)
         {
            romanNumber.append(symbol.toString());
            number -= symbol.number;
         }
      }

      return romanNumber.toString();
   }
}
