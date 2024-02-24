package kh.mclass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TestException {
	public static void main(String[] args) {
//		file 관련 생성자는 대부분 매개변수 필요
//		Unhandled exception type FileNotFoundException
//		Unhandled exception type IOException
//		It is already handled ~~ --> 부모클래스 자식클래스 순서 바뀜
//		br cannot be resolved --> br 선언 안 돼있음.
//		Unhandled exception type IOException

		// try-with-resource
		// 선언된 br.close() 를 finally 구문 처리처럼 해줌. but sysout 같은 다른 구문 추가 불가
		try (BufferedReader br = new BufferedReader(new FileReader(new File("./log/20240216_log.txt")))) {
			String s;
			while ((s = br.readLine()) != null) {
//				s = br.readLine();
//				if (s != null)
				System.out.println(s);
//				else
//					break;
			}
			s = br.readLine();
//			System.out.println(s);
		} catch (FileNotFoundException e) {
			System.out.println("===3===");
			e.printStackTrace();
			System.out.println("파일 만들고 다시 실행");
		} catch (IOException e) {
			System.out.println("===4===");
			e.printStackTrace();
			System.out.println("파일 만들고 다시 실행");
		}
		System.out.println("---여기까지");

//		BufferedReader br = null;
//		try {
//			System.out.println("===1===");
////			if (true) {
////				return; // 빠져나가기 전에 finally 구문은 실행하고 나감
////			}
//			br = new BufferedReader(new FileReader(new File("a.txt")));
//			System.out.println("===2===");
//		} catch (FileNotFoundException e) {
//			System.out.println("===3===");
//			e.printStackTrace();
//			System.out.println("파일 만들고 다시 실행");
//		} catch (IOException e) {
//			System.out.println("===4===");
//			// TODO Auto-generated catch block
//			e.printStackTrace(); // 끝나면 다음줄(19)부터 실행
//			// call stack - push pop
//			System.out.println("파일 만들고 다시 실행");
//		} finally {
//			System.out.println("===5===");
//			try {
//				if (br != null)
//					br.close(); // if 문에서 실행문 한 줄이면 {} 안 쓰기도 함
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		// 주로 큰 리소스를 사용하는 java.io 또는 java.sql의 객체들은 close()를 반드시 해줘야함.
//		// quickfix 1. implements 2. add throws declaration
//		System.out.println("===6===");
//
//		try {
//			List<String> list1 = null;
//			list1.add("오류");
//			// 실행 코드 작성
//			// 실행 중 오류가 발생할 가능성이 있는 코드들 포함
//		} catch (NullPointerException e1/* try 구문 내 발생할 가능성이 있는 Exception 종류 선언 != 매개변수 선언 */) {
//			/* Exception 오류가 발생했을때 하고 싶은 코드 */
//			e1.printStackTrace();
//		}
//		System.out.println("===");
	}
}
