package Member;



public class MemberVO {
	String Name;
	String id;
	String Address;
	String password;
	String password2;
	String Email;

	public MemberVO() {

	}

	public MemberVO(String Name, String id, String Address, String password, String password2, String Email) {
		this.Name = Name;
		this.id = id;
		this.Address = Address;
		this.password = password;
		this.password2 = password2;
		this.Email = Email;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	
	
}
