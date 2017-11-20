package aums;
import java.util.*;
public class Test {
	public static void main(String[] args) {
		Faculty facu = new Faculty();
		Test.init();
		int a;
		do{
		System.out.println("Select a user type from below options: ");
		System.out.println();
		System.out.println("(1)Student\n(2)Faculty\n(3)Exit");
		Scanner s = new Scanner(System.in);
		 a = s.nextInt();
		if(a==1){
			System.out.println("Roll no: ");
			int roll = s.nextInt();
			Student st = Student.ifRollPresent(roll);
			st.getStudent();
			st.selectmethod();
			System.out.println();
			
		}
		else if(a==2){
			System.out.println("Enter Id");
			int id = s.nextInt();
			Faculty fc = facu.ifpresent(id);
			fc.getProfile();
			fc.selectmethod();
			System.out.println();
		}
		else if(a!=3){
			System.out.println("Invalid Option");
		}
		s.close();
		}while(a!=3);	
		
		
	}

	public static void init(){
	   	Course.allcourses = Course.getCour();
		Student.allstudents = Student.getStud();
		Faculty.allfaculty = Faculty.getFac();

	}
}
