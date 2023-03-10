import java.util.ArrayList;

public class Bank {
    private ArrayList<User> users;
    private User loggedInUser;

    public Bank() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUser(String accountNumber, String pin) {
        for (User user : users) {
            if (user.getAccountNumber().equals(accountNumber) && user.getPin().equals(pin)) {
                loggedInUser = user;
                return user;
            }
        }
        return null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void credit(double amount) {
        loggedInUser.setBalance(loggedInUser.getBalance() + amount);
        System.out.println("Credited " + amount + " successfully.");
    }

    public void debit(double amount) {
        if (loggedInUser.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }
        loggedInUser.setBalance(loggedInUser.getBalance() - amount);
        System.out.println("Debited " + amount + " successfully.");
    }

    public void showBalance() {
        System.out.println("Your current balance is " + loggedInUser.getBalance() + ".");
    }
}