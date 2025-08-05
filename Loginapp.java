import java.util.ArrayList;
import java.util.Scanner;

// Make sure this is in the same folder as User.java
public class Loginapp {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Login App Menu ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting App...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }

    private static void registerUser() {
        System.out.print("Enter new username: ");
        String username = sc.nextLine();
        System.out.print("Enter new password: ");
        String password = sc.nextLine();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username or password cannot be empty.");
            return;
        }

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already taken. Try another.");
                return;
            }
        }

        users.add(new User(username, password));
        System.out.println("Registration successful!");
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.validate(username, password)) {
                System.out.println("Login successful! Welcome, " + username + "!");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }
}
