package CarOn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CarSeach extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JTable table;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarSeach frame = new CarSeach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CarSeach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "차량정보 검색하기",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 10, 633, 57);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("차량검색");
		lblNewLabel.setBounds(6, 22, 57, 15);
		panel.add(lblNewLabel);

		textArea = new JTextArea();
		textArea.setBounds(63, 17, 455, 24);
		panel.add(textArea);

		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ버튼 코딩ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				String strEname = textArea.getText();
				if (table != null) {
					if (strEname.length() < 2) {
						JOptionPane.showMessageDialog(CarSeach.this, "2자 이상 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
					} else {

					}
				}
			}
		});
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ버튼 코딩ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		btnNewButton.setBounds(530, 18, 97, 23);
		panel.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 78, 621, 380);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}
}