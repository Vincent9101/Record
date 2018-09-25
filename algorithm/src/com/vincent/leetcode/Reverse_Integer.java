package com.vincent.leetcode;

import java.util.Scanner;

/**
 * 
 * @author Vincent 给定一个 32 位有符号整数，将整数中的数字进行反转。 示例 1: 输入: 123 输出: 321 示例 2:
 *         输入:-123 输出: -321 示例 3: 输入: 120 输出: 21 注意: 假设我们的环境只能存储
 *         32位有符号整数，其数值范围是[−2^31, 2^31-1]。 根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 */
public class Reverse_Integer {

	public static void main(String args[]) {

		Scanner scaner = new Scanner(System.in);
		int param;
		while ((param = scaner.nextInt()) != -1) {
			System.out.println(reverse(param));
		}
	}

	/*
	 * 这个题目没什么难度 值得小心的就是 判断是否溢出的时候应该在sum进行加操作进行处理
	 */
	public static int reverse(int x) {
		int sum = 0;
		while (x != 0) {
			int temp = x % 10;
			if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
				return 0;
			sum = sum * 10 + temp;

			x = x / 10;
		}
		return sum;
	}

}
