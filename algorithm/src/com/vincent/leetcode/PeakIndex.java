package com.vincent.leetcode;

public class PeakIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
	}

	public static int peakIndexInMountainArray(int[] A) {

		int tempIndex = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] > A[i]) {
				tempIndex = i - 1;
				break;
			}
		}
		return tempIndex;

	}
}
