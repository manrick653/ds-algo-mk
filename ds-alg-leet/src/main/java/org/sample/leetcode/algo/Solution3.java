package org.sample.leetcode.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

  public List<Integer> findDuplicates(List<Integer> integers, int numberOfDuplicates) {
    List<Integer> output = new ArrayList<>();
    Map<Integer, Integer> eleToCount = new HashMap<>();

    for (int i = 0; i < integers.size(); i++) {
      if (integers.get(i) == null) {
        continue;
      }
      if (!eleToCount.containsKey(integers.get(i))) {
        eleToCount.put(integers.get(i), 1);
      } else {
        eleToCount.put(integers.get(i), eleToCount.get(integers.get(i)) + 1);
      }
    }
    for (Integer key : eleToCount.keySet()) {
         if(eleToCount.get(key) == numberOfDuplicates){
           output.add(key);
         }
    }
    return output;

  }
}
