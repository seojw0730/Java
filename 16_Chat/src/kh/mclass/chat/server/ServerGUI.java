package kh.mclass.chat.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class ServerGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 3216336723360170144L;

	private JTextArea jta = new JTextArea(40, 25); // 채팅 창
	private JTextField jtf = new JTextField(25); // 글 입력 부분
//	private JButton jbtn = new JButton("전송"); // 글 입력 버튼

	// view - controller 필드 생성
	private ServerBackground back = new ServerBackground(); // 채팅을 담당할 백그라운드(뒷 작업 영역) 선언

	public ServerGUI() {
		// 생성자 = 초기값 지정, JFrame 기본 화면 구성
		jta.setEditable(false);
		jta.setFont(new Font("굴림", Font.PLAIN, 18));
		jta.setBackground(new Color(230, 255, 230));
		add(jta, BorderLayout.CENTER); // jta 얹어줘

		jtf.addActionListener(this); // jtf에서 enter key 치면 actionPerformed() 호출되게 등록함
		add(jtf, BorderLayout.SOUTH); // jtf 얹어줘
//		jbtn.addActionListener(this); // jbtn 누르면 actionPerformed() 호출되게 등록함
//		add(jbtn, BorderLayout.EAST);

		setBounds(200, 100, 400, 600);
		setTitle("서버부분");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		//
		back.setGui(this); // 현재 창을 back에게 전달 --> back에서 setJtaAppendMsg 호출할 수 있도록 함
		back.setting(); // GUI 실행 시 서버도 같이 동작시킴
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 문자 입력 창에 글 입력 시 구동할 이벤트 설정
		String msg = "운영자: " + jtf.getText() + "\n";
		System.out.println(msg);
		jta.append(msg); // 채팅 창에 추가
		jtf.setText(""); // 입력 후 내용 초기화
		back.sendMessage(msg, "운영자");

//		System.out.println("event 발생");
//		System.out.println(e.getSource());
//		java.awt.event.ActionEvent
//		[ACTION_PERFORMED,
//		cmd=,
//		when=1708481268100,modifiers=] 
//		on javax.swing.JTextField <-- 키포인트
//		[,0,541,384x20,
//		layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,
//		alignmentX=0.0,
//		alignmentY=0.0,
//		border=javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@65989a0,
//		flags=296,
//		maximumSize=,
//		minimumSize=,
//		preferredSize=,
//		caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],
//		disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],
//		editable=true,margin=javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0],
//		selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],
//		selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],
//		columns=25,columnWidth=10,command=,horizontalAlignment=LEADING]
	}

	public void setJtaAppendMsg(String msg) {
		jta.append(msg);
	}
}
