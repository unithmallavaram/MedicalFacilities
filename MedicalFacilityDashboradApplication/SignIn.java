import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SignIn {
	public String lastname;
	public int facilityid;
	public String dob;
	public String city;
	public int choice;
	
    public void runSignIn() {
    		System.out.println("Please enter following details to sign in");
        	printSignInMenu();
            this.choice = getSignInData();
            if(this.choice == 1) {
            	if(validateSignInData())
            		performSignInAction("patient"); //Static Patient value
            	else {
            		System.out.println("Sign in Incorrect..\nPlease Enter Again");
            		runSignIn();
            	}
            }
            if(this.choice == 2) {
            	MainMenu menu = new MainMenu();
                menu.runMenu();
            }
            

    }

    public boolean validateSignInData() {
    /*	try {
    		Connection conn = JDBC.getConnection();
            Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("EXEC Valid SignInData"+ this.lastname+","+this.dob+","+this.city);
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

	public void printSignInMenu() {
        try {
		Connection conn = JDBC.getConnection();
        Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT Facility_ID, Facility_Name FROM MedicalFacility_t");
		System.out.println("Facility_ID   Facility_Name");
		while (rs.next()) {
		    int s = rs.getInt("Facility_ID");
		    String n = rs.getString("Facility_Name");
		    System.out.println(s + "         " + n);
		}
        rs.close();
        stmt.close();
        conn.close();
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
    	
    }	
    
    public int getSignInData() {
    	try {
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("Enter FacilityID: ");
            this.facilityid = Integer.parseInt(keyboard.nextLine()); 
            //Validate Facility Data using SP
            System.out.print("Enter Last name: ");
            this.lastname = keyboard.nextLine(); 
            System.out.print("Enter Date of Birth: ");
            this.dob = keyboard.nextLine(); 
            System.out.print("Enter City: ");
            this.city = keyboard.nextLine(); 
            System.out.print("Enter 1)Sign-In 2)Go Back\nchoice:");
            this.choice = Integer.parseInt(keyboard.nextLine()); 
            
            if (choice < 1 || choice > 2) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 1 || choice > 2);
    	}
    	catch(Exception e) {
    		System.out.print("Error in SignIn data....\n"+e);
    	}
        return choice;
    }
       
    public void performSignInAction(String value) {
      System.out.println("Sign in Successful");
      if(value == "patient") {
      	System.out.println("**************\n*Patient Main Page*\n**************");
      	Patient p = new Patient();//Pass patient id here
        p.runPatientMenu();
      }
      else if(value == "staff") {
        	System.out.println("**************\n*Staff Main Page*\n**************");
          	Staff s = new Staff();//Pass staff id here
            s.runStaffMenu();
          }
    }

}
