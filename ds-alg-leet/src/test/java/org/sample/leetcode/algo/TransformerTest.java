package org.sample.leetcode.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TransformerTest {

  @Test
  void whenInputsHasZeros() {

    //nput - {2,0,5,0,3,9,0,1,2}
   // Output - {0,0,0,2,5,3,9,1,2}

    List<Integer> inputs = List.of(2,0,5,0,3,9,0,1,2);
    List<Integer> op = transformList(inputs);
    System.out.println("ops are "+op);
  }

  public List<Integer> transformList(List<Integer> inputs){


    Deque<Integer> deque = new ArrayDeque<>();

    for(Integer i : inputs){

      if(i == 0){
        deque.addFirst(i);
      }else{
        deque.add(i);
      }

    }
// could in separate method
    List<Integer> op = new ArrayList<>();

    while(!deque.isEmpty()){
      op.add(deque.poll());
    }

    return op ;
  }

}


