package com.leetcode;

import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Solution_A extends Solutions {

}

public class Solutions {

	@Test
	public void test1() {
	
	}
//	@Test
	public void changCode() {
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		// while(scan.hasNextLine())
		// {
		// String str=scan.nextLine();
		//
		//
		//
		// }

		Boolean bool = false;
		boolean bool_1 = true;
		Integer in = 8;
		String str = "1";
		switch (str) {
		case "2":
			System.out.print(in.valueOf("770") + in);
			break;
		case "1":
			System.out.println("���");
			break;
		}

	}

	private final static void print() {
		System.out.println("����");
	}

	static void La() {
		print();
	}

	// @Test
	void then() {
		Solutions S = new Solutions();
		System.out.print(S instanceof Solutions);
		Solution_A.La();
	}

}
