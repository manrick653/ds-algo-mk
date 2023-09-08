package org.sample.leetcode.algo;

public class DecodeWays {

  public int numDecodings(String s) {

    return recursive(0, s);
  }

  public int recursive(int index, String s) {
    System.out.println("Call recursive(" + index + ")");
    if (index == s.length()) {
      return 1;
    }
    if (s.charAt(index) == '0') {
      return 0;
    }
    if (index == s.length() - 1) {
      return 1;
    }
    int ans = recursive(index + 1, s);
    if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
      ans += recursive(index + 2, s);
    }

    return ans;
  }

  public double myPow(double x, int n) {

    if (n == 1) {
      return x;
    }
    n-- ;

    return x * myPow(x, n);

  }
}


