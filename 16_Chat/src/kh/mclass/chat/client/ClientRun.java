package kh.mclass.chat.client;

import javax.swing.JOptionPane;

public class ClientRun {
	public static void main(String[] args) {
		// 사용자 GUI를 구동하기 위한 메소드
		String nickName = JOptionPane.showInputDialog("닉네임을 입력하세요."); // 생성자에 넣어도 됨
		// cancel ==> null, 빈칸 후 OK ==> ""
//		if (!nickName.equals("") && nickName != null) {
//		if (!(nickName == null || nickName.equals(""))) { // 왼쪽부터 연산돼서 순서 바꾸면 NullPointerException 발생 ==> null 체크가 더 넓은 범위?, &&에서 앞이 F면 뒤 체크 안함
		if (nickName != null && !nickName.equals("")) { // 왼쪽부터 연산돼서 순서 바꾸면 NullPointerException 발생 ==> null 체크가 더 넓은 범위?, &&에서 앞이 F면 뒤 체크 안함
			new ClientGUI(nickName);
		} else {
			System.out.println("닉네임 없이는 채팅 입장이 불가합니다.");
		}
	}
}
