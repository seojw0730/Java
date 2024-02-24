package kh.mclass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestIOStream {
	public static void main(String[] args) {
		// File 객체 생성
		File f1 = new File("./test/test.txt");
		if (!f1.exists())
			// 우리가 아는 test.txt 파일 만들기
			f1.mkdirs(); // 없는 디렉토리 다 만들기 | f1 = 디렉토리 상태
		File f2 = new File("./test/test.txt/test2.txt");
		try {
			f2.createNewFile(); // f2 = 파일 상태
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 현재 디렉토리에 파일 생성시에는 mkdir용 File 생성 없어도 됨.
		File f3 = new File("test3.txt");
		try {
			f3.createNewFile(); // f3 = 파일 상태
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] arrF = f1.list();
//		System.out.println(f1.list());
//		System.out.println(f2.list());
//		System.out.println(f3.list());
		if (arrF != null) {
			for (String s : arrF)
				System.out.println(s);
		}
		String[] arrN = new File("./").list();
		System.out.println(arrN);
		for (String s2 : arrN)
			System.out.println(s2);

		File f5 = new File("./src/a.txt");
		try {
			f5.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f5.length());

		if (f3.isDirectory()) {
			String[] fileList = f3.list();
		} else if (f3.isFile()) {
			System.out.println(f3.length());
			System.out.println(f3.getPath());
		}

//		BufferedReader br = new BufferedReader(new FileReader(new File("a.txt")));
//		파일 객체에 쓰기(출력 스트림)
		FileWriter fw2 = null;
		FileWriter fw3 = null;
		try {
			fw2 = new FileWriter(f2); // 덮어쓰기
			fw2.write("aaa");
			fw3 = new FileWriter(f3, true); // 이어쓰기
			fw3.write("가");
			fw2.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fw2 != null)
					fw2.close(); // flush 포함
				if (fw3 != null)
					fw3.close(); // flush 포함
			} catch (IOException e2) {
				e2.printStackTrace();
				System.out.println("오류1");
			}
		}

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f3);
//			char[] readData = new char[1000];
//			System.out.println(readData.length);
//			int length = fr.read(readData);
//			System.out.println(readData.length); // 1000
//			System.out.println(length);
//			System.out.println(readData);
//			String readStr = String.valueOf(readData);
//			System.out.println(readStr);

//			보조 스트림 달기
			System.out.println("=== 보조 스트림 ===");
			br = new BufferedReader(fr);
			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
