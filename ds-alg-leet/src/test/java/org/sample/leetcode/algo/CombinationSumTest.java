package org.sample.leetcode.algo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CombinationSumTest {

  @Test
   void combinationSumTest(){
    int[] candidates = {2, 3, 6, 7};
    int target = 7;
    CombinationSum combinationSum = new CombinationSum();
    List<List<Integer>> combinations = combinationSum.combinationSum(candidates, target);

    // Printing the combinations
    for (List<Integer> combination : combinations) {
      System.out.println(combination);
    }
  }

}