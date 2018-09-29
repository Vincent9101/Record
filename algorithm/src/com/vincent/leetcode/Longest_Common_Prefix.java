package com.vincent.leetcode;

import static org.hamcrest.CoreMatchers.both;

import org.hamcrest.core.StringStartsWith;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import sun.awt.im.InputMethodJFrame;
import sun.print.resources.serviceui;
import sun.security.util.Length;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//输入: ["flower","flow","flight"]
//输出: "fl"

//示例 2:
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//说明:
//所有输入只包含小写字母 a-z 。
//您是否在真实的面试环节中遇到过这道题目呢？
public class Longest_Common_Prefix {

	public static String longestCommonPrefix(String[] strs) {

		String res = "";
		int count = 0;
		boolean flag = true;
		if (strs.length == 1)
			return strs[0];
		if (strs.length == 0)
			return res;
		int minSubStringlen = strs[0].length();

		for (String s : strs) {
			if (s.length() < minSubStringlen)
				minSubStringlen = s.length();
		}

		while (count + 1 <= minSubStringlen && flag) {

			for (int j = 1; j < strs.length && flag; j++) {
				if (strs[j].charAt(count) != strs[j - 1].charAt(count)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				res += strs[0].charAt(count);
				count++;
			}

			// System.out.println("res: "+res);
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] str = new String[] { "flower", "flow", "flight" };

		System.out.println(longestCommonPrefix(str));

	}

}
