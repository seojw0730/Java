package kh.mclass;

import java.util.Arrays;

public class TestArray { // TestArray(class == Object)에 대해 정의
	public static void main(String[] args) {
//		args[0] = "aaa";
		String season1 = "봄";
		String season2 = "여름";
		String season3 = "가을";
		String season4 = "겨울";

		System.out.println("한국의 계절을 모두 나열하시오.");

		// 배열 Array: 같은 자료형으로 여러 개의 변수를 선언하여 사용 + 같은 유형의 값을 넣어 관리
		// *** 중요 ***: 배열의 크기를 할당 받아야 사용할 수 있음
		// 배열 선언 + 배열 사용(읽기, 쓰기)
		String[] arrSeason = { "봄", "여름", "가을", "겨울" };
		String arrSeason2[] = { "봄", "여름", "가을", "겨울" };
		String[] arr; // 선언처럼 보이나 arr 변수에 값 대입할 수 없음
		arr = new String[3]; // 할당 - 자료형[할당받을크기]
		arr[0] = "0번방값";
		arr[1] = "1번방값";
		arr[2] = "2번방값";
		// ArrayIndexOutOfBoundsException // arr[3] = "3번방값";
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println("=====배열을 반복문으로=====");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println(arrSeason[1]);
		arrSeason[1] = "초여름";
		System.out.println(arrSeason[1]);

		for (int i = 0; i < arrSeason.length; i++) {
			System.out.println(arrSeason[i]);
		}

		int arr1[] = new int[] { 10, 20, 30, 40 };
		int arr2[] = new int[] { 1, 2, 3, 4, 5, 6 };
		// 개인 실습 for()
		System.arraycopy(arr1, 0, arr2, 2, arr1.length);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		int v1 = 100;
		double v2 = 5.3;
		String v3 = "자료형에따른접근가능메소드";
		int[] v4 = new int[] { 10, 20 };
		String[] v5 = new String[] { "기호", "주의" };
		char v6 = '한';

		System.out.println(v3.charAt(3));
		System.out.println(v5.clone());
		System.out.println(v3.substring(2, 5));

		String str = "10";
		int num = Integer.valueOf(str);
		System.out.println(num);
		double d = Double.valueOf(str);
		System.out.println(d);

		int[][] array20 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } }; // [2][4], 정변배열
		int[][] array21 = { { 1, 2, 3, 4 }, { 5, 6, 7 } }; // 가변배열 [2][4], 한 칸은 비어있는 상태
		array21[1][2] = 1111;
//		array21[1][3] = 8;
		int[][] array22 = { { 1, 2, 3 }, { 5, 6, 7 } }; // [2][3]
		int[][] array23 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } }; // [2][4]
		int[][] array24 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } }; // [2][4]

		System.out.println(array21.length); // 행크기, m
		System.out.println(array21[0].length); // 행[0]의 열크기, n
		System.out.println(array21[1].length); // 행[1]의 열크기, n
		System.out.println("=====2차원 가변배열=====");
		for (int m = 0; m < array21.length; m++) { // 행크기
			for (int n = 0; n < array21[m].length; n++) { // 행[m]의 열크기
				System.out.println(array21[m][n]);
			}
		}
	}
}
