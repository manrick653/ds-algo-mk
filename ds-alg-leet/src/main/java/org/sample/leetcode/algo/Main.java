package org.sample.leetcode.algo;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

//    numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
//    TreeNode five = new TreeNode(null,null,5);
//    TreeNode four = new TreeNode(null,five,4);
//    TreeNode three = new TreeNode(null,null,3);
//    TreeNode two = new TreeNode(null,three,2);
//    TreeNode six = new TreeNode(two,null,6);
//    TreeNode seven = new TreeNode(six,null,7);
//
//    Solution solution = new Solution();
//    TreeNode sol = solution.inorderSuccessor(seven,three);
//    System.out.println(sol.val);

    Solution3 exercise = new Solution3();

    // when
    List<Integer> result = exercise.findDuplicates(asList(-1, 1, 3, 2, 5, 6, -1, 3, 6), 2);
  }
  public static int numUniqueEmails(String[] emails) {

    Set<String> receivers = new HashSet<>();
    for(String email : emails){

      String localname = email.split("@")[0];
      String domainName = email.split("@")[1];
      String dotRemoved = localname.replace(".","");
      int index = dotRemoved.indexOf("+");
      String  plusRemoved = dotRemoved.substring(0,index);
      String sanitizedEmail =  plusRemoved +"@"+ domainName ;
      receivers.add(sanitizedEmail);
    }
    return receivers.size();

  }

}