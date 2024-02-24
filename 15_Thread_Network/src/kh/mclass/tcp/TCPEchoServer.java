package kh.mclass.tcp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoServer {
	public void tcpServer(/* byte[] ip, */ int port) {
		ServerSocket ss = null;
		Socket s = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		System.out.println();
		
		try {
//			ss = new ServerSocket(); // Windows 남은 포트 자동할당
			ss = new ServerSocket(port); // 1. 서버 소켓 생성
			System.out.println("=== client 접속 대기 중 ===");
//			close있나 확인
			s = ss.accept(); // 2. client 접속 대기, 4. 서버 소켓 생성 --> s를 통해 I/O
			System.out.println("=== client 접속 ===");
			
//			입출력 스트림 얻어옴
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println("Client > " + msg);
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				pw.println("~~~ " + msg);
				pw.flush();
			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
				
				if (s != null)
					s.close();
				if (ss != null)
					ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
