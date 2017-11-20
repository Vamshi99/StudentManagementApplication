package aums;
import java.io.*;
import java.util.*;
public class Mark implements Serializable{
	Internal intmark;
	int  extmark;
	int grcmark;
	int totmark;
	Course course;
	String grade;
	
	public Mark() {
		this.intmark=null;
		this.extmark=0;
		this.grcmark=0;
		this.totmark=0;
		this.grade =null;
	}
	public Mark(Course co, Internal i, int e, int grm, String gra) {
		this.course = co;
		this.intmark=i;
		this.extmark=e;
		this.grcmark=grm;
		this.grade = gra;
		this.totmark=this.intmark.total+this.extmark+this.grcmark;
	}
	
	public void getMark() {
		System.out.println("Course: "+ course);
		System.out.println("----------Internal Marks splitout----------");
		intmark.getInternal();
		System.out.println("----------External Marks----------");
		System.out.println("External marks: " +extmark);
		System.out.println("----------Grace Marks----------");
		System.out.println("Grace marks: " + grcmark);
		System.out.println("----------Total Marks----------");
		System.out.println("\nTotal marks: " + totmark);
		System.out.println("Grade: "+ grade);
	}
	public int getIntmark() {
		return this.intmark.total;
	}
	public int getExtmark() {
		return this.extmark;
	}
	public int getGrcmark() {
		return this.grcmark;
	}
	public int getTotal() {
		return this.totmark;
	}
	public String getGrade() {
		return this.grade;
	}
}
