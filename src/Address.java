public class Address {
    String unitNo;
    String street;
    String postcode;
    String district;
    String state;

    public Address(String unitNo, String street, String postcode, String district, String state){
        this.unitNo = unitNo;
        this.street = street;
        this.postcode = postcode;
        this.district = district;
        this.state = state;
    }
    public String getUnitNo(){
        return unitNo;
    }
    public String getStreet(){
        return street;
    }
    public String getPostcode(){
        return postcode;
    }
    public String getDistrict(){
        return district;
    }
    public String getState(){
        return state;
    }
    public String getFullAddress(){
        return unitNo+","+street+","+postcode+" "+district+","+state;
    }
}

