package kh.mclass;

import java.util.Random;

public class TestBubbleSort2 {
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 6, 2, 1, 3, 7, 8, 4, 9 };

		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			System.out.print("[");
			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println("]");
		}
	}
}
