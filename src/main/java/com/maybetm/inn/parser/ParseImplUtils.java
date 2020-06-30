package com.maybetm.inn.parser;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zebzeev-sv
 * @version 30.06.2020 18:40
 */
public class ParseImplUtils
{

  public static int[] getEndIndexes(char[] sourceChar)
  {
    int[] indexes = new int[3];

    int inc = 0;
    for (int i = 0; i <= sourceChar.length - 1; i++)
      if (sourceChar[i] == '\n')
        indexes[inc++] = i;

    return indexes;
  }

  public static List<String> getNumbers(char[] firstLine, char[] secondLine, char[] threeLine)
  {
    List<String> numbers = new ArrayList<>();

    int startIdx = 0;
    int endIdx = 3;
    for (int i = 3; i <= firstLine.length; i += 3) {
      String result = String.format("%s%s%s",
                                    String.valueOf(Arrays.copyOfRange(firstLine, startIdx, endIdx)),
                                    String.valueOf(Arrays.copyOfRange(secondLine, startIdx, endIdx)),
                                    String.valueOf(Arrays.copyOfRange(threeLine, startIdx, endIdx)));
      numbers.add(result);

      startIdx += 3;
      endIdx = startIdx + 3;
    }

    return numbers;
  }
}
