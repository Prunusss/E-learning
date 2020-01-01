package teacher;

public class TeacherInfo {
	private String userid;
	private String username;
	private String password;
	private String tel;
	private String sex;
	private String school;
	private String department;
	//ѧ��
	
	
	public TeacherInfo(){
		
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	//����
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//����
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//�Ա�
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/*
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	*/
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSchool(){
		return this.school;
	}
	public void setSchool(String school){
		this.school=school;
	}
	public String getDepartment(){
		return this.department;
	}
	public void setDepartment(String department){
		this.department=department;
	}
}
