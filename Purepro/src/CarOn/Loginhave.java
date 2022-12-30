package CarOn;
// 로그인 클래스
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Loginhave extends JFrame {

	private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("아이디 ");
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	private JButton idpwJoinBtn = new JButton("회원가입");


	public Loginhave() {

		super("System Login");
		this.setContentPane(loginPanel);

		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(idpwJoinBtn);
		loginPanel.add(loginBtn);

//라벨 가운데 정렬

		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);
		setResizable(false);

//현재 프레임 창 가운데 정렬 setSize를 먼저 해주어야 정상적으로 프레임이 가운데 정렬이 됨!

		setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//로그인 버튼을 눌렀을때

		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//아이디 비번 확인 테스트 코드~

				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if (id.length() == 0 || pw.length() == 0) {

					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디&비번 입력",
							JOptionPane.DEFAULT_OPTION);
					return;
				} else {
				}

				if (id.equals("test") && pw.equals("test1")) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
					loginPanel.setVisible(false);
					new Windowin2();
					dispose();
					return;
				}
				JOptionPane.showMessageDialog(null, "로그인 실패", "ID,비밀번호 재확인!", JOptionPane.DEFAULT_OPTION);
				
			}

		});

//회원가입 버튼을 눌렀을때

		idpwJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "회원가입", "회원System", JOptionPane.DEFAULT_OPTION);
				new Windowin();
				dispose();
			}
		});
	}
	public static void main(String[] args) {
		new Loginhave();
		
	}
}