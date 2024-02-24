package kh.mclass;

public class TestBubbleSort {
	public static void main(String[] args) {
//		Integer[] arr = new Integer[] { 3, 5, 2, 7, 1 };
		Double[] arr = new Double[] { 6.2, 5.4, 3.1, 10.1, 9.1 }; // Object의 후손엔 기본자료형이 없음 --> Double, Integer 등

		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - j - 1; i++) {
				if (arr[i] > arr[i + 1]) { // 오름차순
					double temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
//			if(arr[i] < arr[i+1]) { // 내림차순
//				
//			}
			}
			printArray(arr);
//			new TestBubbleSort().printArray(arr); // heap 영역에 공간 만들고 호출
		}
	}

	public static void printArray(Object[] arr) {
//	public void printArray(Object[] arr) { // 프로그램 시작 전 메모리 static 영역에 main 함수
											// 있는데 printArray 메소드도 같은 영역에 있어야 함
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
}
