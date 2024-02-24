package kh.mclass;

public class TestArray2 {
	public static void main(String[] args) {
//		int arr1[] = new int[5];
//		for (int i = 0; i < arr1.length; i++) {
//			arr1[i] = i + 1;
//			if (i < arr1.length - 1) {
//				System.out.print(arr1[i] + ", ");
//			} else {
//				System.out.print(arr1[i]);
//			}
//		}

//		int arr1[] = new int[5];
//		for (int i = 0; i < arr1.length; i++) {
//			arr1[i] = i + 1;
//			System.out.print(arr1[i]);
//			if (i == arr1.length - 1) {
//				break;
//			}
//			System.out.print(", ");
//		}
//		System.out.println();

//		int arr1[] = new int[5];
//		arr1[0] = 1;
//		arr1[1] = 2;
//		arr1[2] = 3;
//		arr1[3] = 4;
//		arr1[arr1.length - 1] = 5;
//		System.out.print(arr1[i]);
//		if (i == arr1.length - 1) {
//			break;
//		}
//		System.out.print(", ");
//		System.out.println();

//		int arr1[] = new int[5];
//		for (int i = 0; i < arr1.length; i++) {
//			arr1[i] = i + 1;
//			System.out.print(arr1[i]);
//			if (i == arr1.length - 1) {
//				continue;
//			}
//			System.out.print(", ");
//		}
//		System.out.println();

		System.out.println("=== 중첩배열 ===");

		int arr2[][] = new int[5][3];
		for (int m = 0; m < arr2.length; m++) {
			for (int n = 0; n < arr2[0].length; n++) {
				arr2[m][n] = 3 * m + (n + 1);
				System.out.printf("%d\t", arr2[m][n]);
			}
			System.out.println();
		}
	}
}