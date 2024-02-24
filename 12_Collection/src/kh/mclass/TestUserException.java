package kh.mclass;

import java.util.Scanner;

public class TestUserException {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		CheckEven instance1 = new CheckEven();
		try {
			int result = instance1.printEvent(input);
			if (result == input)
				System.out.println(result + " 정상!");
		} catch (EvenException e) {
			e.printStackTrace();
		}
	}
}