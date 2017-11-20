package aums;
import java.io.*;
public class Academic implements Serializable{
	String acadprogram;
	String branch;
	int joiningyear;
	int semester;
	public Academic() {
		this.acadprogram = null;
		this.branch = null;
		this.joiningyear =  0;
		this.semester = 0;
	}
	public Academic(String ap, String br, int jy, int sem) {
		this.acadprogram = ap;
		this.branch = br;
		this.joiningyear =  jy;
		this.semester = sem;	
	}
	public void getAcademic() {
		System.out.println("\nAcademic Program: " + acadprogram  + "\nBranch: " + branch  + "\nJoining Year: " + joiningyear + "\nSemester: " + semester);
	}
}
