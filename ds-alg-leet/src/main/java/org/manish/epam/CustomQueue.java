package org.manish.epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CustomQueue {

  public List<Character> getCharQueue() {
    return charQueue;
  }

  private List<Character> charQueue ;


  public CustomQueue() {
    this.charQueue = new ArrayList<>();
  }
  // m a n i h

  public void put(Character c){
    charQueue.add(c);
  }
  public Character poll(){
    if(charQueue.isEmpty()){
      return null ;
    }
    Character top = charQueue.get(charQueue.size() -1);
    charQueue.remove(charQueue.size()-1);
    return top ;
  }


  }


