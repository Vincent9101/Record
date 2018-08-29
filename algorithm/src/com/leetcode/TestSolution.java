package com.leetcode;

import org.junit.Test;

public class TestSolution {

	@Test
	public void test_palindrome() {

		System.out.println(isPalindrome(121));
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
