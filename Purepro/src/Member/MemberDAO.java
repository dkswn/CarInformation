package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "GREEN1234";

	private Connection conn; // DB와 연결된 객체
	private Statement stmt; // SQL문을 담는 객체
	private ResultSet rs; // SQL문 결과를 담는객체
	PreparedStatement pstmt = null; // 명령

	public int addProfile(String Name, String id, String Address, String password, String password2, String Email) {

		int cnt = 0;

		try {
			connDB();
			String query = "INSERT INTO profile(name, id, address, password, password2, email) ";
			query += " VALUES('" + Name.toLowerCase() + "'";
			query += " ,'" + id.toLowerCase() + "'";
			query += " ,'" + Address.toLowerCase() + "'";
			query += " ,'" + password.toLowerCase() + "'";
			query += " ,'" + password2.toLowerCase() + "'";
			query += " ,'" + Email.toLowerCase() + "'";
			query += ")";

			System.out.println("SQL : " + query);
			cnt = stmt.executeUpdate(query);

			if (cnt == 1) {
				System.out.println("Join complete");

			} else {
				System.out.println("can not join");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "중복된 아이디입니다 다시 입력해주세요.", "아이디 오류", 1);

		}
		return cnt;

	}

	public void insertProFile(MemberVO vo) {
		try {
			conn = getConn();
			String sql = "INSERT INTO profile(name, id, address, password, password2, email) values(?, ?, ?, ?, ?, ?)";
			// PrparedStatment객체 생성, 인자로 sql문이 주어짐
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.Name);
			pstmt.setString(2, vo.id);
			pstmt.setString(3, vo.Address);
			pstmt.setString(4, vo.password);
			pstmt.setString(5, vo.password2);
			pstmt.setString(6, vo.Email);

			// executeUpdate : insert, delete, update와 같이 값을 받아오지 않는 쿼리문 실행
			pstmt.executeUpdate();
			Signup.add = true;
			JOptionPane.showMessageDialog(null, "회원 가입 완료!", "회원가입", 1);
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("SQL.error" + e.getMessage());
			JOptionPane.showMessageDialog(null, "아이디 중복!", "아이디 중복 오류", 1);
			Signup.add = false;
		} finally {
			dbClose();
		}
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("orcle connection success.");

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName(driver); // 1. 드라이버 로딩
			con = DriverManager.getConnection(url, user, password); // 2. 드라이버 연결

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}
}
