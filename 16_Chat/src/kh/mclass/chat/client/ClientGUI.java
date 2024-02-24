package kh.mclass.chat.client;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 8225164367035267687L;
	private JTextArea jta = new JTextArea(40, 25); // 채팅 창
	private JTextField jtf = new JTextField(25); // 글 입력 부분
	private String nickName;

	// view - controller필드 생성
	private ClientBackground back = new ClientBackground(); // 채팅 담당 백그라운드 선언

	public ClientGUI() {
		this("익명클라이언트"); // nickName 안 적으면 "익명클라이언트"로 설정
	}

	public ClientGUI(String nickName) {
		super();
		// 생성자 = 초기값 지정, JFrame 기본 화면 구성
		this.nickName = nickName;
		init();
	}

	private void init() {
		jta.setEditable(false);
		jta.setFont(new Font("굴림", Font.PLAIN, 18));
		jta.setBackground(new Color(230, 255, 230));
		add(jta, BorderLayout.CENTER); // jta 얹어줘

		jtf.addActionListener(this); // jtf에서 enter key 치면 actionPerformed() 호출되게 등록함
		// jtf 에서 문자 관리하는 쓰레드 + jtf 에서 엔터 발생하는지 확인하는 쓰레드
		add(jtf, BorderLayout.SOUTH); // jtf 얹어줘

		setBounds(200, 100, 400, 600);
		setTitle("클라이언트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		back.setGui(this);
		back.connect(nickName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// synchronized ?

		String msg = nickName + ": " + jtf.getText() + "\n";
		System.out.println(msg);
		jta.append(msg); // 채팅 창에 추가
		jtf.setText(""); // 입력 후 내용 초기화
		back.sendMessage(msg);
	}

	public void setJtaAppendMsg(String msg) {
		jta.append(msg);
//		init(); // 이렇게 첫화면으로 만들어주고 싶을때 init() 은 유용
	}
}
