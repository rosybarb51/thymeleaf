package study.dto;

public class Member {
	private String name;
	private String email;
	private String tel;
	private String address;
	
	public Member() {
		this("홍길동", "asdf@gmail.com", "010-123-4567", "서울");
	}
	
	public Member(String name, String email, String tel, String address) {
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.address = address;
	}
	
//	lombok을 안 써서 내가 source 의 generate getter/setter 해서 넣어줌
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
