package CarOn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Windowin2 extends JFrame implements ActionListener {
	
	JTextField jtf = new JTextField();
	JPanel pn1;
//	JButton b2, b3;// b4; b5, b6, b7, b8, b9, b10, b11, b12, b13, b14;

	public Windowin2() {
		super("선택창");// JFrame 생성자 호출
		setLayout(new GridLayout(0, 3));
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기

		// -- 컴포넌트 생성 --

		JButton BMWwindowgo = new JButton(new ImageIcon("image\\BMW.jpg.png"));
		JButton BENZwindowgo = new JButton("BENZ");
		JButton AUDIwindowgo = new JButton("AUDI");


		setVisible(true);

		setLocationRelativeTo(null);
		add(BMWwindowgo);
		add(BENZwindowgo);
		add(AUDIwindowgo);


		BMWwindowgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BMWseach();
				dispose();

			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		new Windowin();

	}

	public static void main(String[] args) {

	}

}
