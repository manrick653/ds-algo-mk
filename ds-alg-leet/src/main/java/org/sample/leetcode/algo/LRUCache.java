package org.sample.leetcode.algo;

import java.security.Key;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
  private Map<Integer,Integer> cache ;
  private int max_capacity ;
  private Deque<Integer> deque ;

  public LRUCache(int capacity) {
    max_capacity = capacity ;
    cache = new HashMap<>(capacity);
    deque = new ArrayDeque<>();
  }

  public int get(int key) {
     deque.removeFirstOccurrence(key);
     deque.addFirst(key);
    return cache.getOrDefault(key, -1);
  }



  public void put(int key, int value) {


    if(cache.size() > max_capacity){
      Integer removedKey = deque.removeLast();
      cache.remove(removedKey);
    }
    cache.put(key,value);
    deque.removeFirstOccurrence(key);
    deque.addFirst(key);

  }

}
