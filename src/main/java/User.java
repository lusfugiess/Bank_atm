import java.util.UUID;

public class User {
    private String name;
    private String gender;
    private String accountNumber;
    private String pin;
    private double balance;

    public User(String name, String gender, double balance) {
        this.name = name;
        this.gender = gender;
        this.balance = balance;
        this.accountNumber = UUID.randomUUID().toString();
        this.pin = generateRandomPin();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private String generateRandomPin() {
        int pin = (int) (Math.random() * 9000) + 1000;
        return Integer.toString(pin);
    }
}