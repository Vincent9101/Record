package com.leetcode;

import org.junit.Test;

public class TestSolution {

	@Test
	public void test_palindrome() {

		System.out.println(isPalindrome(121));
	}

	  public  int[] twoSum(int[] nums, int target) {
		  int[] res=new int [2];
		  int index=0;
		  boolean flag=false;
          for(int i=0;i<nums.length-1;i++)
          {
        	  if(flag)break;
        	  for(int j=i+1;j<nums.length;j++)
        	  {
        		 if(nums[i]+nums[j]==target)
        		 {
        		    res[index++]=i;
        		    res[index++]=j;
        		    flag=true;
        		    break;
        		 }
        	  }
        	  
          }
          return res;
  }
	public boolean isPalindrome(int x) {
		char[] temp = String.valueOf(x).toCharArray();
		char[] reverse = new char[temp.length];
		for (int i = 0, j = temp.length - 1; i < temp.length; i++, j--) {
			reverse[j] = temp[i];
		}
		boolean flag = false;
		if (new String(temp).equals(new String(reverse)))
			flag = true;
		return flag;
	}
}
