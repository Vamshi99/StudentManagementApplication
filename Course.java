package aums;
import java.util.*;
import java.io.*;

public class Course implements Serializable{
	String name;
	String code;
	char type;
	static ArrayList<Course> allcourses= new ArrayList<Course>();
	public Course() {
		this.name =null;
		this.code =null;
		this.type ='T';
	}
	
	public Course(String cn, String cc, char ty) {
		this.name = cn;
		this.code = cc;
		this.type = ty;
		allcourses.add(this);
		Course.saveCour();
	}
	
	public void getCourse() {
		System.out.println("\nName: "+name+"\ncode: "+code+"\nType: "+type);
	}
	
	public String getCourseCode() {
		return this.code;
	}
	public String getCourseName() {
		return this.name;
	}
	
	public void getProfile(Course cou){
		System.out.println();
		System.out.println("Name   : "+cou.getCourseName());
		System.out.println("Course Code : "+cou.getCourseCode());
		System.out.println();


	}
	public static void saveCour(){

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try{
			fos = new FileOutputStream("Data/Subjects.ser");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(Course.allcourses);
			oos.flush();
			oos.close();

		}
		catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
	}
	
	public static ArrayList<Course> getCour(){
		FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        ArrayList<Course> listOfCourses = null;
 
        try {
            // reading binary data
            fis = new FileInputStream("Data/Subjects.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfCourses = (ArrayList<Course>) ois.readObject();

        } 
        catch (FileNotFoundException fnfex) {
  //          fnfex.printStackTrace();
        }
        catch (IOException ioex) {
//            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        
        return listOfCourses;
	}

	public static Course returnCour(String a){
			
			for(Course st : Course.allcourses){
				if(st.getCourseCode().equals(a)){
					return st;

				}
			}
			return null;
			
	}
	public static Course returnRegSub(String a,Student s){
			for(Course st : s.rcourses){
				if(st.getCourseCode().equals(a)){
					return st;

				}
			}
			return null;
	}
		
}