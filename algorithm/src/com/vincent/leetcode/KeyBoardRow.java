package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.asList(findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" })));

	}

	public static String[] findWords(String[] words) {

		String[] keys = new String[] { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < keys.length; i++) {
			for (Character character : keys[i].toCharArray()) {
				map.put(character, i + 1);
				// 注意大写字母
				map.put((char) (character.charValue() + 'A' - 'a'), i + 1);
			}
		}

		List<String> res = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			boolean flag = true;
			for (int j = 1; j < words[i].length(); j++) {
				if (!map.get(words[i].charAt(j)).equals(map.get(words[i].charAt(j - 1)))) {
					flag = false;
					break;
				}
			}

			if (flag) {
				res.add(words[i]);
			}
		}

		String[] arr = new String[res.size()];
		res.toArray(arr);
		return arr;
	}

}
