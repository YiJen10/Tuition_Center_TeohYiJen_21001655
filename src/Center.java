import java.util.Objects;
import java.util.Scanner;

public class Center {
    Scanner in = new Scanner(System.in);
    boolean tu;
    int m=0;
    int t=0;

    StudentBatch b2023 = new StudentBatch();
    TutorList t2023 = new TutorList();

    public void getTutor(boolean resp_tutor){
        t=0;
        while(resp_tutor){
            System.out.print("Enter tutor #"+(t+1)+"'s first name: ");
            String fname_t = in.next();
            System.out.print("Enter tutor #"+(t+1)+"'s middle name: ");
            String mname_t = in.next();
            System.out.print("Enter tutor #"+(t+1)+"'s last name: ");
            String lname_t = in.next();

            System.out.println("Address: ");
            System.out.print("Tutor "+(t+1)+"'s unit number:");
            String unitNoT = in.next();
            System.out.print("Tutor "+(t+1)+"'s street:");
            String streetT = in.next();
            System.out.print("Tutor "+(t+1)+"'s postcode:");
            String postcodeT = in.next();
            System.out.print("Tutor "+(t+1)+"'s district:");
            String districtT = in.next();
            System.out.print("Tutor "+(t+1)+"'s state:");
            String stateT = in.next();

            System.out.println("Enter tutor #"+(t+1)+"'s date joined: ");
            System.out.print("Day: ");
            int day = in.nextInt();
            System.out.print("Month: ");
            int month = in.nextInt();
            System.out.print("Year: ");
            int year = in.nextInt();

            Tutor tut = new Tutor(fname_t,mname_t,lname_t,unitNoT,streetT,postcodeT,districtT,stateT,day,month,year);
            t2023.addTutor(tut);
            t2023.tutors[t].setName(t2023.tutors[t].name);
            
            System.out.print("Enter tutor #"+(t+1)+"'s IC: ");
            String ic = in.next();
            t2023.tutors[t].setIC(ic);

            System.out.print("Enter tutor #"+(t+1)+"'s experience(in years): ");
            int num_exp = in.nextInt();
            t2023.tutors[t].setNum_year_exp(num_exp);

            System.out.print("Enter tutor #"+(t+1)+" years in center: ");
            int num_center = in.nextInt();
            t2023.tutors[t].setNum_year_center(num_center);

            System.out.print("Enter tutor #"+(t+1)+"'s qualification: ");
            String qualification = in.next();
            t2023.tutors[t].setQualification(qualification);

/*            System.out.print("Enter tutor #"+(t+1)+"'s address: ");
            String address = in.next();
            t2023.tutors[t].setAddress(address);*/

/*            System.out.print("Enter tutor #"+(t+1)+"'s date joined: ");
            String dateJoined = in.next();
            t2023.tutors[t].setDateJoined(dateJoined);*/
            t++;
            System.out.print("Do you want to continue to add new tutor?(Y/N)");
            String res = in.next();
            if(Objects.equals(res, "N")){
                resp_tutor = false;
            }
        }

    }

    public void getStudent(boolean response){
        m=0;
        while(response){
            System.out.print("Enter student #"+(m+1)+"'s first name : ");
            String fname = in.next();
            System.out.print("Enter student #"+(m+1)+"'s middle name : ");
            String mname = in.next();
            System.out.print("Enter student #"+(m+1)+"'s last name : ");
            String lname = in.next();

            System.out.println("Address: ");
            System.out.print("Student "+(m+1)+"'s unit number:");
            String unitNoS = in.next();
            System.out.print("Student "+(m+1)+"'s street:");
            String streetS = in.next();
            System.out.print("Student "+(m+1)+"'s postcode:");
            String postcodeS = in.next();
            System.out.print("Student "+(m+1)+"'s district:");
            String districtS = in.next();
            System.out.print("Student "+(m+1)+"'s state:");
            String stateS = in.next();

            Student stu = new Student(fname,mname,lname,unitNoS,streetS,postcodeS,districtS,stateS);
            b2023.addStudent(stu);
            b2023.students[m].setName(b2023.students[m].name);

            System.out.print("Enter student #"+(m+1)+"'s IC: ");
            String ic = in.next();
            b2023.students[m].setIC(ic);

            System.out.print("Enter student #"+(m+1)+"'s school name: ");
            String s_n = in.next();
            b2023.students[m].setSchool_name(s_n);

            tu = true;
            while (tu){
                System.out.print("Enter tutor's name (first/middle/last) that assigned to student #" + (m + 1)+" : ");
                String name_t = in.next();
                boolean tutor_exist = t2023.findTutor(name_t);
                if (tutor_exist) {
                    System.out.println("Found");
                    t2023.found_t(name_t);
                    b2023.students[m].setTutor_name(name_t);
                    b2023.students[m].setTutor(t2023.getTutors_assigned(name_t));
                } else {
                    System.out.println("Not found");
                }
                if(!tutor_exist){
                    System.out.println("Please re-enter tutor's name!!!");
                }
                else{
                    tu = false;
                }
            }

            for (int i = 0; i < 5; i++) {
                System.out.print("Enter mark for subject " + (i + 1) + " for student " + (m + 1) + " : ");
                float mark = in.nextFloat();
                try { //try nock... something in here can cause exception
                    b2023.students[m].setMarks(mark, i);
                }catch (Exception ex) {//catch block... action to be taken
                    //in case of Exception
                    System.out.println("Cannot continue");
                    ex.printStackTrace();
                }
            }

            //display name
            System.out.println("Name = " + b2023.students[m].name.getFullName());
            //calculate avg
            System.out.println("Avg = " + b2023.students[m].calcAvg());
            //find min
            System.out.println("Min = " + b2023.students[m].findMin());
            //find max
            System.out.println("Max = " + b2023.students[m].findMax());
            m++;
            System.out.print("Do you want to continue to add new student?(Y/N)");
            String res = in.next();
            if(Objects.equals(res, "N")){
                response = false;
            }
        }

    }

    public void getFind(){
        System.out.print("Enter student's first name to find : ");
        String n = in.next();
        boolean exist = b2023.find(n);
        if(exist){
            System.out.println("Found\n");
            b2023.found(n);
        }
        else{
            System.out.println("Not found\n");
        }
    }

    public void getDisplay(){
        System.out.println("Total students: "+(m));
        int j=1;
        for(Student s: b2023.students){
            System.out.println("Student #"+j);
            System.out.println("Name: "+s.name.getFullName());
            System.out.println("IC: "+s.ic);
            System.out.println("Address: "+s.address_stu.getFullAddress());
            System.out.println("School Name: "+s.school_name);
            System.out.println("Tutor: "+s.getTutor().name.getFullName());
            System.out.println("Average Mark: "+s.calcAvg());
            System.out.println("Maximum Mark: "+s.findMax());
            System.out.println("Minimum Mark: "+s.findMin()+"\n");
            j++;
        }

        System.out.println("Total tutors: "+(t));
        j=1;
        for (Tutor tut: t2023.tutors){
            System.out.println("Tutor #"+j);
            System.out.println("Name: "+tut.name.getFullName());
            System.out.println("IC: "+tut.ic);
            System.out.println("Address: "+tut.address_t.getFullAddress());
            System.out.println("Experience of teaching(years): "+tut.num_year_exp);
            System.out.println("Number of years teaching in center: "+tut.num_year_center);
            System.out.println("Qualification: "+tut.qualification);
            System.out.println("Date Joined: "+tut.date.getFullDate()+"\n");
            j++;
        }
    }
}
