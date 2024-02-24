package kh.mclass;

public class Book {
	public static void main(String[] args) {
		for (int i = 1; i < 8; i += 2) {
			for (int k = 7 - i; k > 0; k--) {
				System.out.print(" ");
			}
			for (int j = 1; j < i + 1; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for (int i = 2; i < 7; i += 2) {
			for (int k = 1; k <= i; k++) {
				System.out.print(" ");
			}
			for (int j = 7 - i; j > 0; j--) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
}
