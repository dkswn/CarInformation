package Member;

// 회원가입창
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Brand.BrandMenu;

public class Signup extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel lname;
	private JLabel lid;
	private JLabel lres;
	private JLabel lpwd;
	private JLabel lpwdch;
	private JLabel lemail;
	private JLabel title;

	private JTextField name;
	private JTextField id;
	private JTextField res;
	private TextField pwd;
	private TextField pwdch;
	private JTextField email;
	private JButton signup;

	private Font font1;
	private Font font2;
	public static boolean add;

	public Signup() {

		f = new JFrame("회원가입");
		p = new JPanel();
		p.setLayout(new GridLayout(6, 4));
		f.setResizable(false);

		title = new JLabel("계정생성");
		font1 = new Font("F", Font.BOLD, 14);
		font2 = new Font("F", Font.BOLD, 14);

		lname = new JLabel("Name : ", JLabel.RIGHT);
		lname.setFont(font1);
		lid = new JLabel("ID : ", JLabel.RIGHT);
		lid.setFont(font1);

		lres = new JLabel("주소 : ", JLabel.RIGHT);
		lres.setFont(font1);

		lpwd = new JLabel("비밀번호 : ", JLabel.RIGHT);
		lpwd.setFont(font1);
	

		lpwdch = new JLabel("비밀번호확인 : ", JLabel.RIGHT);
		lpwdch.setFont(font1);

		lemail = new JLabel("Email : ", JLabel.RIGHT);
		lemail.setFont(font1);

		name = new JTextField(30);
		name.setFont(font1);

		id = new JTextField(30);
		id.setFont(font1);

		res = new JTextField(30);
		res.setFont(font1);

		pwd = new TextField(30);
		pwd.setFont(font1);
		pwd.setEchoChar('*');

		pwdch = new TextField(30);
		pwdch.setFont(font1);
		pwdch.setEchoChar('*');

		email = new JTextField(30);

		email.setFont(font1);

		JLabel imgLbl = new JLabel();
		ImageIcon bsImg = new ImageIcon("image/Car1.png");

		imgLbl.setIcon(bsImg);

		imgLbl.setBounds(0, -10, 185, 280);
		imgLbl.setHorizontalAlignment(JLabel.CENTER);
		f.getContentPane().add(imgLbl);

		signup = new JButton("회원가입");
		signup.setFont(font2);
		signup.setBackground(Color.GRAY);

	}

	public void startframe() {
		f.setSize(600, 300);
		f.add(p, "Center");
		f.add(signup, "South");
		f.add(title, "North");
		f.setLocationRelativeTo(null);
		p.setBackground(Color.WHITE);
		title.setBackground(Color.WHITE);
		p.add(lname);
		p.add(name);
		p.add(lid);
		p.add(id);
		p.add(lres);
		p.add(res);
		p.add(lpwd);
		p.add(pwd);
		p.add(lpwdch);
		p.add(pwdch);
		p.add(lemail);
		p.add(email);
		
		f.setVisible(true);
		f.addWindowListener(this);
		signup.addActionListener(this);
		p.setVisible(true);
		

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signup) {
			MemberDAO dao = new MemberDAO();
			MemberVO mVO = new MemberVO();
			if(pwd.getText().equals(pwdch.getText())==true) {
				if (name.getText().isEmpty() == false && 
						id.getText().isEmpty() == false &&
						res.getText().isEmpty() == false && 
						pwd.getText().isEmpty() == false &&
						pwdch.getText().isEmpty() == false &&
						email.getText().isEmpty() == false) {
					String Name = name.getText();
					String Id = id.getText();
					String Address = res.getText();
					String Password = pwd.getText();
					String Password2 = pwdch.getText();
					String Email = email.getText();
					System.out.println(mVO.getName());
					add = false;
					dao.insertProFile(new MemberVO(Name,Id,Address,Password,Password2,Email));
					if(add == true) {
						new BrandMenu();
					}
				} else {
					new subFrame();

				}
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 제대로 입력해주셔야 합니다.", "비밀번호 오류", 1);
			}
			
		}
	}

	public static void main(String[] args) {
		new Signup();
	}

}
