package kh.mclass;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		System.out.println("입력해주세요====>");
		Scanner in = new Scanner(System.in); // System.in - console창에 입력데이터를 받아들일 수 있는 객체(값)
		String inputStr = in.nextLine();
		System.out.println("입력받은 값은 " + inputStr + " 입니다.");
	}
}
