package kh.mclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static String ip = "localhost"; // 상대방 ip
	private static int myPort = 9007;
	private static int destPort = 9008;

	public static void main(String[] args) {
		new UDPEchoServer().udpServer(myPort);
	}

	public void udpServer(int myPort) {
		// 1. UDP 소켓 생성
		try (DatagramSocket dsock = new DatagramSocket(myPort)) {
			while (true) {
				// 2. 수신받을 데이터 packet 만들기
				byte[] buffer = new byte[1000];
				DatagramPacket dPacket = new DatagramPacket(buffer, buffer.length); // 크기 넘으면 나머지 누락됨
				// 3. socket 통해서 수신받은 데이터 packet에 담기
				dsock.receive(dPacket); // .receive(): return형이 void라 채워넣기만 함(자바에서 드문 경우)
//				String receiveMsg = new String(dPacket.getData());
				String receiveMsg = new String(dPacket.getData(), 0, dPacket.getLength());
				System.out.println(receiveMsg.length());
				System.out.println(dPacket.getLength());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}