package com.maybetm.inn.parser;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author zebzeev-sv
 * @version 30.06.2020 18:31
 */

public class ParserImplTest
{

  private final static ParserImpl parser = new ParserImpl();

  private final static String source1 =
    "    _  _     _  _  _  _  _  _ \n" +
    "  | _| _||_||_ |_   ||_||_|| |\n" +
    "  ||_  _|  | _||_|  ||_| _||_|\n";

  private final static String source2 =
    " _  _  _  _  _  _  _  _  _ \n" +
    "| | _| _|| ||_ |_   ||_||_|\n" +
    "|_||_  _||_| _||_|  ||_| _|\n";


  private final static String source3 =
    " _  _  _  _  _  _  _  _  _ \n" +
    "|_| _| _||_||_ |_ |_||_||_|\n" +
    "|_||_  _||_| _||_| _||_| _|\n";

  @Test
  public void parseSource1()
  {
    Assert.assertEquals(parser.parse(source1), "1234567890");
  }

  @Test
  public void parseSource2()
  {
    Assert.assertEquals(parser.parse(source2), "23056789");
  }

  @Test
  public void parseSource3()
  {
    Assert.assertEquals(parser.parse(source3), "823856989");
  }
}
