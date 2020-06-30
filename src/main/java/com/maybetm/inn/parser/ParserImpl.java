package com.maybetm.inn.parser;

import com.maybetm.inn.parser.common.ECustomNumber;
import com.maybetm.inn.parser.common.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zebzeev-sv
 * @version 30.06.2020 18:29
 */
public class ParserImpl implements Parser
{

  public String parse(String source)
  {
    char[] sourceChar = source.toCharArray();
    int[] endIdxes = ParseImplUtils.getEndIndexes(sourceChar);

    char[] firstLine = Arrays.copyOfRange(sourceChar, 0, endIdxes[0]);
    char[] secondLine = Arrays.copyOfRange(sourceChar, ++endIdxes[0], endIdxes[1]);
    char[] threeLine = Arrays.copyOfRange(sourceChar, ++endIdxes[1], endIdxes[2]);

    List<String> numbers = ParseImplUtils.getNumbers(firstLine, secondLine, threeLine);

    ECustomNumber stringNumber = ECustomNumber.of(numbers.get(0));
    if (stringNumber != null && stringNumber.num == 0)
      numbers.remove(0);

    return numbers.parallelStream()
      .map(ECustomNumber::of)
      .map(e -> e != null ? String.valueOf(e.num) : "")
      .collect(Collectors.joining());
  }

}
