package kh.mclass;

import java.util.Scanner;

public class ControlTest {
	public static void main(String[] args) {
//		int score = 10;
//
//		Scanner sc = new Scanner(System.in);
//		score = sc.nextInt();
//
//		String grade = "없음";
////		if(score < 0) {
////			System.out.println("성적은 음수일 수 없습니다.");
////		}
////		else {
////			System.out.println("성적은 " + score);
////		}
////		if(score > 100) {
////			System.out.println("만점은 100점입니다. 100점 이하로 작성해주세요.");
////		}
////		if(score < 60) {
////			System.out.println("재평가 대상자입니다.");
////		}
////		if(score > 90 && !(score > 100)) {
////			System.out.println("우수성적입니다.");
////		}
//
//		if (score < 0) {
//			System.out.println("성적은 음수일 수 없습니다.");
//		} else if (score < 60) {
//			grade = "F";
//			System.out.println("재평가 대상자입니다.");
//		} else if (score < 90) {
//			grade = "B";
//		} else if (score <= 100) {
//			grade = "A";
//			System.out.println("우수성적입니다.");
//		} else {
//			System.out.println("만점은 100점입니다. 100점 이하로 작성해주세요.");
//		}
//
//		switch (grade) {
//		case "A":
//			System.out.println("우수성적입니다.");
//			break;
//		case "B":
//			break;
//		case "F":
//			System.out.println("재평가 대상자입니다.");
//			break;
//		default:
//			System.out.println("만점은 100점입니다. 100점 이하로 작성해주세요.");
//
//		}
//
//		System.out.println();
//
////		if (score >= 60) {
////			grade = "통과";
////		} else {
////			grade = "재평가";
////		}
//
//		grade = (score >= 60) ? "통과" : "재평가";
//
//		int a = 10;
//		int b = 20;
//		int result1 = a > b ? a++ : b--;
//		int result2 = a < b ? a++ : (b == 0 ? a-- : b++);
//
//		if (a > b) {
//			result1 = a++;
//		} else {
//			result1 = b--;
//		}
//
//		if (a < b) {
//			result2 = a++;
//		} else if (b == 0) {
//			result2 = a--;
//		} else {
//			result2 = b++;
//		}
//
//		int data = 10;
//		System.out.println(~data); // 1의 보수
//		System.out.println(~data + 1); // 0의 보수
//
//		System.out.println(true);
//		System.out.println(!true);
//		System.out.println(!(a == b));
//		System.out.println("=====shift 연산자=====");
//		System.out.println(16 >> 1); // 1/2배
//		System.out.println(16 >> 2); // 1/4배
//		System.out.println(16 >> 3); // 1/8배
//		
//		System.out.println(-16 >>> 1); // 1/2배 부호비트까지 shift
//		System.out.println(-16 >>> 2); // 1/4배 부호비트까지 shift
//		System.out.println(-16 >>> 3); // 1/8배 부호비트까지 shift
//
//		System.out.println(16 << 1); // 2배
//		System.out.println(16 << 2); // 4배
//		System.out.println(16 << 3); // 8배

		int month = 12;
		String season = "";
		int temperature = -13;
		switch (month) {
		case 12:
		case 1:
		case 2:
			season = "겨울";
			if (temperature <= -15) {
				season += " 한파 경보";
			} else if (temperature <= -12) {
				season += " 한파 주의보";
			}
			break;
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		default:
			season = "1~12 사이의 정수를 입력해주세요.";
			break;
		}
		System.out.println(season);
	}
}
