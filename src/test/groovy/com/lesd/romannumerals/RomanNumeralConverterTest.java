package com.lesd.romannumerals;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: apane
 * Date: 9/13/12
 * Time: 11:40 AM
 */
public class RomanNumeralConverterTest
{

   @Test
   public void test1()
   {
      Assert.assertEquals("I", RomanNumeralConverter.convert(1));
   }

   @Test
   public void test2()
   {
      assertEquals("II", RomanNumeralConverter.convert(2));
   }

   @Test
   public void test3()
   {
      assertEquals("III", RomanNumeralConverter.convert((3)));
   }

   @Test
   public void test4()
   {
      assertEquals("IV", RomanNumeralConverter.convert(4));
   }

   @Test
   public void test5()
   {
      assertEquals("V", RomanNumeralConverter.convert(5));
   }

   @Test
   public void test6()
   {
      assertEquals("VI", RomanNumeralConverter.convert(6));
   }

   @Test
   public void test7()
   {
      assertEquals("VII", RomanNumeralConverter.convert(7));
   }

   @Test
   public void test9()
   {
      assertEquals("IX", RomanNumeralConverter.convert(9));
   }

   @Test
   public void test10()
   {
      assertEquals("X", RomanNumeralConverter.convert(10));
   }

   @Test
   public void testMultiple()
   {
      assertEquals("CVIII", RomanNumeralConverter.convert(108));
      assertEquals("CCVIII", RomanNumeralConverter.convert(208));
      assertEquals("DCCVIII", RomanNumeralConverter.convert(708));
      assertEquals("MDCCVIII", RomanNumeralConverter.convert(1708));
   }
}

