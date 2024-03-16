package com.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Student;
public class Student_Controller {
  //INSER RECORD METHOD OF CONTROLLER CLASS
  public int saveStudent(Student s) {
	  int n=0;
	  try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcmvc","postgres","root");
		PreparedStatement psmt=con.prepareStatement("insert into studentmvc values(?,?,?,?,?,?,?)");
		psmt.setInt(1,s.getId());
		psmt.setString(2,s.getName());
		psmt.setString(3,s.getEmail());
		psmt.setString(4,s.getPassword());
		psmt.setString(5,s.getGender());
		psmt.setLong(6,s.getMob());
		psmt.setString(7,s.getDob());
		n=psmt.executeUpdate();
		con.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return n; 
  }
  
 //FIND BY ID METHOD OF CONTROLLER CLASS
  public ResultSet findById(int id) {
	  ResultSet rs=null;
	  try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcmvc","postgres","root");
			PreparedStatement psmt=con.prepareStatement("select * from studentmvc where id=?");
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return rs;
  }
 //DELETE BT ID METHOD OF CONTROLLER CLASS
  public int deleteById(int id) {
	  int delres=0;
	  try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcmvc","postgres","root");
			PreparedStatement psmt=con.prepareStatement("delete from studentmvc where id=?");
			psmt.setInt(1, id);
			delres=psmt.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return delres;
  }
  //FIND ALL RECORD METHOD OF CONTROLLER CLASS
  public ResultSet findAll() {
	  ResultSet allRes=null;
	  try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcmvc","postgres","root");
			PreparedStatement psmt=con.prepareStatement("select * from studentmvc order by id");
			allRes=psmt.executeQuery();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  return allRes;
  }
 
  //UPDATE METHOD OF CONTOLLER CLASS
   public int updateName(int id,String value,String filedName) {
	   int result=0;
		  try {
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcmvc","postgres","root");
				PreparedStatement psmt=null;
				if(filedName.equals("name")) {
					psmt=con.prepareStatement("update studentmvc set name=? where id=?");
					psmt.setString(1,value);
					psmt.setInt(2,id);
				}
				else if(filedName.equals("email")) {
					psmt=con.prepareStatement("update studentmvc set email=? where id=?");
					psmt.setString(1,value);
					psmt.setInt(2,id);
				}
				else if(filedName.equals("password")) {
					psmt=con.prepareStatement("update studentmvc set password=? where id=?");
					psmt.setString(1,value);
					psmt.setInt(2,id);
				}
				else if(filedName.equals("gender")){
					psmt=con.prepareStatement("update studentmvc set gender=? where id=?");
					psmt.setString(1,value);
					psmt.setInt(2,id);
				}
				else if(filedName.equals("mobile")) {
					psmt=con.prepareStatement("update studentmvc set mob=? where id=?");
					long newValue=Long.parseLong(value);
					psmt.setLong(1,newValue);
					psmt.setInt(2,id);
				}
				else if(filedName.equals("dob")){
					psmt=con.prepareStatement("update studentmvc set dob=? where id=?");
					psmt.setString(1,value);
					psmt.setInt(2,id);
				}
				result=psmt.executeUpdate();
				con.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  return result;
   }
}
