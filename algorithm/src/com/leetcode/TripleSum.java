package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TripleSum {
	/*
	 * 给定一个包含 n 个整数的数组 S，是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？
	 * 
	 * 找出所有不重复的三个元素组合使三个数的和为零。
	 * 
	 * 注意：结果不能包括重复的三个数的组合。
	 * 
	 * 例如, 给定数组 S = [-1, 0, 1, 2, -1, -4]，
	 * 
	 * 一个结果集合为： [ [-1, 0, 1], [-1, -1, 2] ]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = new TripleSum().threeSum(nums);
		System.out.println(res);

	}

	public  List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = null;
		// int H, L, mid,sum;
		int a = 0, right, left, sum;
		Arrays.sort(nums);
//		for (int x : nums)
//			System.out.println(x);
		for (int i = 0; i < nums.length && a < nums.length - 2; i++) {
			a = i;
			right = nums.length - 1;
			left = i + 1;

			sum = nums[a] + nums[right] + nums[left];

			while (right > left) {

				if (nums[a] == nums[a + 1])
					a++;

				if (sum == 0) {
					temp = new ArrayList<Integer>();
					temp.add((Integer) nums[a]);
					temp.add((Integer) nums[left]);
					temp.add((Integer) nums[right]);
					res.add(temp);
					right--;
					left++;
				} else if (sum < 0) {
					left++;
				} else
					right--;

				if (left-1>1&&nums[left - 1] == nums[left] )
					left++;
				if (right +1< nums.length && nums[right + 1] == nums[right])
					right--;

			}
		}

		// for (int i = 0; i < nums.length - 2; i++)
		// {
		//
		// for (int j = i + 1; j < nums.length - 1; j++)
		// {
		//
		// L = j+1;
		// H= nums.length-1;
		//
		// while(L<=H)
		// {
		// mid=(L+H)/2;
		// sum=nums[i]+nums[j]+nums[mid];
		//
		//
		// if(sum==0)
		// {
		// temp=new ArrayList<Integer>();
		// temp.add((Integer)nums[i]);
		// temp.add((Integer)nums[j]);
		// temp.add((Integer)nums[mid]);
		//
		//
		// if( res.size()==0||(!res.contains(temp)))
		// {
		// res.add(temp);
		//
		// }
		// break;
		//
		// }
		// else if(sum>0)
		// {
		// H=mid-1;
		// }
		// else
		// L=mid+1;
		//
		//
		//
		// }
		// System.out.println("完成一次\n");

		// for(int m=j+1;m<nums.length;m++)
		// {
		//
		// if(nums[i]+nums[j]+nums[m]==0)
		// {
		//
		// temp=new ArrayList<Integer>();
		// temp.add((Integer)nums[i]);
		// temp.add((Integer)nums[j]);
		// temp.add((Integer)nums[m]);
		// if(!res.contains(temp))
		// {
		// res.add(temp);
		// break;
		// }
		// }
		//
		//
		// }
		// }
		// }

		return res;
	}

}
