import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Checkin {
	public int facilityid;
	
	public String SymptomName;
	
	public Checkin(int facilityid) {
		this.facilityid = facilityid;
	}
	
    public void runCheckIn() {
    		System.out.println("Displaying Symptoms");
        	printSymptomsMenu();
        	do {
            this.SymptomName = getSymptomData();
            System.out.println(this.SymptomName);
            if(this.SymptomName.contentEquals("Other")) {
            	//Add Symptom Description
            }
            else if(this.SymptomName.contentEquals("Done")) {
            	//Add Symptom Description
            }
            else {
            	SymptomMetaData sm = new SymptomMetaData(this.SymptomName);
                sm.runSymptomMetaData();
            }
        	}while(!this.SymptomName.contentEquals("Done"));
        	//validate, record time, logout, return to home page
        	
        	MainMenu menu = new MainMenu();
            menu.runMenu();
        	

    }
    
	public void printSymptomsMenu() {
        try {
		Connection conn = JDBC.getConnection();
        Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DISTINCT SYMPTOM_NAME FROM XX_SYMPTOMS_T");
		System.out.println("SYMPTOM_NAME");
		while (rs.next()) {
		    String n = rs.getString("SYMPTOM_NAME");
		    System.out.println(n);
		}
		System.out.println("Other");
		System.out.println("Done");
        rs.close();
        stmt.close();
        conn.close();
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
    	
    }
	 
    public String getSymptomData() {
		String SymptomName1 = null;
    	try {

        Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter Symptom name: ");
            SymptomName1 = keyboard.nextLine(); 
    	}
    	catch(Exception e) {
    		System.out.print("Error in SignIn data....\n"+e);
    	}
        return SymptomName1;
    }

}
