package aums;
import java.util.*;
import java.io.*;
public class Date implements Serializable{
	int day;
	int month;
	int year;
	public Date() {
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}
	public Date(int d, int m, int y) {
		this.day = d;
		this.month = m;
		this.year = y;
	}
	public void getDate() {
		System.out.print(day + "/" + month + "/" + year);
	}
}
