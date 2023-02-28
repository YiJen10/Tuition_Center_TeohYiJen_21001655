public class Name {
    private String f_name;
    private String m_name;
    private String l_name;
    public String full_name;

    public Name(){
        f_name="";
        m_name="";
        l_name="";
    }

    public Name(String fname,String mname, String lname){
        this.f_name = fname;
        this.m_name = mname;
        this.l_name = lname;
        this.full_name = fname+" "+mname+" "+lname;
    }
    public void setFName(String f_name){
        this.f_name = f_name;
    }
    public void setMName(String m_name){
        this.m_name = m_name;
    }
    public void setLName(String l_name){
        this.l_name = l_name;
    }
    public  String getFullName(){
        return f_name+" "+m_name+" "+l_name;
    }
    public String getFirstName(){
        return f_name;
    }
    public String getMiddleName(){
        return m_name;
    }
    public String getLastName(){
        return l_name;
    }
}
