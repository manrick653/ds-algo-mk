package org.sample.leetcode.algo;

import org.junit.jupiter.api.Test;

public class DecodeWaysTest {

  @Test
  void whenDecodeWaysCountTest(){
    DecodeWays decodeWays = new DecodeWays();
    int ans  = decodeWays.numDecodings("06");
    System.out.println(ans);
  }
  @Test
  void whenDecodeWaysRecursivePower(){
    DecodeWays decodeWays = new DecodeWays();
    double ans  = decodeWays.myPow(2,10);
    System.out.println(ans);
  }

}
