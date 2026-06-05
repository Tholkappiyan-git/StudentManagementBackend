package student;

public class Student {

    private int id;
    private String name;
    private String rollNumber;
    private String branch;
    private int marks;

    
    public Student(String name, String rollNumber, String branch, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.branch = branch;
        this.marks = marks;
    }

    public int getId(){ 
        return id;
     }

    public String getName(){
         return name;
     }

    public String getRollNumber(){
         return rollNumber; 
     }

    public String getBranch(){ 
        return branch; 
    }
    public int getMarks(){ 
        return marks;
     }

     
    public void setId(int id){
         this.id = id; 
    }
    
    public void setMarks(int marks){
         this.marks = marks;
     }

    @Override
    public String toString(){

        return id + " | " + name + " | " + rollNumber + " | " + branch + " | " + marks;
    }
    
}
