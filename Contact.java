package aums;
import java.io.*;
public class Contact implements Serializable{
	String relation;
	String phonenumber;
	String email;
	public Contact() {
		this.relation = null;
		this.phonenumber = null;
		this.email = null;
	}
	public Contact(String rl, String phn, String eml) {
		this.relation = rl;
		this.phonenumber = phn;
		this.email = eml;
	}
	public void getContact() {
		System.out.println("\nRelation to Student: " + relation  + "\nPhone Number: " + phonenumber  + "\nE-mail Address: " + email);
	}
}
