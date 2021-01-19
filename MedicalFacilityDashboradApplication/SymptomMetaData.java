import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SymptomMetaData {
	public String Symptom;
	public String bodypart;
	public String duration;
	public String reoccurring;
	public String severity;
	public String cause;
    public SymptomMetaData(String symptomName) {
		this.Symptom = symptomName;
	}
	public void runSymptomMetaData() {
		System.out.println("Displaying Symptoms Metadata");
    	getSymptomsMetaData();
    	//insert data into symtommetadata table
    }
	
    public void getSymptomsMetaData() {
    	try {
        Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter Body Part: ");
            this.bodypart = keyboard.nextLine(); 
            System.out.print("Enter Duration: ");
            this.duration = keyboard.nextLine(); 
            System.out.print("Enter Reoccurring?: ");
            this.reoccurring = keyboard.nextLine(); 
            System.out.print("Enter Severity value: ");
            this.severity = keyboard.nextLine(); 
            System.out.print("Enter Cause(Incident): ");
            this.cause = keyboard.nextLine(); 
    	}
    	catch(Exception e) {
    		System.out.print("Error in SignIn data....\n"+e);
    	}
    }
}
