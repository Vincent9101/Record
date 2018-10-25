package com.vincent.leetcode;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
	}

	public static int missingNumberVersion2(int[] nums) {

		int sum = (nums.length + 1) * nums.length / 2;

		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}

		return sum;
	}

	public static int missingNumber(int[] nums) {

		int[] temp = new int[nums.length + 1];
		Arrays.fill(temp, -1);
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			temp[nums[i]] = nums[i];
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == -1) {
				index = i;
				break;
			}
		}

		return index;
	}

}