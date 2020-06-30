package com.maybetm.inn.parser.common;

import java.util.EnumSet;

/**
 * @author zebzeev-sv
 * @version 30.06.2020 18:35
 */
public enum ECustomNumber
{
  zero(0, " _ " +
                       "| |" +
                       "|_|"),

  one(1, "   " +
                      "  |" +
                      "  |"),

  two(2, " _ " +
                      " _|" +
                      "|_ "),

  three(3, " _ " +
                        " _|" +
                        " _|"),

  four(4,  "   " +
                        "|_|" +
                        "  |"),

  five(5, " _ " +
                       "|_ " +
                       " _|"),

  six(6, " _ "+
                      "|_ "+
                      "|_|"),

  seven(7, " _ " +
                        "  |" +
                        "  |"),

  eight(8, " _ " +
                        "|_|" +
                        "|_|"),

  nine(9, " _ " +
                       "|_|" +
                       " _|");

  public final int num;
  public final String source;

  ECustomNumber(int num, String source)
  {
    this.num = num;
    this.source = source;
  }

  public static ECustomNumber of(String source)
  {
    return EnumSet
      .allOf(ECustomNumber.class)
      .stream()
      .filter(s -> source.equals(s.source))
      .findFirst()
      .orElse(null);
  }
}
