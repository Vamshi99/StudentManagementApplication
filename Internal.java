package aums;
import java.util.*;
import java.io.*;
public class Internal implements Serializable{
	int periodical1;
	int periodical2;
	int evaluation;
	int total;
	
	public Internal() {
		this.periodical1=0;
		this.periodical2=0;
		this.evaluation=0;
		this.total=0;
	}
	public Internal(int p1, int p2, int ce) {
		this.periodical1=p1;
		this.periodical2=p2;
		this.evaluation=ce;
		this.total=this.periodical1+this.periodical2+this.evaluation;
	}
	
	public void getInternal() {
		System.out.println("\nPeriodical 1 marks: " +periodical1 +"\nPeriodical 2 marks: " + periodical2 + "\nContinuos Evaluation marks: " + evaluation + "\nTotal Internal marks: " + total);
	}
}
