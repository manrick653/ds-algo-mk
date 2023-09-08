package org.sample.leetcode.algo;

import org.junit.jupiter.api.Test;

public class LRUCacheTest {
@Test

  public void lruTest(){
  //["LRUCache","put","put","put","put","get","get"]
   // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]


  LRUCache lRUCache = new LRUCache(2);
  lRUCache.put(2, 1); // cache is {1=1}
  lRUCache.put(1, 1); // cache is {1=1, 2=2}
  lRUCache.put(2,3);    // return 1
  lRUCache.put(4, 1); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
  lRUCache.get(1);    // returns -1 (not found)
  lRUCache.get(2);    // return -1 (not found)
  System.out.println(lRUCache.get(1)+"  "+ lRUCache.get(2));

}

@Test
  public void lru2Test(){
    //["LRUCache","put","put","put","put","get","get"]
    // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]



    LRUCache lRUCache = new LRUCache(2);
    lRUCache.get(2); // cache is {1=1}
    lRUCache.put(2, 6); // cache is {1=1, 2=2}
    lRUCache.get(1);
    lRUCache.put(1,5);    // return 1
    lRUCache.put(1, 2); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(1);    // returns -1 (not found)
    lRUCache.get(2);    // return -1 (not found)
    System.out.println(lRUCache.get(1)+"  "+ lRUCache.get(2));

  }
}
