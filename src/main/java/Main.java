import java.util.Scanner;
import java.util.UUID;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        User user = null;

        System.out.println("Welcome to LusfugiessBank!");
        while(true) {
            System.out.println("1. Register new user");
            System.out.println("2. Log in");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Balance: ");
                    double balance = scanner.nextDouble();

                    user = new User(name, gender, balance);
                    bank.addUser(user);
                    System.out.println("User registered successfully. Your login account number is: " + user.getAccountNumber() + " and your PIN is: " + user.getPin());
                    System.out.println("!!!!!!!!!!!!SAVE THIS INFORAMTION!!!!!!!!!!!");
                    break;
                case 2:
                    System.out.print("Enter your account number: ");
                    String accountNumber = scanner.next();

                    System.out.print("Enter your PIN: ");
                    String pin = scanner.next();

                    User loggedInUser = bank.findUser(accountNumber, pin);
                    if (loggedInUser == null) {
                        System.out.println("Invalid account number or PIN. Please try again.");
                        break;
                    }
                    System.out.println("Logged in successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            if (bank.getLoggedInUser() != null) {
                break;
            }
        }

        User loggedInUser = bank.getLoggedInUser();


        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Credit");
            System.out.println("2. Debit");
            System.out.println("3. Show balance");
            System.out.println("4. User information");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = scanner.nextDouble();
                    bank.credit(creditAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = scanner.nextDouble();
                    bank.debit(debitAmount);
                    break;
                case 3:
                    bank.showBalance();
                    break;
                case 4:
                    System.out.println("Name: " + user.getName());
                    System.out.println("Gender: " + user.getGender());
                    System.out.println("Account number: " + user.getAccountNumber());
                    System.out.println("Balance: " + user.getBalance());
                    break;
                case 5:
                    System.out.println("Thank you for using our bank. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }
        }
    }
}
