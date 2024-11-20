import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        BST bst = new BST();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Modify");
            System.out.println("4. Lookup");
            System.out.println("5. List number of records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    int key = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter street address: ");
                    String streetAddress = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter state: ");
                    String state = scanner.nextLine();
                    System.out.print("Enter zip: ");
                    String zip = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    bst.insert(key, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
                    System.out.println("Record added successfully.");
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    key = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bst.delete(key);
                    System.out.println("Record deleted successfully.");
                    break;
                case 3:
                    System.out.print("Enter key to modify: ");
                    key = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter field to modify: ");
                    String field = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = scanner.nextLine();
                    bst.modify(key, field, newValue);
                    System.out.println("Record modified successfully.");
                    break;
                case 4:
                    System.out.print("Enter key to lookup: ");
                    key = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter order (preorder, inorder, postorder): ");
                    String order = scanner.nextLine();
                    bst.lookup(key, order);
                    break;
                case 5:
                    System.out.println("Number of records: " + bst.countNodes());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
