package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import dao.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;

public class Welcome {
	public void welcomeScreen() {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Welcome to FileHider");
		System.out.println("press 1 to login");
		System.out.println("press 2 to signup");
		System.out.println("press 0 to exit");
		int choice = 0;
		
		try {
			choice = Integer.parseInt(br.readLine());
		}
		catch (IOException e) {
			e.getStackTrace();
		}
		
		switch(choice) {
			case 1 : 
				login();
				break;
			case 2 : 
				signUp();
				break;
			case 0 :
				System.exit(0);
				break;
			default :
				System.out.println("Please select valid option");
		}		
	}
	
	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the userid / email");
		String email = sc.nextLine();
		try {
			if(UserDAO.isExists(email)) {
				String genOTP = GenerateOTP.getOtp();
				SendOTPService.sendOTP(email, genOTP);
				System.out.println("Enter the OTP");
				String otp = sc.nextLine();
				if(otp.equals(genOTP)) {
					UserView uv = new UserView(email);
					uv.home();
				} else {
					System.out.println("Incorrect OTP");
				}
			} else {
				System.out.println("User not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			sc.close();
		}
	}
	
	public  void signUp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter email");
		String email = sc.nextLine();
		
		String genOTP = GenerateOTP.getOtp();
		SendOTPService.sendOTP(email, genOTP);
		System.out.println("Enter the otp");
		String otp = sc.nextLine();
		if(otp.equals(genOTP)) {
			User user = new User(name,email);
			int response = UserService.saveUser(user);   //checks does user already exists or not
			switch(response) {
			case 0 : 
				System.out.println("User registered");
				break;
			case 1 :
				System.out.println("User already exist");
				break;
			}
		}
		
		sc.close();
	}
	
		
}
