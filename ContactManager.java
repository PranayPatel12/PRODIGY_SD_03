import java.io.File;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class ContactManager {
    private List<Contact> contacts;
    private static final String fileName = "contacts.dat";
    public ContactManager(){
        contacts = loadContacts(); // loads contacts from the file
    }
    public void addContact(String name, String phone, String email){
        contacts.add(new Contact(name,phone,email));
        saveContacts();
        System.out.println("Contact added Successfully.");
    }
    public void viewContacts(){
        if(contacts.isEmpty()){
            System.out.println("No contacts found.");
            return;
        }
        for(int i=0; i<contacts.size(); i++){
            System.out.println((i+1)+". "+contacts.get(i));
        }
    }
    public void editContact(int index, String phone, String email){
        if(index>=0 && index<contacts.size()){
            contacts.get(index).setNumber(phone);
            contacts.get(index).setEmail(email);
            saveContacts();
            System.out.println("Contact updated successfully.");
        }
        else{
            System.out.println("Invalid contact index.");
        }
    }
    public void deleteContact(int index){
        if(index>=0 && index<contacts.size()){
            contacts.remove(index);
            saveContacts();
            System.out.println("Contact deleted successfully.");
        }
        else{
            System.out.println("Invalid contact index");
        }
    }
    public void saveContacts(){
        try(ObjectOutputStream writeIn = new ObjectOutputStream(new FileOutputStream(fileName))){
            writeIn.writeObject(contacts);
        }
        catch(IOException e){
            System.out.println("Error saving contacts.");
        }
    }
    private List<Contact> loadContacts(){
        File file = new File(fileName);
        if(!file.exists())  return new ArrayList<>(); // Returns new ArrayList if the file does not exist
        try(ObjectInputStream readOut = new ObjectInputStream(new FileInputStream(file))){
            return (List<Contact>) readOut.readObject(); // Reads Contacts List from the file
        }
        catch(IOException | ClassNotFoundException e){
            return new ArrayList<>(); // Returns ArrayList if there is an Error
        }
    }

}
