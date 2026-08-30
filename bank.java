class BankAccount {
    private long accountNumber;
    private String accountHolder;
    private String aadhar;
    private String pan;
    private double balance;
    private String pin;
    private int transactionCount;

    // Constructor
    public BankAccount(long accountNumber, String accountHolder, String aadhar, String pan) {
        this.accountNumber = accountNumber;
        this.setAccountHolder(accountHolder);
        this.setAadhar(aadhar);
        this.setPan(pan);
        this.balance = 0;
        this.transactionCount = 0;
        System.out.println("Account created. A/C: " + accountNumber);
    }

    // Getters (Read)
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    // Aadhar & PAN — Read-only (no setter after object creation)
    public String getMaskedAadhar() {
        if(aadhar != null && aadhar.length() == 12) {
            return "XXXX-XXXX-" + aadhar.substring(8);
        }
        return "Invalid Aadhar";
    }

    public String getMaskedPan() {
        if(pan != null && pan.length() == 10) {
            return "XXXXX" + pan.substring(5);
        }
        return "Invalid PAN";
    }

    // Setters (Write with Validation)
    public void setAccountHolder(String accountHolder) {
        if(accountHolder != null && !accountHolder.isEmpty() && accountHolder.length() >= 3) {
            this.accountHolder = accountHolder;
        } else {
            throw new IllegalArgumentException("Account holder name must be at least 3 characters");
        }
    }

    public void setAadhar(String aadhar) {
        if(aadhar != null && aadhar.matches("\\d{12}")) {
            this.aadhar = aadhar;
        } else {
            throw new IllegalArgumentException("Aadhar must be 12 digits");
        }
    }

    public void setPan(String pan) {
        if(pan != null && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            this.pan = pan;
        } else {
            throw new IllegalArgumentException("Invalid PAN format");
        }
    }

    public void setPin(String oldPin, String newPin) {
        if(this.pin == null || this.pin.equals(oldPin)) {
            if(newPin != null && newPin.matches("\\d{4}")) {
                this.pin = newPin;
                System.out.println("PIN changed successfully.");
            } else {
                System.out.println("PIN must be 4 digits.");
            }
        } else {
            System.out.println("Old PIN is incorrect.");
        }
    }

    // Transaction methods
    public void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
            this.transactionCount++;
            System.out.println("Deposited: Rs." + amount + " | Balance: Rs." + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount, String pin) {
        if(!this.pin.equals(pin)) {
            System.out.println("Invalid PIN.");
            return;
        }
        if(amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if(amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        this.balance -= amount;
        this.transactionCount++;
        System.out.println("Withdrawn: Rs." + amount + " | Balance: Rs." + balance);
    }

    public void transfer(BankAccount target, double amount, String pin) {
        if(!this.pin.equals(pin)) {
            System.out.println("Invalid PIN.");
            return;
        }
        if(amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if(amount > this.balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        this.balance -= amount;
        target.balance += amount;
        this.transactionCount++;
        target.transactionCount++;
        System.out.println("Transferred Rs." + amount + " to A/C " + target.getAccountNumber());
        System.out.println("Your Balance: Rs." + this.balance);
    }

    // Statement
    public void printStatement() {
        System.out.println("\n===== ACCOUNT STATEMENT =====");
        System.out.println("A/C No: " + accountNumber);
        System.out.println("Name: " + accountHolder);
        System.out.println("Aadhar: " + getMaskedAadhar());
        System.out.println("PAN: " + getMaskedPan());
        System.out.println("Balance: Rs." + balance);
        System.out.println("Transactions: " + transactionCount);
        System.out.println("=============================\n");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(100001, "Rahul Sharma", "123456789012", "ABCDE1234F");
        BankAccount acc2 = new BankAccount(100002, "Priya Patel", "987654321098", "PQRST5678G");

        acc1.setPin(null, "1234");  // First time PIN set
        acc2.setPin(null, "5678");

        acc1.deposit(50000);
        acc2.deposit(30000);

        acc1.transfer(acc2, 15000, "1234");

        acc1.withdraw(5000, "1234");
        acc1.withdraw(5000, "1111"); // Wrong PIN

        acc1.printStatement();
        acc2.printStatement();
    }
}
