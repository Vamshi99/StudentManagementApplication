package aums;
import java.util.*;
import java.io.*;

public class Grade implements Serializable{
	float CGPA;
	float SGPA;
	ArrayList<Mark> totalMarksList = new ArrayList<Mark>();
	ArrayList<Attendance> attendaceList = new ArrayList<Attendance>();
}
