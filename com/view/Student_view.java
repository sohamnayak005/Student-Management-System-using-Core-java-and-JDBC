package com.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.controller.Student_Controller;
import com.model.Student;
public class Student_view {
	static Student_Controller controller=new Student_Controller();
	static Scanner sc=new Scanner(System.in);
	
	// UPDATE METHOD OF VIEW CLASS
	public static void updateStudentObject(int id) {
		System.out.println("Press 1 to Update your Name");
		System.out.println("Press 2 to Update your Email Id");
		System.out.println("Press 3 to Update your Password");
		System.out.println("Press 4 to Update your Gender");
		System.out.println("Press 5 to Update your Mobile No");
		System.out.println("Press 6 to Update your Date of Birth");
		System.out.println("Enter Your Choice ");
		int ch=sc.nextInt();
		int result=0;
		switch (ch) {
		case 1:
			// update name
			 System.out.println("Enter Your New Name: ");
			 sc.nextLine();
			 String name=sc.nextLine();
			 result=controller.updateName(id, name,"name");
			break;
		case 2:
			// update email
			 System.out.println("Enter Your New Email Id: ");
			 sc.nextLine();
			 String email=sc.nextLine();
			 result=controller.updateName(id,email,"email");
			break;
		case 3:
			// update password
			 System.out.println("Enter Your New Password: ");
			 sc.nextLine();
			 String password=sc.nextLine();
			 result=controller.updateName(id, password,"password");
			break;
		case 4:
			// update gender
			 System.out.println("Enter Your New Gender: ");
			 sc.nextLine();
			 String gender=sc.nextLine();
			 result=controller.updateName(id, gender,"gender");
			break;
		case 5:
			// update mobile
			 System.out.println("Enter Your New Mobile: ");
			 long mob=sc.nextLong();
			 String mobile=Long.toString(mob);
			 result=controller.updateName(id, mobile,"mobile");
			break;
		case 6:
			// update DOB
			 System.out.println("Enter Your New DOB(dd-mm-yyyy): ");
			 sc.nextLine();
			 String dob=sc.nextLine();
			 result=controller.updateName(id, dob,"dob");
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		if(result!=0)
		System.out.println("Record Updated Successfully!");
		else {
			System.out.println("Record not update try again!");
		}
	}
	
	// INSERT METHOD OF VIEW CLASS
	public static Student getStudentObject() {
		//Student id 
		System.out.println("Enter The Id: ");
		int id=sc.nextInt();
		//Student name
		System.out.println("Enter the name: ");
		sc.nextLine();
		String name=sc.nextLine();
		//Student email
		System.out.println("Enter The Email Id: ");
		String email=sc.nextLine();
		//Student password
		System.out.println("Enter Student Password: ");
	    String password =sc.nextLine();
	    //Student Gender
	    System.out.println("Enter The Gender: ");
		String gender=sc.nextLine();
		//Student Mobile no
		System.out.println("Enter Mobile Number: ");
		long mob=sc.nextLong();
        //Student DOB
		System.out.println("Enter The Date of Birth(DD-MM-YYYY): ");
		sc.nextLine();
		String dob=sc.nextLine();
		
		// Create the Object of Student class because here i am setting the value
		Student s=new Student();
		// here i am setting id
		s.setId(id);
		// here i am setting name
		s.setName(name);
		// here i am setting email
		s.setEmail(email);
		// here i am setting password
		s.setPassword(password);
		// here i am setting gender
		s.setGender(gender);
		// here i am setting mobile no
		s.setMob(mob);
		// here i am set DOB
		s.setDob(dob);
		//here i return the student object
		return s;
		
	}
    public static void main(String[] args) {
		System.out.println("Welcome to Student Portal.....");
		
		// HERE WE ARE CHOOICE THE OPTION
		while(true) {
			System.out.println("1.Save Student");
			System.out.println("2.Find the Student By Id");
			System.out.println("3.Update the Student By Id");
			System.out.println("4.Delete the Student BY Id");
			System.out.println("5.Find All");
			System.out.println("6.Exit");
			System.out.println("Enter Your Choice: ");
			int choice=sc.nextInt();
		    switch (choice) {
			case 1:
				// Save the student Details
				Student student=getStudentObject();
				int isSave=controller.saveStudent(student);
				if(isSave!=0) {
					System.out.println("🙂 Record is Store Successfull in the Data Base 🙂");
				}
				else {
					System.out.println("Data is not Store some issue please try again 😒!");
				}
				break;
			case 2:
				// Find By Id
				System.out.print("Enter your id: ");
				int findId=sc.nextInt();
				ResultSet rs=controller.findById(findId);
				try {
					if(rs.next()) {
						System.out.println("======================================================================================================================================");
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getLong(6)+" "+rs.getString(7));
						System.out.println("======================================================================================================================================");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				// Update student details
				System.out.print("Enter your id: ");
				int find=sc.nextInt();
				ResultSet findResult=controller.findById(find);
				try {
					if(findResult.next()==true) {
						updateStudentObject(find);
						
				    } 
					else {
						System.out.println("No Record Found");
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				// Delete By Id
	            System.out.println("Enter id you want to delete");
	            int delId=sc.nextInt();
	            int delResult=controller.deleteById(delId);
	            if(delResult!=0) {
	            	System.out.println("Record Deleted Successfully!");
	            }
	            else {
	            	System.out.println("Record Not Found!");
	            }
				break;
			case 5:
				// Fetch All The record
				ResultSet resultAll=controller.findAll();
				ResultSet copyResult=resultAll;
				try {
				if(copyResult.next()!=false) {
				
					while(resultAll.next()) {
						System.out.println("======================================================================================================================================");
						System.out.println(resultAll.getInt(1)+" "+resultAll.getString(2)+" "+resultAll.getString(3)+" "+resultAll.getString(4)+" "+resultAll.getString(5)+" "+resultAll.getLong(6)+" "+resultAll.getString(7));
						System.out.println("======================================================================================================================================");
					}
				}
				else {
					System.out.println("Data Base Empty!");
				}
				}
				 catch (SQLException e) {
						e.printStackTrace();
					}
				break;
				case 6:
				System.out.println("Thank You...");
			    return;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
	
}
