package aums;
import java.util.*;
import java.io.*;
public class Student extends Users implements Serializable{
	Personal persinfo;
	Academic acadinfo;
	Contact continfo;
	Grade grade;
	Users user = new Users();
	ArrayList<Fine> allfines;
	ArrayList<Course> rcourses;
	static ArrayList<Student> allstudents = new ArrayList<Student>();
	ArrayList<Achievement> achievement;
	Address addinfo;
	static int count=1;
	int rollno;
	public Student() {
		this.persinfo = null;
		this.acadinfo = null;
		this.continfo = null;
		this.addinfo = null;
	}
	public Student(Personal pi, Academic ai, Contact ci, Address adi) {
		this.persinfo = pi;
		this.acadinfo = ai;
		this.continfo = ci;
		this.addinfo = adi;
		this.grade = new Grade();
		this.allfines = new ArrayList<Fine>();
		this.rcourses = new ArrayList<Course>();
		this.achievement = new ArrayList<Achievement>();
		this.rollno = count++;
		allstudents.add(this);
		this.save();
		System.out.println("Created student roll number is: "+ rollno);
	}
	
	public void getStudent() {
		System.out.println("Roll No: " + rollno);
		System.out.println("\n--------------------Personal Information--------------------");
		persinfo.getPersonal();
		System.out.println("\n--------------------Academic Information--------------------");
		acadinfo.getAcademic();
		System.out.println("\n--------------------Contact Information--------------------");
		continfo.getContact();
		System.out.println("\n--------------------Address Infomation--------------------");
		addinfo.get_address();
	}
	
	public int getRoll(){
		return this.rollno;
	}
	public String getName(){
		return this.persinfo.firstName;
	}
	public String getBranch() {
		return this.acadinfo.branch;
	}
	public void setName(String name) {
		this.persinfo.firstName=name;
	}
	public void addcourse(Course ds) {
		rcourses.add(ds);
	}
	public void addFine(Fine fi) {
		this.allfines.add(fi);
	}

	public void addSub(Course co){
		this.rcourses.add(co);
	}
	public void addAch(Achievement ac){
		this.achievement.add(ac);
	}
	public static Student ifRollPresent(int a){
		
		
		for(Student st :Student.allstudents){
			if(st.getRoll()==a){
				 return st;

			}
		}
		return null;
	}
	public void setRoll(int rn) {
		this.rollno = rn;
	}
	public boolean ifRegCourPresent(String a){
		for(Course st : rcourses){
			if(st.code.equals(a)){
				return true;

			}
		}
		return false;
	}
	
	public static ArrayList<Student> getStud(){
		FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        ArrayList<Student> listOfStudents = null;
 
        try {
            // reading binary data
            fis = new FileInputStream("Data/Students.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfStudents = (ArrayList<Student>) ois.readObject();

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
        return listOfStudents;
	}
	public void selectmethod(){
		System.out.println("Welcome ! "+this.getName());
		System.out.println();
		do{
		

			int n;
			System.out.println("1.  Show Name");
			System.out.println("2.  Show Branch");
			System.out.println("3.  Display GradeBook");
			System.out.println("4.  Show All Students");
			System.out.println("5.  Register a Subject");
			System.out.println("6.  Show Registered Subjects");
			System.out.println("7.  Show All Subjects");
			System.out.println("8.  Show Profile");
			System.out.println("9.  Add Achievements");
			System.out.println("10. Show All Achievements");
			System.out.println("11. Add Fine");
			System.out.println("12. Show All Fines");
			System.out.println("13. Go Back");
			Scanner s = new Scanner(System.in);
			n = s.nextInt();
			switch(n){
				case 1:
						System.out.println("Hello, " +this.getName());
						System.out.println();
						break;
				case 2:
						System.out.println("Your are "+ this.acadinfo.branch+" Branch");
						System.out.println();
						break;
				case 3:
						for(Mark mark : this.grade.totalMarksList){
							mark.getMark();
    						}
    				break;
				case 4:
						for(Student stud : Student.allstudents){
            				System.out.println(stud.getName());
        					}
        				System.out.println();
        				break;	
				case 5:
						System.out.println("add Subject to my course");
						while(true){
							System.out.println("Enter Subject Name:");
							String name = s.next();
							System.out.println("Enter the Course Code");
							String code = s.next();
							Course cour = Course.returnCour(code);
							if( cour != null){
									if(!this.ifRegCourPresent(code)){
											this.addSub(cour);
											this.save();
											System.out.println("Saved.. ");
											break;
									}
							}
						}
						System.out.println();
						break;
				case 6:
						System.out.println("All Registered Subjects");
						System.out.println(this.rcourses);
						for(Course cour : this.rcourses){
							System.out.println(cour.getCourseName()+"  "+cour.getCourseCode());
						}
						
						break;
				case 7:
						System.out.println("Subjects");
						for(Course cour : Course.allcourses){
							System.out.println(cour.getCourseName()+"  "+cour.getCourseCode());
						}
						break;
				case 8:
						this.getStudent();
						break;
				case 9:
						System.out.println();
						System.out.println("Add Achievements");
						System.out.println();
						while(true){
							System.out.println("Enter the type of Achievement :");
							String achName = s.next();
							System.out.println("Give any Description of Achievement");
							String achDes = s.nextLine();
							Achievement ac = new Achievement(achName,achDes);
							if(achName!= null){
								this.addAch(ac);
								this.save();
								System.out.println("Saved..");
								break;
							}
						}
						break;
				case 10:		
						System.out.println("All Achievements");
						System.out.println("Type of Achievement\tDescription");
						for(Achievement ac : this.achievement){
							System.out.println(ac.getName()+"\t\t\t"+ac.getMsg());
						}
						break;
				case 11:
						System.out.println("Add Fine");
						while(true){
						System.out.println("Creator name :");
						String crame = s.next();
						System.out.println("Give any Description of Fines");
						String fnDes = s.nextLine();
						System.out.println("Date of creation: ");
						System.out.println("Day: ");
						int day = s.nextInt();
						System.out.println("Month: ");
						int month = s.nextInt();
						System.out.println("year: ");
						int year= s.nextInt();
						
						System.out.println("Amount of Fines");
						int amt = s.nextInt();
						Fine fine = new Fine(crame,fnDes, new Date(day,month,year),amt);
						if(crame!= null){
							this.addFine(fine);
							this.save();
							System.out.println("Saved..");
							break;
						}
					}
					break;
				case 12:
					System.out.println("All Fines");
					for(Fine fi : this.allfines){
						fi.getFine();
					}
					break;
				default :
						Scanner input = new Scanner(System.in);
						System.out.println("Enter roll no:");
						this.setRoll(input.nextInt());
						this.save();

			}
		}
		while(true);
	}
}

class Test1{
	public static void main(String[] args) {
		ArrayList<Student> arrst = new ArrayList<Student>();
		Course s1 = new Course("oops","15cse202", 'T');
		Course s2 = new Course("dsa","15cse201",'T');
		Course s3 = new Course("oopslab","15cse282",'L');
		Student s4 = new Student(new Personal("Vamshi","krishna","Male", new Date(7,8,9)), new Academic("B.tech", "CSE", 2016, 3), new Contact("Father","1234567890","m@akak.com"), new Address("vallikavu","karunagapally",690525));
		Student s5 = new Student(new Personal("Ramesh","Gupta","Male", new Date(8,9,10)), new Academic("B.tech", "CSE", 2016, 3), new Contact("Mother","1234567890","am@gmail.com"), new Address("ramanyhpur","kei",690254));
		Faculty s6 = new Faculty(new Personal("Naveen","Tata", "Male", new Date(8,9,11)),"Professor");
		Faculty s7 = new Faculty(new Personal("BVK","Gupta", "Male", new Date(9,9,6)),"Asst.Professor");
		
	

		FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        ArrayList<Student> listOfStudents = null;
 
        
        try {
            // reading binary data
            fis = new FileInputStream("Data/Students.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfStudents = (ArrayList<Student>)ois.readObject();
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
        for(Student stud : listOfStudents){
            System.out.println(stud.getName());
        }

        ArrayList<Faculty> listOfFaculty = null;
 
        try {
            // reading binary data
            fis = new FileInputStream("Data/Faculty.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfFaculty = (ArrayList<Faculty>)ois.readObject();
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
        for(Faculty stud : listOfFaculty){
            System.out.println(stud.getName());
        }
	}
}