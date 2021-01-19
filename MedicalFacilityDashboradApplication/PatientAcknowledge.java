import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PatientAcknowledge {
public int choice;
public String reason;
	public void runPatientAck() {
		 this.choice = getPatientAckData();
         if(this.choice == 1) {//Yes
             //Update Ack Status into database table
         }
         else if(this.choice == 2) {//No
        	 try {
        	        Scanner keyboard = new Scanner(System.in);
        	        System.out.print("Enter Reason:");
                    this.reason = keyboard.nextLine();
                    
                    //Insert Reason into database table
                    
                    
        	    	}
        	    	catch(Exception e) {
        	    		System.out.print("Error in Patient Ack Reason....\n"+e);
        	    	}
          }
         else if(this.choice == 3) {//Go Back
        	
          }
        System.out.println("**************\n*Patient Main Page*\n**************");
       	Patient p = new Patient();//Pass patient id here
        p.runPatientMenu();
	}
	
    public int getPatientAckData() {
    	try {
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("Enter 1)Yes  2)No  3)Go back\nChoice:");
            this.choice = Integer.parseInt(keyboard.nextLine());
            
            if (choice < 1 || choice > 3) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 1 || choice > 3);
    	}
    	catch(Exception e) {
    		System.out.print("Error in Patient Ack choice....\n"+e);
    	}
        return choice;
    }
}
