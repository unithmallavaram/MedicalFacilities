import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Patient {
	public String lastname;
	public String firstname;
	public int facilityid;
	public int choice;
	
    public void runPatientMenu() {
            this.choice = getPatientData();
            if(this.choice == 1) {  //Check-in
            		printPatientCheckinMenu();
            		getPatientCheckinData();//get Facility Id for a chekin process
            		if(validfacilitychoice()) { //valid checkin
                    	System.out.println("Going to Check in Page...");
            			System.out.println("**************\n*Check in Page*\n**************");
            			Checkin c = new Checkin(this.facilityid);
            			c.runCheckIn();
            		}
            		else {//Already checkin
                    	System.out.println("Already Checked in that facility please perform check out or visit another facility");
                      	System.out.println("**************\n*Patient Main Page*\n**************");
                      	runPatientMenu();
            		}
            }
            else if(this.choice == 2) { //Check-out
            	if(validateCheckoutData()) {//Already check in and output report ready to ack
                	System.out.println("Going to Ack Page...");
                	System.out.println("**************\n*Acknowledgement Page*\n**************");
                	PatientAcknowledge pa = new PatientAcknowledge();//Pass checkin id here
                	pa.runPatientAck();
            	}
            	else {//Already check in and output report not ready
            		System.out.println("Ack is not ready to sign. Check back again after sometime");
                  	System.out.println("**************\n*Patient Main Page*\n**************");
            		runPatientMenu();
            	}
            }
            else if(this.choice == 3) { //Go back
            	System.out.println("**************\n*Sign in Page*\n**************");
            	SignIn s = new SignIn();
            	s.runSignIn();
            }
            

    }

    private boolean validateCheckoutData() {
		return true;
	}

	public boolean validfacilitychoice() {
		return true;
	}

	public void printPatientCheckinMenu() {
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
    
    public int getPatientData() {
    	try {
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("Enter 1)Check-in  2)Check-out acknowledgement  3)Go back\nChoice:");
            this.choice = Integer.parseInt(keyboard.nextLine()); 
            
            if (choice < 1 || choice > 3) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 1 || choice > 3);
    	}
    	catch(Exception e) {
    		System.out.print("Error in Patient choice....\n"+e);
    	}
        return choice;
    }
      
    public void getPatientCheckinData() {
    	try {
    		Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter FacilityID: ");
            this.facilityid = Integer.parseInt(keyboard.nextLine()); 
    	}
    	catch(Exception e) {
    		System.out.print("Error in Patient Checkin choice....\n"+e);
    	}
    }

}

