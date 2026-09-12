🏦 Bank Management System — Java

A console-based Bank Management System built with Java, demonstrating core Object-Oriented Programming (OOP) concepts through practical banking operations.

It provides a simple banking experience through the command line, allowing users to create accounts, manage PINs, deposit and withdraw money, transfer funds, check balances, and generate account statements.

Features • OOP Concepts • Architecture • Quick Start • Usage • Tech Stack • Project Structure • Validation • Roadmap

---

## 🚀 Features

* 🏦 Create a new bank account
* 🔢 Automatically generated account number
* 👤 Account holder management
* 🪪 Aadhaar number validation
* 💳 PAN number validation
* 🔐 4-digit PIN creation
* 🔑 PIN change functionality
* 💰 Deposit money
* 💸 Withdraw money
* 🔄 Transfer money between accounts
* 📊 Check account balance
* 📄 Generate account statement
* 👨‍💼 View all accounts
* 🔎 Search account by account number
* ⚠️ Input validation and error handling
* 🔒 Private account data using encapsulation
* 📱 Interactive console-based menu

---

## 🖥️ Project Demo

### 🏦 Main Banking Menu

Add your screenshot here:

```text
![Main Menu](screenshots/main-menu.png)
```

### 👤 Account Creation

```text
![Create Account](screenshots/create-account.png)
```

### 🔐 Account Login

```text
![Login](screenshots/login.png)
```

### 💰 Banking Operations

```text
![Banking Operations](screenshots/account-menu.png)
```

### 📄 Account Statement

```text
![Account Statement](screenshots/statement.png)
```

> 📌 Create a `screenshots` folder in your repository and put your actual screenshots inside it.

---

# 🏗️ System Architecture

```text
                    BANK MANAGEMENT SYSTEM
                              │
                              ▼
                         Main Class
                              │
             ┌────────────────┴────────────────┐
             │                                 │
             ▼                                 ▼
       Main Menu                         BankAccount Class
             │                                 │
    ┌────────┼─────────┐              ┌────────┼─────────┐
    │        │         │              │        │         │
    ▼        ▼         ▼              ▼        ▼         ▼
 Create    Login    View Accounts   Account   PIN    Transactions
 Account             (Admin)        Details         Operations
                                      │
                           ┌──────────┼──────────┐
                           │          │          │
                           ▼          ▼          ▼
                        Deposit   Withdraw   Transfer
```

---

# 🧠 OOP Concepts Used

This project is mainly focused on **Java OOP**.

## 1. Encapsulation

Sensitive account information is kept private inside the `BankAccount` class.

```java
private long accountNumber;
private String accountHolder;
private String aadhar;
private String pan;
private double balance;
private String pin;
```

Data is accessed through controlled methods such as:

```java
getAccountNumber()
getAccountHolder()
getBalance()
setAccountHolder()
setAadhar()
setPan()
```

This demonstrates **data hiding and encapsulation**.

---

## 2. Class & Object

The main class representing a bank account is:

```java
class BankAccount
```

Objects are created using:

```java
BankAccount acc = new BankAccount(
    accountNumber,
    name,
    aadhar,
    pan
);
```

---

## 3. Constructor

The constructor initializes a new account.

```java
public BankAccount(
    long accountNumber,
    String accountHolder,
    String aadhar,
    String pan
)
```

It initializes:

* Account number
* Account holder
* Aadhaar
* PAN
* Balance
* Transaction count

---

## 4. `this` Keyword

The `this` keyword is used to refer to the current object.

Example:

```java
this.accountNumber = accountNumber;
this.balance = 0;
this.transactionCount = 0;
```

---

## 5. Getters & Setters

Getter methods are used to read data:

```java
public double getBalance() {
    return balance;
}
```

Setter methods are used with validation:

```java
public void setAadhar(String aadhar) {
    if(aadhar != null && aadhar.matches("\\d{12}")) {
        this.aadhar = aadhar;
    }
}
```

---

# 💳 Banking Operations

## Deposit

Users can deposit money into their account.

```java
public void deposit(double amount)
```

Validation:

* Amount must be greater than `0`
* Balance is updated
* Transaction count increases

---

## Withdraw

Users can withdraw money using their PIN.

```java
public void withdraw(double amount, String pin)
```

The system checks:

1. PIN
2. Withdrawal amount
3. Available balance

---

## Transfer

Money can be transferred from one bank account to another.

```java
public void transfer(
    BankAccount target,
    double amount,
    String pin
)
```

The system validates:

* PIN
* Amount
* Sender balance
* Target account

---

# 🔐 Security & Validation

The project includes basic validation mechanisms.

### Aadhaar Validation

```java
aadhar.matches("\\d{12}")
```

Accepts exactly **12 digits**.

### PAN Validation

```java
pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")
```

Example format:

```text
ABCDE1234F
```

### PIN Validation

```java
pin.matches("\\d{4}")
```

Accepts exactly **4 digits**.

### Aadhaar Masking

Instead of displaying the complete Aadhaar number:

```text
XXXX-XXXX-1234
```

### PAN Masking

The PAN is also partially hidden when displaying the statement.

---

# 📄 Account Statement

The system can generate an account statement containing:

```text
===== ACCOUNT STATEMENT =====
A/C No: 100001
Name: Ranjeet
Aadhar: XXXX-XXXX-1234
PAN: XXXXX1234F
Balance: Rs.5000.0
Transactions: 3
=============================
```

---

# 📋 Main Menu

```text
===== WELCOME TO BANKING SYSTEM =====

--- MAIN MENU ---
1. Create New Account
2. Login to Account
3. View All Accounts (Admin)
4. Exit
```

---

# 👤 Account Menu

After successful login:

```text
--- ACCOUNT MENU ---
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Transfer Money
5. Change PIN
6. Print Statement
7. Logout
```

---

# 🛠️ Tech Stack

| Technology            | Usage                     |
| --------------------- | ------------------------- |
| ☕ Java                | Core programming language |
| 🧱 OOP                | Application architecture  |
| 📦 Classes & Objects  | Data modeling             |
| 🔒 Encapsulation      | Data protection           |
| 🧮 Arrays             | Account storage           |
| 🔤 String & Regex     | Input validation          |
| ⚠️ Exception Handling | Error management          |
| 🖥️ Console           | User interface            |

---

# 📁 Project Structure

```text
Bank-Management-System/
│
├── src/
│   └── Main.java
│
├── screenshots/
│   ├── main-menu.png
│   ├── create-account.png
│   ├── login.png
│   ├── account-menu.png
│   └── statement.png
│
├── README.md
└── LICENSE
```

> Depending on your IDE, the Java source file may be located directly in the project root instead of `src/`.

---

# ⚙️ How to Run

## 1️⃣ Clone Repository

```bash
git clone https://github.com/ranjeet-dev123/Bank-Management-System.git
```

## 2️⃣ Open Project

Open the project in:

* IntelliJ IDEA
* Eclipse
* VS Code
* NetBeans

## 3️⃣ Compile

```bash
javac Main.java
```

## 4️⃣ Run

```bash
java Main
```

---

# 💡 Example Workflow

```text
Start Application
       │
       ▼
Create Account
       │
       ▼
Set 4-Digit PIN
       │
       ▼
Login
       │
       ▼
Account Menu
       │
       ├── Check Balance
       ├── Deposit
       ├── Withdraw
       ├── Transfer
       ├── Change PIN
       └── Statement
       │
       ▼
Logout
```

---

# 📈 Future Improvements

The current version is a **console-based Java application**. Future versions can include:

* [ ] MySQL database integration
* [ ] JDBC connectivity
* [ ] Multiple user roles
* [ ] Admin authentication
* [ ] Transaction history
* [ ] Transaction IDs
* [ ] Date & time for transactions
* [ ] Interest calculation
* [ ] Account deletion
* [ ] Account update
* [ ] Java Swing GUI
* [ ] JavaFX interface
* [ ] Spring Boot REST API
* [ ] React frontend
* [ ] Password/PIN hashing
* [ ] Persistent database storage

---

# 🎯 Learning Objectives

This project helped demonstrate practical understanding of:

* Java Classes & Objects
* Constructors
* Encapsulation
* Access Modifiers
* `this` keyword
* Getters & Setters
* Method creation
* Conditional statements
* Loops
* Arrays
* String handling
* Regular Expressions
* Exception Handling
* Input validation
* Object-to-object interaction

---

# 👨‍💻 Author

**Ranjeet**

B.Tech CSE Student | Java & Backend Development

GitHub: [ranjeet-dev123](https://github.com/ranjeet-dev123)

---

# ⭐ Support

If you find this project useful for learning **Java and OOP**, consider giving the repository a ⭐.

---

## 📜 License

This project is available under the **MIT License**.
