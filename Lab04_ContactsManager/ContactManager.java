import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    // --- TODO: REGEX HELPER METHOD ---
    public static String formatPhoneNumber(String raw) {
        // 1. Strip non-digits   
        String cleanNumber = raw.replaceAll("[^0-9]", "");
        
        // 2. Check length and format
            // Regex to group: (3 digits)(3 digits)(4 digits) -> $1-$2-$3
        String regex = "(\\d{3})(\\d{3})(\\d{4})";
        String replacement = "$1-$2-$3";

        if (cleanNumber.length() == 10)
            return cleanNumber.replaceAll(regex, replacement);
        else 
           //If not valid format, return invalid number
           return "Invalid Number";
    }

    
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();

        // Contacts to be sanitized and sorted
        contacts.add(new Contact("Zack Morris", "zack@bayside.edu", "555.123.4567"));
        contacts.add(new Contact("Alice Smith", "alice@test.com", "(555) 999-8888"));
        contacts.add(new Contact("Bob Jones", "bob@test.com", "5551112222"));
        contacts.add(new Contact("Alex", "alex@test.com", "1-5-6"));

        System.out.println("--- Cleaning Data ---");
       
        //TODO: CLEAN DATA (Loop and Format)
        for (Contact contact : contacts){
            contact.setPhoneNumber(formatPhoneNumber(contact.getPhoneNumber()));
        }
        
        
        System.out.println("--- Sorting Data ---");
        
        //TODO: SORT DATA (Bubble Sort)
        System.out.println("--- Sorting Data ---");
        for (int index = 0; index < contacts.size(); index++){
            for (int compare = 0; compare < contacts.size() - 1; compare++){
                String name1 = contacts.get(compare).getName();
                String name2 = contacts.get(compare + 1).getName();

                if (name1.compareTo(name2) > 0){
                    Contact temp = contacts.get(compare);
                    contacts.set(compare, contacts.get(compare + 1));
                    contacts.set(compare + 1, temp);
                }
            }
        }
        
        // Print sorted list
        for (Contact c : contacts) {
            System.out.println(c);
        }

        //Input name to search for
        System.out.println("\n--- Search ---");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a name to find: ");
        String searchName = scan.nextLine();
        
        boolean found = false;
        
        //TODO: Search Data for name inputted
        for (Contact contact : contacts){
            if (contact.getName().equals(searchName)){
                found = true;
                System.out.println("FOUND: " + contact);
                break;
            }
        }
        
        if (!found) { //Print not found if name is misspelled or not in list
            System.out.println("Contact not found.");
        }
        
        //closes scanner
        scan.close();
    }
}