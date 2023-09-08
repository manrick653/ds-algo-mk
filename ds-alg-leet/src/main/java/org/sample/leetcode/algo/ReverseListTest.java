package org.sample.leetcode.algo;

public class ReverseListTest {

  public static void main(String[] args) {

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    one.next = two ;
    ListNode three = new ListNode(3);
    two.next = three;
    ListNode four = new ListNode(4);
    three.next = four;
    ListNode five = new ListNode(5);
    four.next = five;

    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    ListNode head = reverseLinkedList.reverseList(one);



  }

}
