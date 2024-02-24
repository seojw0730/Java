package kh.mclass;

import java.sql.Date;

public class Helloworld {
	public static void main(String[] args) {
		System.out.println("Hi,Everyone!!");
		
		String str = "기차" + 123 + 45 + "출발";
		System.out.println("기차" + 123 * 45 + "출발");
		
		for(int i=0; i<256; i++) {
			System.out.println((byte)i);
		}
		
		System.out.println((double) (10 / 3 + (double) 2));
		
		int 가;
		가 = '가';
		System.out.println(가);
	}
}
