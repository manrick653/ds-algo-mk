package org.sample.leetcode.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class ThirdLargestIntNumber {
    public int thirdMax(Integer[] nums) {

      Arrays.sort(nums, Collections.reverseOrder());
      int count = 3 ;
      int result = Integer.MAX_VALUE;
      for(int i = 0 ; i < nums.length-1 ; i ++) {
        if (count == 1) {
          result = nums[i];
          break ;
        }
        if (!Objects.equals(nums[i], nums[i + 1])) {
          count--;
        }

      }
      return result ;
    }
}
