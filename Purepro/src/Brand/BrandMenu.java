package Brand;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class BrandMenu extends JFrame implements ActionListener {
	JButton BMW = new JButton(new ImageIcon("image\\bmw.png"));
	JButton BENZ = new JButton(new ImageIcon("image\\Benz.png"));
	JButton AUDI = new JButton(new ImageIcon("image\\Audi.png"));
	JButton Hyundai = new JButton(new ImageIcon("image\\Hyundai.png"));
	JButton Kia = new JButton(new ImageIcon("image\\kia.png"));
	JButton Chevrolet = new JButton(new ImageIcon("image\\Chevrolet.png"));
	JButton Volvo = new JButton(new ImageIcon("image\\Volvo.png"));
	JButton Polestar = new JButton(new ImageIcon("image\\pollstar.png"));
	JButton Genesis = new JButton(new ImageIcon("image\\Genesis.png"));
	JButton Tesla = new JButton(new ImageIcon("image\\Tesla.png"));
	JButton Volkswagen = new JButton(new ImageIcon("image\\Volkswagen.png"));
	JButton Peugeot = new JButton(new ImageIcon("image\\Peugeot.png"));
	
	private static final long serialVersionUID = 1L;
	JTextField jtf = new JTextField();
	JPanel pn1;
//	JButton b2, b3;// b4; b5, b6, b7, b8, b9, b10, b11, b12, b13, b14;

	public BrandMenu() {
		super("선택창");// JFrame 생성자 호출
		setLayout(new GridLayout(4, 6));
		setSize(1230, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		

		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기

		// -- 컴포넌트 생성 --
		

		setVisible(true);
		setLocationRelativeTo(null);
		add(BMW);
		add(BENZ);
		add(AUDI);
		add(Hyundai);
		add(Kia);
		add(Chevrolet);
		add(Volvo);
		add(Polestar);
		add(Genesis);
		add(Tesla);
		add(Volkswagen);
		add(Peugeot);
		
		AUDI.addActionListener(this);
		BENZ.addActionListener(this);
		BMW.addActionListener(this);
		Chevrolet.addActionListener(this);
		Genesis.addActionListener(this);
		Hyundai.addActionListener(this);
		Kia.addActionListener(this);
		Peugeot.addActionListener(this);
		Polestar.addActionListener(this);
		Tesla.addActionListener(this);
		Volkswagen.addActionListener(this);
		Volvo.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==BMW) {
			new BMW();
		} 
		if(e.getSource() == BENZ) {
			new Benz();	
		}
		if(e.getSource() == AUDI) {
			new Audi();
		}
		if(e.getSource() == Chevrolet) {
			new Chevrolet();
		}
		if(e.getSource() == Genesis) {
			new Genesis();
		}
		if(e.getSource() == Hyundai) {
			new Hyundai();
		}
		if(e.getSource() == Kia) {
			new Kia();
		}
		if(e.getSource() == Peugeot) {
			new Peugeot();
		}
		if(e.getSource() == Polestar) {
			new Polestar();
		}
		if(e.getSource() == Tesla) {
			new Tesla();
		}
		if(e.getSource() == Volkswagen) {
			new Volkswagen();
		}
		if(e.getSource() == Volvo) {
			new Volvo();
		}
	}

	public static void main(String[] args) {
		new BrandMenu();
		
		
	}
}
