import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Staff {
	public String lastname;
	public String firstname;
	public int facilityid;
	public String dob;
	public String doornumber;
	public String streetname;
	public String city;
	public String country;
	public String phonenumber;
	public int choice;
	
    public void runStaffMenu() {
        	printStaffMenu();
            this.choice = getSignUpData();
            if(this.choice == 1) {
            	if(validateSignUpData()) {
            		performSignUpAction();
                	System.out.println("Sign up Successful... Going to Sign In Page");
                	System.out.println("**************\n*Sign in Page*\n**************");
                	SignIn s = new SignIn();
                	s.runSignIn();
            	}
            	else {
            		System.out.println("Sign Up Incorrect..\nPlease Enter Again");
            		runStaffMenu();
            	}
            }
            if(this.choice == 2) {
            	MainMenu menu = new MainMenu();
                menu.runMenu();
            }
            

    }

    public boolean validateSignUpData() {
    /*	try {
    		Connection conn = JDBC.getConnection();
            Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("EXEC ValidSignUpData"+ this.lastname+","+this.dob+","+this.city);
    		while (rs.next()) {
    		    int s = rs.getInt("Facility_ID");
    		    String n = rs.getString("Facility_Name");
    		    System.out.println(s + "   " + n);
    		}
            rs.close();
            stmt.close();
            conn.close();
            } catch(Throwable oops) {
                oops.printStackTrace();
            }*/
		return true;
		
	}

	public void printStaffMenu() {
        System.out.print("Please enter following details: ");
    }	
    
    public int getSignUpData() {
    	try {
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("Enter First name: ");
            this.firstname = keyboard.nextLine(); 
            System.out.print("Enter Last name: ");
            this.lastname = keyboard.nextLine(); 
            System.out.print("Enter Date of Birth: ");
            this.dob = keyboard.nextLine(); 
            System.out.print("Enter DoorNumber: ");
            this.doornumber = keyboard.nextLine(); 
            System.out.print("Enter Streetname: ");
            this.streetname = keyboard.nextLine(); 
            System.out.print("Enter City: ");
            this.city = keyboard.nextLine(); 
            System.out.print("Enter Country: ");
            this.country = keyboard.nextLine(); 
            System.out.print("Enter Phone number: ");
            this.phonenumber = keyboard.nextLine(); 
            System.out.print("Enter 1)Sign-Up 2)Go Back\nchoice:");
            this.choice = Integer.parseInt(keyboard.nextLine()); 
            
            if (choice < 1 || choice > 2) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 1 || choice > 2);
    	}
    	catch(Exception e) {
    		System.out.print("Error in SignUp data....\n"+e);
    	}
        return choice;
    }
       
    public void performSignUpAction() {
       	try {
		Connection conn = JDBC.getConnection();
        Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into XX_PATIENT_T (FIRSTNAME,LASTNAME,PATIENTID,PHONE,DOB,DOORNO,STREETNAME,CITYNAME) values('"+ this.firstname+"','"+ this.lastname+"','gdsfw','"+this.phonenumber+"','"+this.dob+"','"+ this.doornumber+"','"+this.streetname+"','"+this.city+"')");
        stmt.close();
        conn.close();
        } catch(Throwable oops) {
            oops.printStackTrace();
        }

    }

}

