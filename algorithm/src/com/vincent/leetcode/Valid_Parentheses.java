package com.vincent.leetcode;

import java.util.Stack;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import javafx.beans.binding.BooleanBinding;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//
//示例 1:
//
//输入: "()"
//输出: true
//示例 2:
//
//输入: "()[]{}"
//输出: true
//示例 3:
//
//输入: "(]"
//输出: false
//示例 4:
//
//输入: "([)]"
//输出: false
//示例 5:
//
//输入: "{[]}"
//输出: true
public class Valid_Parentheses {
	
	//优化版本
	public static boolean isValid_version2(String s) {
		char[] stack = new char[s.length()];
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			if (a == '(' || a == '{' || a == '[') {
				stack[length] = a;
				length++;
			} else if (length > 0 && ((stack[length - 1] == '(' && a == ')') || (stack[length - 1] == '[' && a == ']')
					|| (stack[length - 1] == '{' && a == '}')))
				length--;
			else
				return false;
		}
		if (length == 0)
			return true;
		else
			return false;
	}

	public static boolean isValid(String s) {

		Stack<Character> statck = new Stack<Character>();
		String res = "";
		char temp = 0;
		boolean flag = true;
		for (int i = 0; i < s.length() && flag; i++) {

			switch (s.charAt(i)) {
			case '(':
			case '[':
			case '{':
				statck.push(s.charAt(i));
				break;
			case ')':
				if (!statck.isEmpty())
					temp = statck.pop();
				if (temp == '(')
					res += "()";
				else
					flag = false;
				break;

			case ']':
				if (!statck.isEmpty())
					temp = statck.pop();
				if (temp == '[')
					res += "[]";
				else
					flag = false;
				break;
			case '}':
				if (!statck.isEmpty())
					temp = statck.pop();
				if (temp == '{')
					res += "{}";
				else
					flag = false;
				break;

			}
		}
		return flag && statck.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isValid("{[]}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("()"));
		System.out.println(isValid("([)]"));
	}

}
