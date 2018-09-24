package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 该文件是之前刷LeetCode做的一些题目 由于当时没有想过要存下来 因此比较杂乱 以后的每个题目对应不同的class文件和描述
 * 
 * @author Vincent
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution test = new Solution();

		test.lengthOfLongestSubstring("abcdde");

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = null;
		// int H, L, mid,sum;
		int a = 0, right, left, sum;
		Arrays.sort(nums);
		// for (int x : nums)
		// System.out.println(x);
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

				if (left - 1 > 1 && nums[left - 1] == nums[left])
					left++;
				if (right + 1 < nums.length && nums[right + 1] == nums[right])
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
		// System.out.println("���һ��\n");

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

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (flag)
				break;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[index++] = i;
					res[index++] = j;
					flag = true;
					break;
				}
			}

		}
		return res;
	}

	// 是否是回文数
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

		for (int i = 0; i < words.length - 1; i++) {
			String temp = words[i];
			String temp2 = words[i + 1];
			for (int j = 0; j < s.length() - temp.length(); j++) {
				if (s.substring(j, j + temp.length()).equals(temp)) {
					System.out.println(s.substring(j, j + temp.length()));
					substringPosition.add(j);
				}

			}
		}

		return substringPosition;
	}

	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), length = 0;
		int[] index = new int[128]; // current index of character
		// try to extend the range [i, j]
		int i, j;
		String str = null;
		for (j = 0, i = 0; j < n; j++) {

			i = Math.max(index[s.charAt(j)], i);// �Ƚϸ��ַ�λ�ô洢��λ����Ϣ �Ƿ����� i�ǿ�ͷ��һ���ַ�λ��
			length = Math.max(length, j - i + 1);// ��¼���� ���ֵ
			index[s.charAt(j)] = j + 1;// ����ǲ�ͬ�ַ����һֱ������ȥ ���������ͬ�ַ� ������֮ǰ��λ�õ����� ���ǵ���
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
