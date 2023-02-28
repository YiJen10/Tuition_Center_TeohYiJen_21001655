public class StudentBatch {
    private int index = 0;
    public Student[] students;
    public StudentBatch(){
        students = new Student[0];
    }

    public void addStudent(Student stu){
        students = students_with_extra_index();
        students[index++] = stu;
    }

    public boolean find(String name){
        for(int i=0;i<index;i++){
            if (name.equals(students[i].name.getFirstName())||name.equals(students[i].name.getMiddleName())||name.equals(students[i].name.getLastName())) {
                return true;
            }
        }
        return false;
    }

    public void found(String name){
        for(int i=0;i<index;i++){
            if (name.equals(students[i].name.getFirstName())||name.equals(students[i].name.getMiddleName())||name.equals(students[i].name.getLastName())) {
                System.out.println(students[i].name.getFullName());
            }
        }
    }
    private Student[] students_with_extra_index(){
        Student[] new_arr = new Student[index+1];
        int i = 0;
        for (Student stu : students){
            new_arr[i] = stu;
            i += 1;
        }
        return new_arr;
    }
}
