package CarOn;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BMWseach extends JFrame {
	String[] BMWS = { "3-Series", "5-Series", "7-Series", "X1", "X3", "X5", "X7", "iXSeries", "M1", };
	
//	JButton [] images = {  new JButton("image\\3Series.jpg"), 
//			new JButton("image\\5Series.jpg"),
//			new JButton("Image\\7Series.jpg"), new JButton("Image\\X1.jpg"), new JButton("Image\\X3.jpg"),
//			new JButton("Image\\X5.jpg"), new JButton("Image\\X7.jpg"), new JButton("Image\\iXSeries.jpg"),
//			new JButton("Image\\M1.jpg"), };
	JButton Btn1 = new JButton(new ImageIcon("image\\3Series.jpg"));
	JButton Btn2 = new JButton(new ImageIcon("image\\5Series.jpg"));
	JButton Btn3 = new JButton(new ImageIcon("image\\7Series.jpg"));
	JButton Btn4 = new JButton(new ImageIcon("image\\iXSeries.jpg"));
	JButton Btn5 = new JButton(new ImageIcon("image\\M1.jpg"));
	JButton Btn6 = new JButton(new ImageIcon("image\\X1.jpg"));
	JButton Btn7 = new JButton(new ImageIcon("image\\X3.jpg"));
	JButton Btn8 = new JButton(new ImageIcon("image\\X5.jpg"));
	JButton Btn9 = new JButton(new ImageIcon("image\\X7.jpg"));
	JLabel imgLabel = new JLabel();
	
	BMWseach() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setTitle("BMW"); // 타이틀
		setResizable(false); 
		
		
		setLocationRelativeTo(null);
		c.add(imgLabel);
		c.add(Btn1);
		c.add(Btn2);
		c.add(Btn3);
		c.add(Btn4);
		c.add(Btn5);
		c.add(Btn6);
		c.add(Btn7);
		c.add(Btn8);
		c.add(Btn9);
		
		Btn1.setPreferredSize(new Dimension(500, 150));
		Btn2.setPreferredSize(new Dimension(500, 150));
		Btn3.setPreferredSize(new Dimension(500, 150));
		Btn4.setPreferredSize(new Dimension(500, 150));
		Btn5.setPreferredSize(new Dimension(500, 150));
		Btn6.setPreferredSize(new Dimension(500, 150));
		Btn7.setPreferredSize(new Dimension(500, 150));
		Btn8.setPreferredSize(new Dimension(500, 150));
		Btn9.setPreferredSize(new Dimension(500, 150));
		//combo.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
				
//				imgLabel.setIcon(BMWS[index]);

//			}// end actionPerformed()
//		});// end combo.addActionListener
		
	Btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				new CarSeach();
		}
			});

		setBounds(30, 30, 1050, 950); // 윈도우 상에서 위치를 잡아 준 후(가로 50, 세로 50) 창의 크기를 설정합니다.(가로 400, 세로 400)
		setVisible(true);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CarSeach();
	}

}
