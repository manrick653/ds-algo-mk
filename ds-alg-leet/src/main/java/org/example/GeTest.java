package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GeTest {

  public static void main(String[] args) {

    // 101110110101
    //String input = "101110110101";
    String input = "10001100101011";

//    char[] chars = input.toCharArray();
//    int max = Integer.MIN_VALUE;
//    int count = 0 ;
//   for(int i= 0 ; i < input.length();i++){
//
//     if(chars[i] == '1'){
//       count ++ ;
//       max = Math.max(max,count);
//
//     }else{
//       count = 0 ;
//
//     }
//
//   }
   String[] stringBySplit = input.split("0");
    String maxLength =Arrays.stream(stringBySplit).collect(Collectors.maxBy((e1,e2)->e1.length()-e2.length())).get();



   //java 8

    System.out.println("max count::::>"+maxLength.length());

    //System.out.println("max count"+max);

  }



}
