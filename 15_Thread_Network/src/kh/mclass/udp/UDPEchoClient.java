package kh.mclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPEchoClient {
	private static String ip = "localhost"; // 상대방 ip
	private static int myPort = 9008;
	private static int destPort = 9007;

	public static void main(String[] args) {
		new UDPEchoClient().udpClient(myPort);
	}

	public void udpClient(int myPort) {
		System.out.println("보낼 메시지 > ");
		Scanner sc = new Scanner(System.in);
		String sendMsg = sc.nextLine();
//		byte[] sendMsgByteArr = new byte[sendMsg.length()*2];
		byte[] sendMsgByteArr = sendMsg.getBytes();

		// 1. UDP 소켓 생성
		try (DatagramSocket dsock = new DatagramSocket(myPort)) {
			InetAddress inetAddr = InetAddress.getByName(ip);
			// 2. 보낼 데이터 만들기
			DatagramPacket dPacket = new DatagramPacket(sendMsgByteArr, // 보내는 데이터를 byte[]형태로
					sendMsgByteArr.length, // 보내는 데이터 길이
					inetAddr, // 상대방 ip
					destPort);
			// 3. socket 통해서 packet 보내기
			dsock.send(dPacket);

		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}