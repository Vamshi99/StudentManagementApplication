package aums;
import java.io.*;
public class Personal implements Serializable{
	String firstName;
	String lastName;
	String gender;
	Date dob;
	public Personal() {
		this.firstName = null;
		this.lastName = null;
		this.gender = null;
		this.dob = null;
	}
	public Personal(String fn, String ln, String ge, Date dob) {
		this.firstName = fn;
		this.lastName = ln;
		this.gender = ge;
		this.dob = dob;	
	}
	public void getPersonal() {
		System.out.print("\nFirstname: " + firstName  + "\nLastName: " + lastName + "\ngender: " + gender + "\nDOB: ");
		try {
			dob.getDate();
		}
		catch(NullPointerException npe) {
			System.out.println("Date not set");
		}
	}
}
