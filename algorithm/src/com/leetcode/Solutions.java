package com.leetcode;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author Vincent LeetCode 试题代码
 *
 */
public class Solutions {

	@Test
	public void test() {
		String s = "barfoothefoobarman";
		String[] words = new String[] { "foo", "bar" };
		findSubstring(s, words);
	}

	/*
	 * <h1>30. 与所有单词相关联的字串</h1> 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words
	 * 中所有单词的子串的起始位置。 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
	 * 
	 * 
	 * 示例 1:
	 * 
	 * 输入: s = "barfoothefoobarman", words = ["foo","bar"] 输出: [0,9] 解释: 从索引 0 和 9
	 * 开始的子串分别是 "barfoor" 和 "foobar" 。 输出的顺序不重要, [9,0] 也是有效答案。
	 */
	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> substringPosition = new ArrayList<Integer>();

		for (int i = 0; i < words.length-1; i++) {
			String temp = words[i];
			String temp2=words[i+1];
			for (int j = 0; j < s.length() - temp.length(); j++) {
				if (s.substring(j, j + temp.length()).equals(temp)) {
					System.out.println(s.substring(j, j + temp.length()));
					substringPosition.add(j);
				}

			}
		}

		return substringPosition;

	}

}
