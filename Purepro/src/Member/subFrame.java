package Member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class subFrame extends JFrame implements ActionListener {
	private JFrame fe;
	private JLabel ft;
	private JButton bbt;

	public subFrame() {

		fe = new JFrame("회원가입오류");
		fe.setLayout(null);
		fe.setSize(450, 200);
		fe.setBackground(Color.WHITE);
		fe.setResizable(false);
		fe.setLocationRelativeTo(null);
		fe.setVisible(true);

		bbt = new JButton("닫기");
		bbt.setBounds(180, 120, 90, 40);

		ft = new JLabel("회원정보 모두 입력");
		ft.setLayout(null);
		ft.setBounds(135, 40, 220, 60);
		ft.setFont(new Font("Gothic", Font.BOLD, 20));

		fe.add(ft);
		fe.add(bbt);

		bbt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bbt) {
			fe.dispose();
		}
	}
}
