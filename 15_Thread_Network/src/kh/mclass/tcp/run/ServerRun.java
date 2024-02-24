package kh.mclass.tcp.run;

import java.util.Arrays;

import kh.mclass.tcp.TCPEchoServer;

public class ServerRun {
	public static void main(String[] args) {
		int port = 8008; // 서버용 순서 1
		new TCPEchoServer().tcpServer(port);
//		Arrays.asList(new String[] {"1","2"});
	}
}