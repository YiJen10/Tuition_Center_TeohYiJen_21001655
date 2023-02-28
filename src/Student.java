import java.util.Scanner;

public class Student {
    // data/attributes
    Scanner in = new Scanner(System.in);
    public Name name;
    public Address address_stu;
    public Tutor tutor_assigned;
    protected String ic;
    protected String address;
    protected String school_name;
    protected String tutor_name;
    private final float[] marks = new float[5];
    public Student(){ //constructor
        name = new Name();
    }

    public Student(String fname, String mname, String lname, String unitNo, String street, String postcode, String district, String state){ //constructor
        name = new Name(fname,mname,lname);
        address_stu = new Address(unitNo, street, postcode, district, state);
    }

    //methods or operations
    public void setName(Name input){
        name = input;
    }

    public void setIC(String ic){
        this.ic = ic;
    }
/*    public void setAddress(String address){
        this.address = address;
    }*/

    public void setSchool_name(String school_name){
        this.school_name = school_name;
    }
    public void setTutor_name(String tutor_name){
        this.tutor_name = tutor_name;
    }
    public void setTutor(Tutor tutor){
        this.tutor_assigned = tutor;
    }
    public Tutor getTutor(){
        return tutor_assigned;
    }

    public void setMarks(float mark,int i) throws Exception{
/*        boolean correct = false;
        while(!correct){
            if((mark>0)&&(mark<100)){
                marks[i] = mark;
                correct = true;
            }else{
                System.out.print("Mark cannot be negative value or more than 100.\nRe-enter the mark: ");
                mark = in.nextFloat();
            }
        }*/
        if(mark>0 && mark<100) {
            marks[i] = mark;
        }else{
            throw new Exception("ERROR!!!detect error mark");
        }
    }
    public float calcAvg(){
        float total=0;
        for(int i=0;i<5;i++){
            total += marks[i];
        }
        return total/5;
    }

    public float findMin(){
        float min = 9999999;
        for(int i=0;i<5;i++){
            if(marks[i]<min){
                min = marks[i];
            }
        }
        return min;
    }
    public float findMax(){
        float max = -9999999;
        for(int i=0;i<5;i++){
            if(marks[i]>max){
                max = marks[i];
            }
        }
        return max;
    }

    void displayMark(){
        for(int i=0;i<marks.length;i++){
            System.out.println("Marks at index "+(i)+" is "+marks[i]);
        }
    }
    public static void main(String[] args){
        Student stud0 = new Student();
        try {
            stud0.setMarks(20, 0);
            stud0.setMarks(-10, 1);
        }catch (Exception ex) {//catch block... action to be taken
            //in case of Exception
            System.out.println("Cannot continue");
            ex.printStackTrace();
        }
        stud0.displayMark();
    }
}
