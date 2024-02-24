package kh.mclass;

public class TestFor {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 100; i++/* 실행영역 끝나고 이 부분 실행 - 주로 증감식 */) {
			System.out.println("조건식이 true면 실행하는 영역");
			System.out.println(i);
		}
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println("기존 " + sum + "값에서 " + i + "만큼 더하기");
				sum += i; // 누적 합
			}
		}
		System.out.println("1부터 100까지 짝수들의 합계 : " + sum);
		
		int i = 2;
		int sum2 = 0;
		while(i <= 100) { // 분야에 따라서 for, while 빈도 다름 / while은 뭔가 누를 때까지 계속 하는 거?
			sum2 += i;
			i += 2;
		}
		System.out.println("1~100 짝수 합 : " + sum2);

		for (int 단 = 2; 단 <= 9; 단++) {
			System.out.println(단 + "단");
			for (int 수 = 1; 수 <= 9; 수++) {
				int 결과 = 단 * 수;
				System.out.printf("%d * %d = %d\n", 단, 수, 결과);
			}
			System.out.println();
		}

		for (int 몇 = 2; 몇 <= 9; 몇++) {
			System.out.printf("%d단\t\t", 몇);
		}

		System.out.println();

		for (int 수 = 1; 수 <= 9; 수++) {
			for (int 단 = 2; 단 <= 9; 단++) {
				int 결과 = 단 * 수;
				System.out.printf("%d * %d = %d\t", 단, 수, 결과);
			}
			System.out.println();
		}

	}
}
