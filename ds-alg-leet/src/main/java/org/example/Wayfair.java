package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wayfair {

  public static void main(String[] args) {
    //data = {1,2,3,4,5,10,9,8,7,6}

    // out - 54321678910

    List<Integer> inputs = Arrays.asList(1, 2, 4, 5, 10, 5, 9, 8, 3, 7, 6);

    System.out.println(duplicateEntry(inputs));

  }

  public static Integer duplicateEntry(List<Integer> inputs) {
    Map<Integer, Integer> intCount = new HashMap<>();

    for (Integer i : inputs) {
      if (intCount.containsKey(i)) {
        return i;
      } else {
        intCount.put(i, 1);
      }
    }
    return -1;

  }
}
