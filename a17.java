import java.io.*;

public class Student{
	
		String name;
		
		Student(String n){	
			this.name = n;
		}
		
	
		Student(){	
			name = "newStudent";
		}
		

};

class a17{

	public static void main(String []args){
		
		Student s1 = new Student();
		
		Student s2 = new Student("vedant");
		
		System.out.println("student 1 : " +  s1.name);
		System.out.println("student 2 : " +  s2.name);
	
	}


}
