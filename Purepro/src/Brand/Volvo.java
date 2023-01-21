package Brand;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class Volvo extends WindowAdapter implements ActionListener {
	private JFrame frame;
	private int index;
	private JTextArea Area = new JTextArea();

	private String[] images = { "image/c40.png", "image/xc40.png",
			};
	
	public Volvo() {
		ArrayList<CarDTO> arr = new ArrayList<CarDTO>();
		arr = VolvoF();
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 800);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);
		getFrame().setResizable(false);
		getFrame().setVisible(true);

		Font font = new Font("굴림", Font.BOLD, 48);

		JLabel lblImage = new JLabel();
		lblImage.setBounds(0, 0, 980, 370);

		Area = new JTextArea();
		Area.setBounds(0, 400, 800, 240);
		Area.setFocusable(false);
		Area.setFont(new Font("Gothic", Font.BOLD, 20));

		getFrame().add(Area);

		lblImage.setIcon(new ImageIcon(images[getIndex()])); // index 처음 0, IMAGES[0] 랑 결과 같음
		getFrame().getContentPane().add(lblImage);
		Area.append("  넘버: " + arr.get(getIndex()).getNo() + "\n" + "  모델: " + arr.get(getIndex()).getModel() + "\n"
				+ "  가격:" + arr.get(getIndex()).getPrice() + "\n" + "  차량타입: " + arr.get(getIndex()).getType() + "\n"
				+ "  배터리용량:" + arr.get(getIndex()).getBcapacity() + "\n" + "  마력:" + arr.get(getIndex()).getPower()
				+ "\n" + "  연비:" + arr.get(getIndex()).getMileage() + "\n" + "  1회 충전주행거리:"
				+ arr.get(getIndex()).getMaxdistance() + "\n");

// frame 안에 이미지추가

		JButton btnPrev = new JButton("←");
		btnPrev.setBackground(Color.CYAN);
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<CarDTO> arr = new ArrayList<CarDTO>();
				arr = VolvoF();
				if (getIndex() > 0) { // 현재 인덱스가 0보다 크면
					setIndex(getIndex() - 1); // 인덱스를 감소
					Area.setText(null);
					Area.append("  넘버: " + arr.get(getIndex()).getNo() + "\n" + "  모델: "
							+ arr.get(getIndex()).getModel() + "\n" + "  가격:" + arr.get(getIndex()).getPrice() + "\n"
							+ "  차량타입: " + arr.get(getIndex()).getType() + "\n" + "  배터리용량:"
							+ arr.get(getIndex()).getBcapacity() + "\n" + "  마력:" + arr.get(getIndex()).getPower()
							+ "\n" + "  연비:" + arr.get(getIndex()).getMileage() + "\n" + "  1회 충전주행거리:"
							+ arr.get(getIndex()).getMaxdistance() + "\n");
				} else { // 현재 인덱스가 0이면
					setIndex(images.length - 1); // 배열의 가장 큰 인덱스 번호로 변경
					if (getIndex() == 6) {
						Area.setText(null);
						Area.append("  넘버: " + arr.get(getIndex()).getNo() + "\n" + "  모델: "
								+ arr.get(getIndex()).getModel() + "\n" + "  가격:" + arr.get(getIndex()).getPrice()
								+ "\n" + "  차량타입: " + arr.get(getIndex()).getType() + "\n" + "  배터리용량:"
								+ arr.get(getIndex()).getBcapacity() + "\n" + "  마력:" + arr.get(getIndex()).getPower()
								+ "\n" + "  연비:" + arr.get(getIndex()).getMileage() + "\n" + "  1회 충전주행거리:"
								+ arr.get(getIndex()).getMaxdistance() + "\n");
					}
				}
				lblImage.setIcon(new ImageIcon(images[getIndex()])); // 버튼 누를때마다 다음 이미지로 이동
			}

		});
		btnPrev.setFont(font);
		btnPrev.setBounds(10, 665, 200, 80);
		getFrame().getContentPane().add(btnPrev);

		JButton logo = new JButton(new ImageIcon("image\\볼보로고.jpg"));
		logo.setBackground(Color.WHITE);
		logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		logo.setFont(font);
		logo.setBounds(275, 645, 200, 117);
		getFrame().getContentPane().add(logo);


		JButton btnNext = new JButton("→");
		btnNext.setBackground(Color.CYAN);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<CarDTO> arr = new ArrayList<CarDTO>();
				arr = VolvoF();
				if (getIndex() < images.length - 1) { // 마지막 인덱스보다 작은 경우
					setIndex(getIndex() + 1); // 인덱스 증가
					Area.setText(null);

					Area.append("  넘버: " + arr.get(getIndex()).getNo() + "\n" + "  모델: "
							+ arr.get(getIndex()).getModel() + "\n" + "  가격:" + arr.get(getIndex()).getPrice() + "\n"
							+ "  차량타입: " + arr.get(getIndex()).getType() + "\n" + "  배터리용량:"
							+ arr.get(getIndex()).getBcapacity() + "\n" + "  마력:" + arr.get(getIndex()).getPower()
							+ "\n" + "  연비:" + arr.get(getIndex()).getMileage() + "\n" + "  1회 충전주행거리:"
							+ arr.get(getIndex()).getMaxdistance() + "\n");

				} else { // 현 인덱스가 문자열의 길이가 -1이 되는 경우
					setIndex(0); // 인덱스를 0으로 초기화(0번으로 변경)
					if (getIndex() == 0) {
						Area.setText(null);
						Area.append("  넘버: " + arr.get(getIndex()).getNo() + "\n" + "  모델: "
								+ arr.get(getIndex()).getModel() + "\n" + "  가격:" + arr.get(getIndex()).getPrice()
								+ "\n" + "  차량타입: " + arr.get(getIndex()).getType() + "\n" + "  배터리용량:"
								+ arr.get(getIndex()).getBcapacity() + "\n" + "  마력:" + arr.get(getIndex()).getPower()
								+ "\n" + "  연비:" + arr.get(getIndex()).getMileage() + "\n" + "  1회 충전주행거리:"
								+ arr.get(getIndex()).getMaxdistance() + "\n");
					}
				}

				lblImage.setIcon(new ImageIcon(images[getIndex()]));

			}

		});
		btnNext.setFont(font);
		btnNext.setBounds(570, 665, 200, 80);
		getFrame().getContentPane().add(btnNext);

	}

	public void startFrame() {

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@SuppressWarnings("finally")
	public ArrayList<CarDTO> VolvoF() {
		Connection conn = new DBConnection_maria().getConnection();

		ArrayList<CarDTO> list = new ArrayList<CarDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = DBConnection_maria.getConnection();

			StringBuffer sql = new StringBuffer();

			sql.append(
					"select NO, BRAND, MODEL, PRICE, TYPE, BCAPACITY, POWER, MILEAGE, MAXDISTANCE from CAR where Brand = 'Volvo' ");

			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery(); // 쿼리 실행
			while (rs.next()) {
				int index = 1;
				int No = rs.getInt(index++);
				String Brand = rs.getString(index++);
				String Model = rs.getString(index++);
				String Price = rs.getString(index++);
				String Type = rs.getString(index++);
				String Bcapacity = rs.getString(index++);
				String Power = rs.getString(index++);
				String Mileage = rs.getString(index++);
				String Maxdistance = rs.getString(index++);

				list.add(new CarDTO(No, Brand, Model, Price, Type, Bcapacity, Power, Mileage, Maxdistance));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
			return list;
		}

	} // AudiF 메소드 끝

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

} // 클래스 끝}