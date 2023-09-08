package org.sample.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

public class FormatLicesnsePlate {

  public String licenseKeyFormatting(String s, int k) {

    String withoutDash = s.replaceAll("-","");
    List<Character> reverseString = reverseString(withoutDash.toCharArray());
    int len = reverseString.size() ;
    int ex = (len/k - 1 )+(len%k);
    int index = 0 ;

    while( index < (reverseString.size()+ex -1)){

      if(index > 0 && (index %k  == 0)){

        reverseString.add(index++,'-');
      }else{
       index ++ ;
      }

    }
    return reverseString.toString();



  }

  private  List<Character> reverseString(char[] withoutDash) {
   List<Character> characterList = new ArrayList<>();
    int j = 0 ;
    for(int i = withoutDash.length-1 ; i >=0 ; i --){
      characterList.add(withoutDash[i]);

    }
    return characterList ;
  }

}
