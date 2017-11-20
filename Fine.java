package aums;
import java.io.*;
public class Fine {
	String creatorname;
	String remarks;
	Date incidentdate;
	int amt;
	public Fine() {
		this.creatorname = null;
		this.remarks = null;
		this.incidentdate = null;
		this.amt=0;
	}
	public Fine(String cn, String rm, Date idt,int am) {
		this.creatorname = cn;
		this.remarks = rm;
		this.incidentdate = idt;
		this.amt=am;
	}
	public void getFine() {
		System.out.print("\n CreatorName: " + creatorname + "\n Remarks: " + remarks +"\nAmout: " +amt  + "\n Incident Date: ");
		incidentdate.getDate();
	}
}
