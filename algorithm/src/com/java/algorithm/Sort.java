 package com.java.algorithm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class Sort {

	
	@Test
	public void testSort() {
		Integer[] array = new Integer[10];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		shellSort(array);

	}

	/**
	 * 希尔排序
	 * 
	 * @param array
	 */
	public void shellSort(Integer[] array) {
		BigDecimal timeStart = new BigDecimal(System.currentTimeMillis());
		BigDecimal spendTime = null;
		System.out.println("-----shellSort-----");
		System.out.println("�?��?��?��?�ǰ: " + Arrays.asList(array));
		Integer temp = null;
		int position;
		for (int gap = array.length / 2; gap >= 1; gap = gap / 2) {
			for (int i = gap; i < array.length; i++) {

				position = i - gap;
				temp = array[i];
				while (position >= 0 && temp < array[position]) {
					array[position + gap] = array[position];
					position -= gap;

				}
				array[i] = temp;
			}
		}
		spendTime = new BigDecimal(System.currentTimeMillis()).subtract(timeStart);
		System.out.println("�?��?��?��?��?�: " + Arrays.asList(array));
		System.out.println("�?��?��?��?��?�?��?�: " + spendTime);

	}

	/**
	 * 插入排序
	 * 
	 * @param array
	 */
	public void insertionSort(Integer[] array) {
		BigDecimal timeStart = new BigDecimal(System.currentTimeMillis());
		BigDecimal spendTime = null;
		Integer temp = null;
		int position;
		System.out.println("-----insertionSort-----");

		for (int i = 1; i < array.length; i++) {

			temp = array[i];
			position = i - 1;

			while (position >= 0 && temp < array[position]) {
				array[position + 1] = array[position];
				position--;
			}
			array[position + 1] = temp;

		}
		spendTime = new BigDecimal(System.currentTimeMillis()).subtract(timeStart);

		System.out.println("�?��?��?��?��?�?��?�: " + spendTime);
	}

	public void insertionSortByFindingPosition(Integer[] array) {
		BigDecimal timeStart = new BigDecimal(System.currentTimeMillis());
		BigDecimal spendTime = null;
		Integer temp = null;
		int position;
		System.out.println("-----insertionSortByFindingPosition-----");
		// System.out.println("�?��?��?��?�ǰ: " + Arrays.asList(array));
		for (int i = 1; i < array.length; i++) {

			position = i;

			// �?�ҵ�?�position�?��?��?��?�ǰ?��?��?��?�?��?�
			while (position > 0 && array[i] < array[position - 1]) {
				position--;
			}
			// �?�ҵ�?��?�?��?�֝�?��?��?��?��?�?��?��?��?��?��?��?
			// �?�?��?��?�array[i]�?��?��?��?�position�?�?��?�
			temp = array[i];
			for (int j = i; j > position; j--) {
				array[j] = array[j - 1];
			}
			array[position] = temp;

		}
		spendTime = new BigDecimal(System.currentTimeMillis()).subtract(timeStart);
		// System.out.println("�?��?��?��?��?�: " + Arrays.asList(array));
		System.out.println("�?��?��?��?��?�?��?�: " + spendTime);
	}

	/**
	 * 选择排序
	 * 
	 * @param array
	 */
	public void selectSort(Integer[] array) {
		BigDecimal timeStart = new BigDecimal(System.currentTimeMillis());
		BigDecimal spendTime = null;
		System.out.println("-----selectSort-----");
		System.out.println("�?��?��?��?�ǰ: " + Arrays.asList(array));
		int minIndex;
		Integer temp = null;

		for (int i = 0; i < array.length - 1; i++) {

			minIndex = i;

			for (int j = i + 1; j < array.length; j++) {

				if (array[minIndex].intValue() > array[j].intValue()) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
		spendTime = new BigDecimal(System.currentTimeMillis()).subtract(timeStart);
		System.out.println("�?��?��?��?��?�: " + Arrays.asList(array));
		System.out.println("�?��?��?��?��?�?��?�: " + spendTime);

	}

	/**
	 * 冒泡排序
	 * 
	 * @param array
	 */
	public void bubbleSort(Integer[] array) {
		BigDecimal timeStart = new BigDecimal(System.currentTimeMillis());
		BigDecimal spendTime = null;
		System.out.println("-----bubbleSort-----");
		// System.out.println("�?��?��?��?�ǰ: " + Arrays.asList(array));
		Integer temp = null;
		boolean exchanged = false;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {

				if (array[j].intValue() > array[j + 1].intValue()) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					exchanged = true;
				}
			}
			// �?��?��?��?�?����?��?��?��?��?�˵�?��?�˳�?��?��?��?�?��?��?��?��?��?��?�ȷ�?��?�
			// �?��?��?��?��?�?��?��?��?� �?�?��?��?��?��?��?�
			if (!exchanged)
				break;
		}
		spendTime = new BigDecimal(System.currentTimeMillis()).subtract(timeStart);
		System.out.println("�?��?��?��?��?�: " + Arrays.asList(array));
		System.out.println("�?��?��?��?��?�?��?�: " + spendTime);
	}
}
