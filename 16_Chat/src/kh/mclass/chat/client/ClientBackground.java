package kh.mclass.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	private final int PORT = 7777;
	private final String IP = "127.0.0.1";
	private Socket socket; // 받아올 소켓 저장
	private DataInputStream in;
	private DataOutputStream out;
	private String nickName;

	private ClientGUI gui;

	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}

	// 클라이언트가 서버에 접속하는 메소드
	public void connect(String nickName) {
		try {
			socket = new Socket(IP, PORT); // 서버에 연결 성공
//			System.out.println("서버 접속"); // [sjw - ok]
			gui.setJtaAppendMsg("서버 접속되었습니다.\n");
			// 서버와 주고받을 입출력 통로 생성
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			// 접속 후 서버에서 닉네임 인식
			out.writeUTF(nickName); // 접속되자마자 닉네임 전송 // flush 없음

			// 수신 메시지 있는지 계속 반복문으로 확인
			while (in != null) {
				String msg = in.readUTF();
				gui.setJtaAppendMsg(msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
			gui.setJtaAppendMsg("서버를 찾을 수 없습니다. IP와 Port번호를 확인 후 재시도 해주세요.");
		} catch (Exception e) {
			gui.setJtaAppendMsg("예기치 못한 오류가 발생했습니다. 프로그램 종료 후 재시도 해주세요.");
		}
	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
