package com.lti.app;

import java.util.Scanner;

import com.lti.bean.SemesterRegistration;
import com.lti.bean.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.StudentNotRegisteredException;
import com.lti.exception.UserNotFoundException;
import com.lti.service.AdminService;
import com.lti.service.AdminServiceOperation;
import com.lti.service.PasswordService;
import com.lti.service.PasswordServiceOperation;
import com.lti.service.UserService;

public class CRSMenuApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String username = "";
		String password = "";
		UserService userService = new UserService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("******************Welcome to the CRS Application*************");
		
		// Main menu selection loop
		while(true) {
			
			System.out.println("\nEnter selection: ");
			System.out.println("1. Login");
			System.out.println("2. Student Registration");
			System.out.println("3. Update Password");
			System.out.println("4. Exit");
			System.out.print("\n-> ");
			
			String selection = scan.nextLine();
			if(selection == "" || selection == null || selection.equals(null)) {
				selection = scan.nextLine();
			}
			
			Boolean exit = false;
			
			// input clean-up
			selection = selection
					.toLowerCase()
					.replaceAll("^\\s+", "")
					.replaceAll("\\s+$", "");
			
			switch(selection) {
				case "1": 
					selection = "login"; 
					break;
				case "2": 
					selection = "student registration"; 
					break;
				case "3": 
					selection = "update password"; 
					break;
				case "4": 
					selection = "exit"; 
					break;
				default: break;
			}
			
			switch(selection) {
				case "login":
					
					System.out.print("\nEnter Username: ");
					username = scan.next();
					
					System.out.print("Enter Password: ");
					password = scan.next();		
					
					// validate login
					User user = null;
					try {
						user = userService.Login(username, password);
					} catch (UserNotFoundException e) {
						break;
					} catch (IncorrectPasswordException e) {
						break;
					} catch(SemesterRegistrationNotApprovedException e) {
						break;
					} catch(StudentNotRegisteredException e) {
						break;
					}
					
					// menus
					CRSStudentMenu studentMenu = new CRSStudentMenu(scan, user);
					CRSProfessorMenu professorMenu = new CRSProfessorMenu(scan, user);
					CRSAdminMenu adminMenu = new CRSAdminMenu(scan);					
					
					// Role Selection Loop
					while(true) {
					
						System.out.println("\nEnter Role: ");
						System.out.println("1. Student");
						System.out.println("2. Professor");
						System.out.println("3. Admin");
						System.out.println("4. Back");
						System.out.print("\n-> ");
						String role = scan.next();
						
						role = role
								.toLowerCase()
								.replaceAll("^\\s+", "")
								.replaceAll("\\s+$", "");
						
						switch(role) {
							case "1": 
								role = "student";
								break;
							case "2": 
								role = "professor";
								break;
							case "3": 
								role = "admin";
								break;
							case "4": 
								role = "back";
								break;
						}
						
						Boolean role_back = false;
						switch(role.toLowerCase()) {
							case "student": 								
								studentMenu.menu();
								break;			
							case "professor": 
								professorMenu.menu();
								break;		
							case "admin": 
								adminMenu.menu();
								break;					
							case "back":
								role_back = true;
								break;
							default:
								System.out.println("Please make another selection, role not found\n");
								continue;
						}
						if(role_back) break;  // exit out of role while loop
					}	
					break;  	// login switch case
				case "student registration": 
					
					AdminServiceOperation admin = new AdminService();
					System.out.println("Enter Student ID: ");
					int studentId = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Admin ID: ");
					int adminId = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Comments: ");
					String comments = scan.nextLine();
					SemesterRegistration semesterRegistration = new SemesterRegistration(studentId, adminId, false, comments);
					admin.createStudentRegistration(semesterRegistration);
					break;
				case "update password": 
					
					System.out.print("Enter UserName: ");
					String userName = scan.nextLine();

					System.out.print("Enter current password: ");
					String currentPassword = scan.nextLine();

					//save new password
					PasswordServiceOperation passwordSerive = new PasswordService();
					User userForPasswordUpdate = null;
					try {
					userForPasswordUpdate = passwordSerive.validateUser(userName, currentPassword);
					} catch (UserNotFoundException e) {
					e.printStackTrace();
					} catch (IncorrectPasswordException e) {
					e.printStackTrace();
					}

					if (userForPasswordUpdate != null) {
					System.out.print("Enter new password: ");
					String newPassword = scan.nextLine();
					passwordSerive.updatePassword(userName, newPassword);
					}
					break;
				case "exit": 
					exit = true;
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Please make another selection, option not found\n");
					continue;
			}
			
			if(exit) break;    // exit out of main menu loop
		}
		
		userService.Logout(username);
		System.out.println("\nEnd of program");	
	}
}
