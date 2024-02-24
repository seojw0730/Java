package kh.mclass.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPEchoClient {
	public void tcpClient(String ip, int port) {
		Scanner sc = new Scanner(System.in);
		Socket cs = null;
		PrintWriter pw = null;
		BufferedReader br = null;

		try {
			System.out.println("server에 접속 요청 ...");
			cs = new Socket(ip, port); // 3. 서버에 접속하는 소켓 생성, 포트 없으면 Connection reset, 4. 클라 소켓 생성 --> cs를 통해 I/O
			pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			System.out.println("server에 접속 완료");
//			입출력 스트림 얻어옴
			while (true) {
				System.out.print("전달메시지 > ");
				String chat = sc.nextLine();
				if (chat.equals("exit")) {
					break;
				}
				pw.println(chat);
				pw.flush();
				
				String msg = null;
				msg = br.readLine();
				if (msg == null) {
					break;
				}
				System.out.println("echo > " + msg);
			}
			System.out.println("Echo TCP 끝");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sc != null)
					sc.close();
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
				if (cs != null)
					cs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}