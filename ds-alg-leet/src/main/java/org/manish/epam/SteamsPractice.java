package org.manish.epam;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SteamsPractice {

  //1 . given a string find the word and its count
  //
  public static void main(String[] args) {
     String givenString = "manish kumar is good boy, manish kumar manish kumar 123";
    Function<String,String> keyMapper = e -> {if(e.charAt(e.length()-1)==','){
      return e.subSequence(0,e.length()-1).toString();
    }else{
      return e ;
    }
    };
    Function<String,Integer> valueMapper = e -> 1;

    Map<String,Integer> keyToCount = Arrays.stream(givenString.split(" ")).
        collect(Collectors.toMap(keyMapper,valueMapper, Integer::sum)) ;
    Map<String,Integer> filteredKeyToCount = keyToCount.entrySet().stream().filter(e -> e.getValue()>=3).collect(
        Collectors.toMap(Entry::getKey, Entry::getValue));

    System.out.println(keyToCount);
    System.out.println(filteredKeyToCount);


  }
  // String givenString = "manish kumar is  good boy, but manish is also bad boy";


}
