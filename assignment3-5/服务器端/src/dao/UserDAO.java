package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.StudentInfo;
import teacher.TeacherInfo;
import util.DBUtil;

public class UserDAO {
	
	public boolean queryStudent(StudentInfo s){
		Connection conn = DBUtil.getConn();
		String sql="select * from student where sno=? and spassword=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUserid());
			ps.setString(2, s.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String name=rs.getString("sname");
				String sex=rs.getString("ssex");
				String Tel=rs.getString("stel");
				String school=rs.getString("sschool");
				String department=rs.getString("sdepartment");
				System.out.println(name+"-"+Tel);
				s.setUsername(name);
				s.setTel(Tel);
				s.setSex(sex);
				s.setSchool(school);
				s.setDepartment(department);
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeConn();
		}
		
	}
	public boolean newStudent(StudentInfo s){
		Connection conn = DBUtil.getConn();
		
		String sql="insert into student(sno,sname,spassword,ssex,stel,sschool,sdepartment) values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUserid());
			ps.setString(2, s.getUsername());
			ps.setString(3, s.getPassword());
			ps.setString(4, s.getSex());
			ps.setString(5, s.getTel());
			ps.setString(6, s.getSchool());
			ps.setString(7, s.getDepartment());
			int i=ps.executeUpdate();
		    if(i==1){
		    	return true;
		    }
		    else{
		    	return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeConn();
		}
		
	}
	
	public boolean queryTeacher(TeacherInfo t){
		Connection conn = DBUtil.getConn();
		String sql="select * from teacher where tno=? and tpassword=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUserid());
			ps.setString(2, t.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String name=rs.getString("tname");
				String sex=rs.getString("tsex");
				String Tel=rs.getString("ttel");
				String school=rs.getString("tschool");
				String department=rs.getString("tdepartment");
				System.out.println(name+"-"+Tel);
				t.setUsername(name);
				t.setTel(Tel);
				t.setSex(sex);
				t.setSchool(school);
				t.setDepartment(department);
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeConn();
		}
		
	}
	
	public boolean newTeacher(TeacherInfo t){
		Connection conn = DBUtil.getConn();
		
		String sql="insert into teacher(tno,tname,tpassword,tsex,ttel,tschool,tdepartment) values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUserid());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getSex());
			ps.setString(5, t.getTel());
			ps.setString(6, t.getSchool());
			ps.setString(7, t.getDepartment());
			int i=ps.executeUpdate();
		    if(i==1){
		    	return true;
		    }
		    else{
		    	return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeConn();
		}
		
	}
	
	public boolean joinxiaozu(String kename,String xuehao,String zuhao)
	{
		Connection conn = DBUtil.getConn();
		String sql="insert into groupmembers(kename,zuhao,xuehao) values(?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kename);
			ps.setString(2, zuhao);
			ps.setString(3, xuehao);
			//ResultSet rs = ps.executeUpdate();
			int i=ps.executeUpdate();
		    if(i==1){
		    	return true;
		    }
		    else{
		    	return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeConn();
		}	
	}
	
}
