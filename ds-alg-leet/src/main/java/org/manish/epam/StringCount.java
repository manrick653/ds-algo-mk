package org.manish.epam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCount {

  public static void main(String[] args) {
    //string m a n i n i * * s h h *

    String givenString = "m a n i n i * * s h h *";
    CustomQueue customQueue = new CustomQueue();
    char[] chars = givenString.toCharArray();
    for (char c : chars) {
      if (c == '*') {
        customQueue.poll();
      } else {
        customQueue.put(c); // manish
      }

    }
    List<Character> finalString = customQueue.getCharQueue();
    System.out.println("final string " + finalString);

  }
}
