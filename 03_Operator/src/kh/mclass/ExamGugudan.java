package kh.mclass;

public class ExamGugudan {
	public static void main(String[] args) {
		for (int dan0 = 2; dan0 <= 9; dan0++) {
			for (int su0 = 1; su0 <= 9; su0++) {
				int result0 = dan0 * su0;
				System.out.printf("%d * %d = %d\n", dan0, su0, result0);
			}
			System.out.println();
		}

		int dan1 = 2;
		int su1 = 1;
		int result1 = 0;
		while (dan1 <= 9) {
			su1 = 1;
			while (su1 <= 9) {
				result1 = dan1 * su1;
				System.out.printf("%d * %d = %d\n", dan1, su1, result1);
				su1++;
			}
			System.out.println();
			dan1++;
		}

		int dan2 = 2;
		int su2 = 1;
		int result2 = 0;
		do {
			su2 = 1;
			do {
				result2 = dan2 * su2;
				System.out.printf("%d * %d = %d\n", dan2, su2, result2);
				su2++;
			} while (su2 <= 9);
			System.out.println();
			dan2++;
		} while (dan2 <= 9);
	}
}
