package aums;
import java.util.*;
import java.io.*;

public class Faculty extends Users implements Serializable {
	Personal pers;
	String position;
	static ArrayList<Faculty> allfaculty = new ArrayList<Faculty>();
	int id;
	static int cnt=1;
	public Faculty() {
		this.pers = null;
		this.position = null;
	
	}
	public Faculty(Personal pe, String pos) {
		this.pers = pe;
		this.position = pos;
		this.id=cnt++;
		this.save();
		allfaculty.add(this);
	}
	public void addStudent() {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the details of student: ");
		System.out.print("First Name: ");
		String a = s.nextLine();
		System.out.print("Last Name: ");
		String b = s.nextLine();
		System.out.print("Gender(Male/Female): ");
		String c = s.nextLine();
		System.out.println("Enter Date of Birth in Day, Month, Year in each input: ");
		System.out.print("Day: ");
		int d = s.nextInt();
		System.out.print("Month: ");
		int e = s.nextInt();
		System.out.print("Year: ");
		int f = s.nextInt();
		System.out.print("Academic Program name: ");
		String g = s.nextLine();
		System.out.print("Department or Branch: ");
		String h = s.nextLine();
		System.out.print("Joining Year: ");
		int i = s.nextInt();
		System.out.print("Semester: ");
		int j = s.nextInt();
		System.out.println("Enter Details of the Guardian:");
		System.out.print("Relationship with Student: ");
		String k = s.nextLine();
		System.out.print("Phone number: ");
		String l = s.nextLine();
		System.out.print("Email Address: ");
		String m = s.nextLine();
		System.out.println("Enter Student Address: ");
		System.out.print("Street: ");
		String n = s.nextLine();
		System.out.print("City: ");
		String o = s.nextLine();
		System.out.print("Pincode: ");
		int p = s.nextInt();
		Student stud = new Student(new Personal(a,b,c,new Date(d,e,f)), new Academic(g,h,i,j), new Contact(k,l,m), new Address(n,o,p));
		s.close();
	}


public void awardmark(int num) {
	for(Student stu:Student.allstudents) {
		if(stu.rollno==num) {
			System.out.println("=================="+ stu.getName()+" 's GradeBook ===================");
			System.out.println();
			while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the subject code: ");
			String code = input.next();
			Course cour = Course.returnRegSub(code,stu);
			System.out.println("Enter periodical1: ");
			int per1 = input.nextInt();
			System.out.println("Enter periodical2: ");
			int per2 = input.nextInt();
			System.out.println("Enter continuos evaluation: ");
			int coe = input.nextInt();
			System.out.println("Enter external: ");
			int external = input.nextInt();
			System.out.println("Enter Grace marks: ");
			int grace = input.nextInt();
			System.out.println("Enter Grade: ");
			String grade = input.next();
			if(cour != null){
				if(!hasMarks(code,stu)){
					stu.grade.totalMarksList.add(new Mark(cour,new Internal(per1,per2,coe),external,grace,grade));
					stu.save();
					break;
				}
				else{
					System.out.println("Marks already exists for the subject..");
				}
			}
			else{
				System.out.println("Student is not registered for the subject..");
			}
			}

		}
	}
}
public int getId() {
	return this.id;
}

public boolean hasMarks(String code,Student st){
	for(Mark g: st.grade.totalMarksList){
		if(g.course.getCourseCode().equals(code)){
			return true;
		}
	}
	return false;
}
public String getName() {
	return this.pers.firstName;
}
public void displayGrade(Student stu){

	for(Mark mark:stu.grade.totalMarksList){
		System.out.println("Subject: " + mark.course.getCourseName());
		System.out.println("Internals :"+mark.getIntmark());
		System.out.println("Sem       :"+mark.getExtmark());
		System.out.println("Grade     :"+mark.getGrcmark());
		}
}
public void getProfile() {
	this.pers.getPersonal();
	System.out.println("\nPosition: "+this.position);
	System.out.println("ID: "+this.getId());
}
	public void selectmethod() {
		System.out.println("Welcome!"+this.getName());
		do{
		

			int temp;
			System.out.println("Select a method from given options");
			System.out.println("1. My Name");
			System.out.println("2. My Id");
			System.out.println("3. GradeBook");
			System.out.println("4. Display Grades");
			System.out.println("5. Students");
			System.out.println("6. All Subjects");
			System.out.println("7. My Profile");
			System.out.println("8. Previous Select Method ");
			Scanner s = new Scanner(System.in);
			temp = s.nextInt();
			switch(temp){
				case 1:
						System.out.println("Your name is, " +this.getName());
						break;
				case 2:
						System.out.println("Your, Id  "+ this.getId());
						break;
				case 3:
					Scanner input = new Scanner(System.in);
					System.out.println("Enter Student Roll: ");
					int roll = input.nextInt();
					Student currentStudent = Student.ifRollPresent(roll);
					if(currentStudent != null){
						displayGrade(currentStudent);
					}
					break;
				case 4:
					System.out.println();
					System.out.println("Enter Student Roll: ");
					int roll1 = s.nextInt();
					Student currentStudent1 = Student.ifRollPresent(roll1);
					if(currentStudent1 != null){
						awardmark(currentStudent1.rollno);
					}
					break;
				case 5:
					System.out.println("ALL Students Details");
					System.out.println();
					for(Student stud : Student.allstudents){
    				System.out.println(stud.getName()+"\t"+stud.getRoll()+"\t"+stud.getBranch());
    					}
    				System.out.println();
    				break;
				case 6:
					System.out.println();
					System.out.println("All Subjects");
					System.out.println();
					for(Course cour : Course.allcourses){
						System.out.println(cour.getCourseName()+"  "+cour.getCourseCode());
					}
					break;
				case 7:
					this.getProfile();
					break;
				case 8:
					return;
				default :
					System.out.println("Enter Valid number");
			
			}
		}
		while(true);
		}
	public Faculty ifpresent(int a){
		
		
		for(Faculty st :Faculty.allfaculty){
			if(st.getId()==a){
				 return st;

			}
		}
		return null;
		
	}
	public static ArrayList<Faculty> getFac(){
		FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        ArrayList<Faculty> listOfFaculty = null;
 
        try {
            // reading binary data
            fis = new FileInputStream("Data/Faculty.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfFaculty = (ArrayList<Faculty>) ois.readObject();

        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        return listOfFaculty;
	}
}