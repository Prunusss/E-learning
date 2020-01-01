package service;

import student.StudentInfo;
import teacher.TeacherInfo;
import dao.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
 
public class UserService {
	
	UserDAO userDAO = new UserDAO();
	public boolean login_s(StudentInfo s) {
		System.out.println("login");
		return userDAO.queryStudent(s);
	}
	public boolean login_t(TeacherInfo t) {
		System.out.println("login");
		return userDAO.queryTeacher(t);
	}
	public boolean joinxiaozu(String kename,String xuehao,String zuhao){
		System.out.println("register");
		return userDAO.joinxiaozu(kename,xuehao,zuhao);
	}
	public boolean register_s(StudentInfo s) {
		return userDAO.newStudent(s);
	}
	public boolean register_t(TeacherInfo t) {
		return userDAO.newTeacher(t);
	}
	 
	
}