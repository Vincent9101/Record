package com.leetcode;

public class SumTwo {
	/*
	 * ����һ���������У��ҳ����к�Ϊ�ض�ֵ������������
	 * ����Լ���ÿ�����붼ֻ����һ�ִ𰸣�
	 * ͬ����Ԫ�ز��ܱ����á�
	 * ʾ��:
	 * ���� nums = [2, 7, 11, 15], target = 9
	 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
	 * ���Է��� [0, 1]
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
