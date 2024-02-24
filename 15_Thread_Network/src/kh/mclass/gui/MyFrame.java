package kh.mclass.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("300x300 스윙 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300); // 프레임 크기 300x300

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.orange);
//		contentPane.setLayout(new FlowLayout((FlowLayout.LEFT),30,40));
//		contentPane.setLayout(new BorderLayout());
		contentPane.setLayout(new GridLayout(4, 2));
//		contentPane.add(new JButton("OK"), BorderLayout.NORTH);
//		contentPane.add(new JButton("Cancel"), BorderLayout.SOUTH);
//		contentPane.add(new JButton("Ignore"), BorderLayout.WEST);
		JButton btnOrg1 = new JButton("초기값");
		JButton btnOrg2 = new JButton("이름초기값");
		JButton btnOK = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");
		JTextField txtGrade = new JTextField("정수 1-6");

		contentPane.add(btnOrg1);
		contentPane.add(btnOrg2);
		contentPane.add(new JLabel("학년"));
		contentPane.add(txtGrade);
		contentPane.add(new JLabel("이름"));
		contentPane.add(new JTextField("문자 30자 이내"));
		contentPane.add(btnOK);
		contentPane.add(btnCancel);

		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnOrg1.setText(txtGrade.getText());
			}
		});

		setVisible(true); // 프레임 출력
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
