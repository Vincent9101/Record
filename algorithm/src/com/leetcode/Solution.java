package com.leetcode;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*//		addTwoNums
		ListNode A, HeadA = A = new ListNode(1);
		ListNode B, HeadB = B = new ListNode(0);
		// for(int i=1;i<3;i++) {
		// A.next=new ListNode(i);
		// A=A.next;
		// B.next=new ListNode(i+8);
		// B=B.next;
		// }
		B.next = new ListNode(8);
//		Solution test = new Solution();
		test.printList(HeadA);
		test.printList(HeadB);
		test.printList(test.addTwoNumbers(HeadA, HeadB));*/
		Solution test = new Solution();
//	    最大子串：
		test.lengthOfLongestSubstring("abcdde");
		
		

	}

//给定一个字符串，找出不含有重复字符的最长子串的长度。
//
//示例：
//
//给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
//
//给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
//
//给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
	
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), length = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        int i,j;
        String str = null;
        for ( j = 0, i = 0; j < n; j++) {
        	
            i = Math.max(index[s.charAt(j)], i);//比较该字符位置存储的位置信息 是否最新  i是开头第一个字符位置 
            length = Math.max(length, j - i + 1);//记录长度 最大值
            index[s.charAt(j)] = j + 1;//如果是不同字符则会一直递增下去 如果遇到相同字符 则会更新之前该位置的数字 不是递增 
        }
       
     return length;

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head, Sum = head = new ListNode(0), pre = null;
		int val, temp;
		while (l1 != null || l2 != null) {

			val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
			temp = Sum.val + val;
			Sum.val = temp % 10;
			Sum.next = new ListNode(temp / 10);
			pre = Sum;
			Sum = Sum.next;

			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;

		}

		// while (l1 != null && l2 != null) {
		// val = l1.val + l2.val;
		// temp = Sum.val + val;
		// Sum.val = temp % 10;
		// System.out.println(temp+" Sum.val:"+Sum.val);
		// Sum.next = new ListNode(temp / 10);
		// pre=Sum;
		// Sum = Sum.next;
		// l1 = l1.next;
		// l2 = l2.next;
		//
		// }

		// while (l2 != null) {
		// temp = Sum.val + l2.val;
		// Sum.val = temp % 10;
		// Sum.next = new ListNode(temp / 10);
		// pre=Sum;
		// Sum = Sum.next;
		// l2=l2.next;
		//
		//
		//
		// }
		// while (l1 != null) {
		// temp = Sum.val + l1.val;
		// Sum.val = temp % 10;
		// Sum.next = new ListNode(temp / 10);
		// pre=Sum;
		// Sum = Sum.next;
		// l1=l1.next;
		// }
		//
		if (Sum.val == 0)
			pre.next = null;
		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
