package model;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String nickname;
	private String email;
	private String phone;
	private String addr;
	private int point;
	private int type;
	
	public Member() {}
	public Member(String id, String pwd, String name, String nickname, String email, String phone, String addr,
			int point, int type) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.point = point;
		this.type = type;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickname=" + nickname + ", email=" + email
				+ ", phone=" + phone + ", addr=" + addr + ", point=" + point + ", type=" + type + "]";
	}
	
	
	
	
	
}
