public class Person {

    private Long id;

    private String firstname;

    private String lastname;

    private String phoneNumber;

    public Person(Long id, String firstname, String lastname, String phoneNumber){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public Long getId(){
        return this.id;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setId(Long id){
        this.id = id;
    }

      public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return this.firstname;
    }

}