class Student {

    String name;
    int id;
  
    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class a18 
{
    public static void main(String[] args)
    {
       
        Student s1 = new Student("Vedant", 14);
        System.out.println("Name : "+ s1.name +" | Id : " + s1.id);
    }
}
