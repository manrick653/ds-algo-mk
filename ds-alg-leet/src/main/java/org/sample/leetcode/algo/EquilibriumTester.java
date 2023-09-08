package org.sample.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

public class EquilibriumTester {

  public static void main(String[] args) {
     //[0, -3, 5, -4, -2, 3, 1, 0]
    Equib equib = new Equib();

    List<Integer> integers = new ArrayList<>();
    integers.add(0);
    integers.add(-3);
    integers.add(5);
    integers.add(-4);
    integers.add(-2);
    integers.add(3);
    integers.add(1);
    integers.add(0);
    List<Integer> indexes = equib.findEquilibrium(integers);
    System.out.println(indexes);
    int [] arr = new int[]{0, -3, 5, -4, -2, 3, 1, 0};
    int[] res = equib.searchRange(arr);

    for (int i = 0; i < res.length ; i++) {

      System.out.println("-"+res[i]);

    }
  }

}
