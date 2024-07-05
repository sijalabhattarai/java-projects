import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactList {
    static class Contact {
        private String name;
        private String phoneNumber;

        public Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phoneNumber;
        }
    }

    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Contact List");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber);
                    contacts.add(newContact);
                    System.out.println("Contact added successfully");
                    break;
                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("Contact list is empty");
                    } else {
                        System.out.println("Contacts:");
                        for (Contact contact : contacts) {
                            System.out.println(contact);
                        }
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting Contact List...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
        scanner.close();
    }
}
