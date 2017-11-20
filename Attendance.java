package aums;
import java.io.*;
public class Attendance implements Serializable{
	int percentage;
	int attmark;
	int warning;
	public Attendance() {
		this.percentage =0;
		this.attmark = 0;
		this.warning = 0;
	}
	public Attendance(int p) {
		this.percentage =p;
		this.attmark = computemark(this.percentage);
		this.warning = computewarn(this.percentage);
	}
	public void getAttendance() {
		System.out.println("\nPercentage: "+percentage+ "\nAttendance marks: "+attmark);
		if(warning==0) {
			System.out.println("You have sufficient attendance. You can attend the exams.");
		}
		else if(warning==1) {
			System.out.println("You don't have sufficient attendance. You can't attend the exams. Please meet concerned officials.");
		}
	}
	public int getWarning() {
		return this.warning;
	}
	public int computewarn(int per) {
		if(per>=75) {
			return 0;
		}
		else {
			return 1;
		}
	}
	public int computemark(int pers) {
		if(pers>=95) {
			return 5;
		}
		else if(pers>=90) {
			return 4;
		}
		else if(pers>=85) {
			return 3;
		}
		else if(pers>=80) {
			return 2;
		}
		else if(pers>=75) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
}
	
