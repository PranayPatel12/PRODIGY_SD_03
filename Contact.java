import java.io.Serializable;
public class Contact implements Serializable{
    private static final long serialVersionID = 1L;
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName(){
        return name;
    }
    public String getNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setNumber(String number){
        this.phoneNumber = number;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String toString(){
        return "Name : "+name+", "+"Phone : "+phoneNumber+", "+"Email : "+email;
    }
}
