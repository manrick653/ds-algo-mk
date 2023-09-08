package org.sample.leetcode.algo;
//Find the equilibrium index of an array. The sum of elements to the left & right of the index should be the same.
//
//    [0, -3, 5, -4, -2, 3, 1, 0]
//0
// [0, -3, 5, -4, -2, 3, -3, 0]


import java.util.ArrayList;
import java.util.List;

public class Equib {


  List<Integer> findEquilibrium(List<Integer> integerList)
  {

    List<Integer> eqIndexs = new ArrayList<>();
    for(int i = 0 ; i < integerList.size() ; i++){
      int leftSum = 0 ;
      int rightSum = 0 ;
      for(int j = i-1 ; j >= 0 ; j --){

         leftSum = leftSum + integerList.get(j);

      }
      for(int z = i+1 ; z < integerList.size() ; z ++){

        rightSum = rightSum + integerList.get(z);

      }
      if(leftSum == rightSum){
        eqIndexs.add(i) ;
      }


    }


    return eqIndexs;
  }

  //{0, -3, 5, -4, -2, 3, 1, 0}
    public int[] searchRange(int[] nums) {

      int totalSum = 0 ;
      int [] res = new int[nums.length];
      int z = 0 ;
      for(int i = 0 ; i < nums.length ; i ++){

        totalSum += nums[i];
      }

      int leftSum = 0 ;
      int rightSum = totalSum ;
      for(int j = 0 ; j < nums.length ;  j++){

        int ele = nums[j];
        rightSum = rightSum - ele;
        if(leftSum == rightSum){
          res[z++] = j ;

        }
        leftSum = leftSum + ele ;
      }
      return res ;

    }



}
