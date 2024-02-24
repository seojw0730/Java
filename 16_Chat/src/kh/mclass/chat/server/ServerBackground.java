package kh.mclass.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerBackground {
	private final int PORT = 7777;
	private ServerSocket serverSocket; // 서버 소켓
	private Socket socket; // 받아올 소켓 저장
	private DataOutputStream out;

	// 사용자들 정보를 저장하는 맵 객체 선언 key = nickName,
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>(); // 한방에 쏴주려고

	private ServerGUI gui;

	public void setGui(ServerGUI gui) {
		this.gui = gui;
	}

	// 서버 생성 - 서버 정보 설정
	public void setting() {
		// 1. 서버 포트 번호 설정
		try {
			serverSocket = new ServerSocket(PORT); // 필드값은 close()하면 안됨, 다른데서 쓸수도 있고 자바가 알아서 GarbageCollection 함

			gui.setJtaAppendMsg("접속자 대기 중...\n");
			
			while (true) {
				socket = serverSocket.accept(); // 여기서 클라이언트 받음
//				System.out.println("접속"); // [sjw - ok]
				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				new Receiver(socket).start();
			}
			// null
		} catch (IOException e) {
			e.printStackTrace();
		}
		// null
	}

	// 수신받은 메시지 내용을 BroadCasting(모든 receiver)방식으로 전파
	public void sendMessage(String receivedMsg, String nickName) {
		for (String key : clientMap.keySet()) {
			try {
//				DataOutputStream out = clientMap.get(key);
//				out.writeUTF(receivedMsg);
				System.out.printf("접속한 사람들: %s, 발신자: %s\n", key, nickName);
				if (!key.equals(nickName))
					clientMap.get(key).writeUTF(receivedMsg);
			} catch (IOException e) {
				 e.printStackTrace();
			}
		}
	}

	// 맵에 사용자 정보를 삭제하고 화면에 접속 정보를 표현하는 메소드
	public void removeClient(String nickName) {
		String message = nickName + "님이 나가셨습니다.\n";
		sendMessage(message, nickName); // 모든 clientMap 들에게 msg를 보냄
		gui.setJtaAppendMsg(message); // 나의 창에도 msg 나타내기
		clientMap.remove(nickName); // 방금 접속끊긴 사람을 clientMap에서 삭제하기
	}

	// ---------------------리시버---------------------------
	class Receiver extends Thread {
		private DataInputStream in; // 사용자가 전송한 데이터를 읽어 들이는 통로 생성
		private DataOutputStream out; // 사용자에게 데이터를 출력할 통로 생성
		private String nickName;

		public Receiver(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				nickName = in.readUTF();
				clientMap.put(nickName, out); // 클라이언트 전체한테는 output만 내보내면 됨 --> output만 Map으로 관리
				gui.setJtaAppendMsg(nickName + "님이 접속하였습니다.\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String msg;
			try { // 입력한 문자열을 화면에 출력하는 기능
				while (in != null) { // in 이 null 이 되려면 클라이언트와 통신이 끊어지거나 프로세스 종료되어야 함.
					msg = in.readUTF(); // UTF 문자셋으로 읽어 오는 메소드
					gui.setJtaAppendMsg(msg); // 나의 창에도 msg 나타내기
					sendMessage(msg, nickName); // 모든 clientMap 들에게 msg를 보냄
				}
			} catch (Exception e) { // 클라이언트와 통신이 끊어졌을때
//				e.printStackTrace();
				// 사용자가 접속 종료, 즉 GUI 종료 시 실행할 내용 작성
				removeClient(nickName);
			}
		}
	}
}