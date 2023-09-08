package org.sample.leetcode.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThirdLargestIntNumberTest {

  @Test
  void thirdLargestNumber(){
    ThirdLargestIntNumber thirdLargestIntNumber = new ThirdLargestIntNumber();
    Integer[] inps = new Integer[]{1,4,6,8,9,3,6,7,3,2,2,3,2,9};
    System.out.println(thirdLargestIntNumber.thirdMax(inps));
  }

}