import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static IAccount normalAccount, savingAccount, childAccount;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to my little bank :D");
        checkInput();
    }

    private static void checkInput() {
        System.out.println("\n===================================\n");
        System.out.println("1. Create an account");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Calculate Interests");
        System.out.println("\nPlease select an option.\n");
        System.out.println("===================================");
        int input = scanner.nextInt();
        while (true) {
            if (input == 1) {
                createAccount();
            } else if (input == 2) {
                checkBalance();
            } else if (input == 3) {
                depositBalance();
            } else if (input == 4) {
                withdrawBalance();
            } else if (input == 5) {
                System.out.println("Your interests value is: " + calculateIntersts((SavingAccount) savingAccount));
            } else {
                checkInput();
            }

        }
    }

    private static double calculateIntersts(SavingAccount account) {
        if (savingAccount == null) {
            System.out.println("You have not created an saving account yet!");
            checkInput();
        }
        return account.calculateInterest();
    }


    private static void checkBalance() {
        System.out.println("Please choose an account:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Child Account");
        int input = scanner.nextInt();

        if (input == 1) {
            if (normalAccount != null) {
                System.out.println("Your balance is: " + normalAccount.getBalance());
                checkInput();
            }else {
                System.out.println("You have not created a normal account yet!");
                checkInput();
            }
        }
        if (input == 2) {
            if (savingAccount != null) {
                System.out.println("Your balance is: " + savingAccount.getBalance());
                checkInput();
            }else {
                System.out.println("You have not created an saving account yet!");
                checkInput();
            }
        }
        if (input == 3) {
            if (childAccount == null) {
                System.out.println("Your balance is: " + childAccount.getBalance());
                checkInput();
            }else {
                System.out.println("You have not created a child account yet!");
                checkInput();
            }
        } else {
            checkInput();
        }
    }

    private static void depositBalance() {
        System.out.println("Please choose an account:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Child Account");
        int input = scanner.nextInt();

        if (input == 1) {
            if (normalAccount == null) {
                System.out.println("You have not created a normal account yet!");
                checkInput();
            }
            System.out.println("Please enter the amount you want to deposit.");
            int amount = input;
            normalAccount.deposit(amount);
            System.out.println(amount + " has been deposit into your account");
            checkInput();
        }
        if (input == 2) {
            if (savingAccount == null) {
                System.out.println("You have not created an saving account yet!");
                checkInput();
            }
            System.out.println("Please enter the amount you want to deposit.");
            int amount = input;
            savingAccount.deposit(amount);
            System.out.println(amount + " has been deposit into your account");
            checkInput();
        }
        if (input == 3) {
            if (childAccount == null) {
                System.out.println("You have not created a child account yet!");
                checkInput();
            }
            System.out.println("Please enter the amount you want to deposit.");
            int amount = input;
            childAccount.deposit(amount);
            System.out.println(amount + " has been deposit into your account");
            checkInput();
        } else {
            checkInput();
        }
    }

    private static void withdrawBalance() {
        System.out.println("Please choose an account:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Child Account");
        int input = scanner.nextInt();
        if (input == 1) {
            if (normalAccount == null) {
                System.out.println("You have not created a normal account yet!");
                checkInput();
            }
            System.out.println("Please enter the amount you want to deposit.");
            int amount = input;
            normalAccount.withdraw(amount);
            System.out.println(amount + " has been taken off your account");
            checkInput();
        }
        if (input == 2) {
            if (savingAccount == null) {
                System.out.println("You have not created an saving account yet!");
                checkInput();
            }
            System.out.println("Please enter the amount you want to deposit.");
            int amount = input;
            savingAccount.withdraw(amount);
            System.out.println(amount + " has been taken off your account");
            checkInput();

        }
        if (input == 3) {
            if (childAccount == null) {
                System.out.println("You have not created a child account yet!");
                checkInput();
            }
            System.out.println("Please enter the amount you want to deposit.");
            int amount = input;
            childAccount.withdraw(amount);
            System.out.println(amount + " has been taken off your account");
            checkInput();
        } else {
            checkInput();
        }
    }

    private static void createAccount() {
        System.out.print("Please enter your name: ");
        String name = scanner.next();
        System.out.print("\nPlease enter your balance: ");
        int input = scanner.nextInt();

        System.out.println("\nPlease select the account type");
        System.out.println("1. Normal Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Child Account\n");
        if (input == 1) {
            normalAccount = new Account(UUID.randomUUID(), name, input);
            System.out.println("Account created successfully");
            checkInput();

        }
        if (input == 2) {

            System.out.println("Please enter how many years do you want the interest to continue");
            savingAccount = new SavingAccount(UUID.randomUUID(), name, input, input);
            System.out.println("Account created successfully");
            checkInput();

        }
        if (input == 3) {

            System.out.println("Please enter the child's name");
            String child = scanner.next();
            System.out.println("Please enter the maximum withdraw balance");
            int maximumWithdraw = input;
            childAccount = new ChildAccount(UUID.randomUUID(), name, child, input, maximumWithdraw);
            System.out.println("Account created successfully");
            checkInput();

        } else {
            checkInput();
        }

    }
}