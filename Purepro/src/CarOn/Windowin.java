package CarOn;
//회원가입 클래스
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Windowin extends JFrame {
	private JButton joinerBtn = new JButton("확인");

	public Windowin() {
		setTitle("회원가입");// 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창닫기
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
		setResizable(false);

		JRadioButton man = new JRadioButton("Man", true);
		JRadioButton woman = new JRadioButton("Woman");
		ButtonGroup g = new ButtonGroup();

		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기

		JLabel jLabel = new JLabel();
		jLabel.setHorizontalAlignment(JLabel.RIGHT); // JLabel 오른쪽 정렬
		

		c.add(new JLabel("이름"));
		c.add(new JTextField(15));

		c.add(new JLabel("아이디 "));
		c.add(new JTextField(15));

		c.add(new JLabel("비밀번호 "));
		c.add(new JTextField(15));

		c.add(new JLabel("비밀번호확인"));
		c.add(new JTextField(15));

		c.add(new JLabel("이메일"));
		c.add(new JTextField(15));

		c.add(man);
		c.add(woman);
		g.add(man);
		g.add(woman);

		c.add(joinerBtn);

		setSize(288, 330);
		setVisible(true);
		joinerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Windowin2();
				
			}
			});
	}

}
