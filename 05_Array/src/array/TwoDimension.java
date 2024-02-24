package array;

public class TwoDimension {
	public static void main(String[] args) {
//		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.println(arr[i][j]);
//			}
//			System.out.println();
//		}

		int[][] arr2 = new int[13][2];
		arr2[0][0] = 'a';
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 2; j++) {
				arr2[i][j] = arr2[0][0] + (2 * i) + j;
				System.out.print((char) arr2[i][j] + " ");
			}
			System.out.println();
		}
	}
}
