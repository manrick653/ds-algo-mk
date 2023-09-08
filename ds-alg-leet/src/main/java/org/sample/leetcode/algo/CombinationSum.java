package org.sample.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public  List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates); // Sort the candidates to ensure non-decreasing order

    backtrack(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  private  void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
    if (remain < 0) {
      return;
    } else if (remain == 0) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int i = start; i < candidates.length; i++) {
        tempList.add(candidates[i]);
        // We allow reusing the same candidate, so we recursively call backtrack with the same start index.
        backtrack(result, tempList, candidates, remain - candidates[i], i);
        tempList.remove(tempList.size() - 1); // Backtrack by removing the last element to try other combinations.
      }
    }
  }

}