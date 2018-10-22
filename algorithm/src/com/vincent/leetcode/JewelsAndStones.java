package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

import sun.tools.jar.resources.jar;

public class JewelsAndStones {

	public static void mian(String[] args) {

	}

	public static int numJewelsInStonesVersion2(String J, String S) {

		char[] temp = S.toCharArray();
		int sum = 0;
		for (char c : temp) {
			if (J.indexOf(c) >= 0) {
				sum++;
			}
		}
		return sum;
	}

	public static int numJewelsInStones(String J, String S) {

		int sum = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < J.length(); i++) {
			map.put(J.charAt(i), i);

		}
		for (int j = 0; j < S.length(); j++) {
			if (map.get(S.charAt(j)) != null) {
				sum++;
			}
		}
		return sum;
	}

}
