package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if (num >= 1) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}

	public void practice2() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if (num >= 1) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		} else {
			while (num < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
				System.out.print("1이상의 숫자를 입력하세요 : ");
				sc.nextInt();
				if (num >= 1) {
					break;
				}
			}
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		}
	}
}