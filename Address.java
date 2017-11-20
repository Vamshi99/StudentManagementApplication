package aums;
import java.util.*;
import java.io.*;

public class Address implements Serializable{
	String street; 
	String city;
	int pincode;
	public Address() {
		this.street = null;
		this.city = null;
		this.pincode = 0;
	}
	public Address(String str, String ci, int pin) {
		this.street = str;
		this.city = ci;
		this.pincode = pin;
	}
	public void get_address() {
		System.out.println("\nStreet: " + street  + "\ncity: " + city  + "\npincode: " + pincode);
	}
}
