public class Tutor {
    //data
    Name name;
    Address address_t;
    Date date;
    String ic;
    String address;
    int num_year_exp;
    int num_year_center;
    String qualification;
    String dateJoined;

    public Tutor(){
        name = new Name();
    }
    public Tutor(String fname, String mname, String lname,String unitNo, String street, String postcode, String district, String state, int day, int month, int year){ //constructor
        name = new Name(fname,mname,lname);
        address_t = new Address(unitNo, street, postcode, district, state);
        date = new Date(day, month, year);
    }
    protected void setName(Name name){
        this.name = name;
    }
    public void setIC(String ic){
        this.ic = ic;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setNum_year_exp(int num_year_exp){
        this.num_year_exp = num_year_exp;
    }
    public void setNum_year_center(int num_year_center){
        this.num_year_center = num_year_center;
    }
    public void setQualification(String qualification){
        this.qualification = qualification;
    }
    public void setDateJoined(String dateJoined){
        this.dateJoined = dateJoined;
    }
}
