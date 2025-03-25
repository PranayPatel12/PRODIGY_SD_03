import java.util.Scanner;
public class ContactApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while(true){
            System.out.println("\nContact Management System.");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contact");
            System.out.println("5. Exit");
            System.out.print("\nChoose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    contactManager.addContact(name,phone,email);
                    break;
                case 2:
                    contactManager.viewContacts();
                    System.out.print("Enter edit index: ");
                    int index = sc.nextInt()-1;
                    sc.nextLine();
                    System.out.print("Enter new phone: ");
                    String number = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String mail = sc.nextLine();
                    contactManager.editContact(index,number,mail);
                    break;
                case 3:
                    contactManager.viewContacts();
                    System.out.print("Enter delete index: ");
                    int ind = sc.nextInt()-1;
                    sc.nextLine();
                    contactManager.deleteContact(ind);
                    break;
                case 4:
                    contactManager.viewContacts();
                    break;
                case 5:
                    System.out.println("Exiting.....bye bye!!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
