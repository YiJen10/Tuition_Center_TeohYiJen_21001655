public class TutorList {
    private int index = 0;
    public Tutor[] tutors;
    public TutorList(){
        tutors = new Tutor[0];
    }
    public void addTutor(Tutor tut){
        tutors = tutors_with_extra_index();
        tutors[index++] = tut;
    }
    private Tutor[] tutors_with_extra_index(){
        Tutor[] new_arr = new Tutor[index+1];
        int i=0;
        for(Tutor t : tutors){
            new_arr[i] = t;
            i+=1;
        }
        return new_arr;
    }

    public boolean findTutor(String name){
        for(int i=0;i<index;i++){
            if (name.equals(tutors[i].name.getFirstName())||name.equals(tutors[i].name.getMiddleName())||name.equals(tutors[i].name.getLastName())) {
                return true;
            }
        }
        return false;
    }
    public void found_t(String name){
        for(int i=0;i<index;i++){
            if (name.equals(tutors[i].name.getFirstName())||name.equals(tutors[i].name.getMiddleName())||name.equals(tutors[i].name.getLastName())) {
                System.out.println(tutors[i].name.getFullName());
            }
        }
    }
    public Tutor getTutors_assigned(String name){
        int index_t = 0;
        for(int i=0;i<index;i++){
            if (name.equals(tutors[i].name.getFirstName())||name.equals(tutors[i].name.getMiddleName())||name.equals(tutors[i].name.getLastName())) {
                index_t = i;
            }
        }
        return tutors[index_t];
    }
}
