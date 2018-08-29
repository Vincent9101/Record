package com.leetcode;

public class SumTwo {
	/*
	 * 给定一个整数数列，找出其中和为特定值的那两个数。
	 * 你可以假设每个输入都只会有一种答案，
	 * 同样的元素不能被重用。
	 * 示例:
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 所以返回 [0, 1]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int [] {2, 7, 11, 15} ;
		int target = 17;
		for(int x : twoSum(nums,target))
			
			System.out.print(x+" ");
	}
	  public static int[] twoSum(int[] nums, int target) {
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

}
