package level1;

import java.util.StringTokenizer;

public class Pro1 {
	public static void main(String[] args) {
		String s = "2 3 1 4";

		StringTokenizer st = new StringTokenizer(s, " ");
		System.out.println(st.countTokens());
		int[] arr = new int[st.countTokens()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i < j) {
					if (arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
	}
}
