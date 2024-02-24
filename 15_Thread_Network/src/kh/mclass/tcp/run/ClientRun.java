package kh.mclass.tcp.run;

import kh.mclass.tcp.TCPEchoClient;

public class ClientRun {
	public static void main(String[] args) {
		int port = 8008;
		new TCPEchoClient().tcpClient("localhost", port);
	}
}