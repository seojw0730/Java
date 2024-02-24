package kh.mclass;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestStringTokenizer {
	public static void main(String[] args) {
		String str = "AA|BB|CC";

		StringTokenizer st = new StringTokenizer(str, "|");

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

//		List<Integer> intList = new ArrayList<Integer>();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 띄어쓰기와 함께 입력하세요.");
//
//		do {
//			System.out.println("처음엔 없을 거임");
//			intList.add(sc.nextInt());
//		} while (sc.hasNextInt());
//		System.out.println("끝");
//		System.out.println(intList);

		Date today = new Date();
		System.out.println(today);
		Date when = new Date(216000000000L);
		// 1970년 1월 1일 0시 0분 0초를 기준으로 함
		System.out.println(when);

		SimpleDateFormat ft = new SimpleDateFormat("Y M d h:m:s");
		String ftToday = ft.format(today);
		System.out.println(ftToday);

		StringBuffer sb1 = new StringBuffer("스트링버퍼값");
		StringBuffer sb2 = sb1; // 얕은복사 (주소값 복사 = heap 같은 공간 공유)
//		StringBuffer sb3 = (StringBuffer)sb1.clone();
//		Object returnvalue = sb1.clone();
		
//		Furniture f = new Chair();
//		Car c = new Sonata();
		
		System.out.println(sb1);
		System.out.println(sb2);
		sb1.append("aaa");
		System.out.println(sb1);
		System.out.println(sb2);
	}
}
