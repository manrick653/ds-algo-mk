package org.manish.epam;


public class Main {
  public static void main(String[] args) {
    String ex1 = "aabbaa";  //true
    String ex2 = "aabdaa";  //false
    String ex3 = "aabcbaa"; //true

    // System.out.println("ex1: "+ isPalindrome(ex1));
    System.out.println("ex2: "+ isPalindrome(ex2));
    // System.out.println("ex3: "+ isPalindrome(ex3));

  }

  public static boolean isPalindrome(String word){


    char[] chars = word.toCharArray();

    int left = 0 ;
    int right = word.length()-1 ;
    System.out.println("chars[left]: "+ chars[left]);
    while(left <= right){
     // System.out.println("chars[left]: "+ chars[left]);
     // System.out.println("chars[right]: "+ chars[right]);

      if(chars[left] != chars[right]){
        //System.out.println("chars[left]: "+ chars[left]);
        // System.out.println("chars[right]: "+ chars[right]);

        return false ;
      }
      left ++ ;
      right -- ;
    }
    return true ;



  }


}
