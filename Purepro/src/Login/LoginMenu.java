package Login;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Brand.BrandMenu;
import Member.Signup;

public class LoginMenu extends WindowAdapter implements ActionListener {
	private Frame f; //프레임 객체 
	private Frame subf; // 로그인 성공 서브 프레임
	private Frame nof; // 로그인실패 프레임	
	private Label lid; // 아이디 라벨 객체
	private Label lpwd; // 비밀번호 라벨 객체 
	private Panel p;  
	private Panel p2;
	
	private TextField id;
	private TextField pwd;
	private Label lsulog;
	private JButton btnProf;
	private Button fafout1;
	private Button log;
	private Button signup;
	private String myid;
	private String mypwd;
	private JLabel fafout;
	
	public LoginMenu() {
		//로그인 화면
		f = new Frame("Login");
		f.setSize(370,150);
		f.setBackground(Color.CYAN);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
	
		//로그인 성공 화면
		subf = new Frame("로그인 성공");
		subf.setFont(new Font("Gothic", Font.BOLD,30));
		subf.setSize(500, 100);
		subf.setLocationRelativeTo(null);
		subf.setResizable(false);
		
		//로그인 실패 화면 
		nof = new Frame("로그인 실패");
		nof.setLayout(null);
		nof.setSize(450, 200);
		nof.setBackground(Color.WHITE);
		nof.setResizable(false);
		nof.setLocationRelativeTo(null);
		
		fafout = new JLabel("비밀번호가 틀렸습니다");
		fafout.setLayout(null);
		fafout.setBounds(135, 40, 220, 100);
		fafout.setFont(new Font("Gothic", Font.BOLD,20));
		fafout.setVisible(true);
		
		
		nof.add(fafout);
		
		fafout1 = new Button("로그인 창으로 돌아가기");
		fafout1.setBounds(135, 140, 180, 30);
		fafout1.setBackground(Color.CYAN);
		fafout1.setFont(new Font("Gothic", Font.BOLD, 15));
		nof.add(fafout1);

		fafout1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nof.setVisible(false);
				LoginMenu lg = new LoginMenu();
				lg.startframe();
			}

		});
		
	
		
		p = new Panel();
		p2 = new Panel();
		lid = new Label("  	아이디: ", Label.RIGHT);
		lpwd = new Label("비밀번호: ", Label.RIGHT);

		id = new TextField(25);
		pwd = new TextField(25);
		log = new Button("로그인");
		log.setBounds(100,100,20,20);
		log.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				nof.setVisible(false);

			}

		});
		
		signup = new Button("회원가입");
		lsulog = new Label("로그인 성공");
		btnProf = new JButton("브랜드메뉴창 이동");
		btnProf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BrandMenu();
			}
		});
	}
	//private JButton addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		//return null;
	//}
	public void startframe() {
		
		f.add(p, "Center");
		f.addWindowListener(this);
		log.addActionListener(this);
		signup.addActionListener(this);
		subf.addWindowListener(this);
		nof.addWindowListener(this);

		btnProf.addActionListener(this);
		pwd.setEchoChar('*');

		subf.add(p2, "Center");
		p2.add(lsulog);

		p2.add(btnProf);

		p.add(lid);
		p.add(id);
		p.add(lpwd);
		p.add(pwd);
		p.add(log);
		p.add(signup);
		f.setVisible(true);
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("로그인")){
			LoginDAO dao = new LoginDAO();
			LoginVo data = dao.list(id.getText(), pwd.getText());
				myid = data.getId();
				mypwd = data.getPwd();
			System.out.println(myid);
			System.out.println(mypwd);
			if(id.getText().equals(myid) && pwd.getText().equals(mypwd)) {
				subf.setVisible(true);		
			}else {
				nof.setVisible(true);
				f.setVisible(false);
			}
		}

		if (e.getActionCommand().equals("회원가입")) {
			Signup sg = new Signup();
			sg.startframe();
			f.setVisible(false);
		}

		if (btnProf.equals(e.getSource())) {
			subf.setVisible(false);
			f.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		LoginMenu lm = new LoginMenu();
		lm.startframe();
		
	}
}