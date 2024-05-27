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
                break;
            } else if (input == 2) {
                checkBalance();
                break;
            } else if (input == 3) {
                depositBalance();
                break;
            } else if (input == 4) {
                withdrawBalance();
                break;
            } else if (input == 5) {
                calculateInterst((SavingAccount) savingAccount);
                break;
            } else {
                checkInput();
            }
        }
    }

    private static void createAccount() {
        System.out.print("Please enter your name: ");
        String name = scanner.next();
        System.out.print("\nPlease enter your balance: ");
        int balance = scanner.nextInt();

        System.out.println("\nPlease select the account type");
        System.out.println("1. Normal Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Child Account\n");
        int input = scanner.nextInt();
        if (input == 1) {
            if(normalAccount == null){
                normalAccount = new Account(UUID.randomUUID(), name, balance);
                System.out.println("Account created successfully");
                checkInput();
            }else{
                System.out.println("You already have an account with this type.");
            }

        }else if (input == 2) {
            if(savingAccount == null) {
                System.out.println("Saving account type has been selected.");

                System.out.println("Please enter how many years do you want the interest to continue");
                int years = scanner.nextInt();
                savingAccount = new SavingAccount(UUID.randomUUID(), name, balance, years);
                System.out.println("Account created successfully");
                checkInput();
            }else{
                System.out.println("You already have an account with this type.");
            }
        }else if (input == 3) {
            if(childAccount == null) {
                System.out.println("Please enter the child's name");
                String child = scanner.next();
                System.out.println("Please enter the maximum withdraw balance");
                int maximumWithdraw = scanner.nextInt();
                childAccount = new ChildAccount(UUID.randomUUID(), name, child, balance, maximumWithdraw);
                System.out.println("Account created successfully");
                checkInput();
            }else{
                System.out.println("You already have an account with this type.");
            }
        } else {
            checkInput();
        }

    }

    private static void checkBalance() {
        System.out.println("============================");
        System.out.println("Please choose an account:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Child Account");
        System.out.println("============================");

        int input = scanner.nextInt();

        if (input == 1) {
            if (normalAccount != null) {
                System.out.println("Your normal account balance is: " + normalAccount.getBalance());
                checkInput();
            } else {
                System.out.println("You have not created a normal account yet!");
                checkInput();
            }
        }
        if (input == 2) {
            if (savingAccount != null) {
                System.out.println("Your saving account balance is: " + savingAccount.getBalance());
                checkInput();
            } else {
                System.out.println("You have not created an saving account yet!");
                checkInput();
            }
        }
        if (input == 3) {
            if (childAccount != null) {
                System.out.println("Your child account balance is: " + childAccount.getBalance());
                checkInput();
            } else {
                System.out.println("You have not created a child account yet!");
                checkInput();
            }
        } else {
            checkInput();
        }
    }

    private static void depositBalance() {
        System.out.println("============================");
        System.out.println("Please choose an account:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Child Account");
        System.out.println("============================");
        int input  = scanner.nextInt();
        if (input == 1) {
            if (normalAccount != null) {
                System.out.println("Please enter the amount you want to deposit.");
                int amount = scanner.nextInt();
                normalAccount.deposit(amount);
                System.out.println(amount + " has been deposit into your account");
                checkInput();
            } else {
                System.out.println("You have not created a normal account yet!");
                checkInput();
            }
        }
        if (input == 2) {
            if (savingAccount != null) {
                System.out.println("Please enter the amount you want to deposit.");
                int amount = scanner.nextInt();
                savingAccount.deposit(amount);
                System.out.println(amount + " has been deposit into your account");
                checkInput();
            } else {
                System.out.println("You have not created an saving account yet!");
                checkInput();
            }

        }
        if (input == 3) {
            if (childAccount != null) {
                System.out.println("Please enter the amount you want to deposit.");
                int amount = scanner.nextInt();
                childAccount.deposit(amount);
                checkInput();
            } else {
                System.out.println("You have not created a child account yet!");
                checkInput();
            }

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
            if (normalAccount != null) {
                System.out.println("Please enter the amount you want to withdraw.");
                int amount = scanner.nextInt();
                normalAccount.withdraw(amount);
                checkInput();
            } else {
                System.out.println("You have not created a normal account yet!");
                checkInput();
            }

        }
        if (input == 2) {
            if (savingAccount != null) {
                System.out.println("Please enter the amount you want to withdraw.");
                int amount = scanner.nextInt();
                savingAccount.withdraw(amount);
                System.out.println(amount + " has been taken off your account");
                checkInput();
            } else {
                System.out.println("You have not created an saving account yet!");
                checkInput();
            }


        }
        if (input == 3) {
            if (childAccount != null) {
                System.out.println("Please enter the amount you want to withdraw.");
                int amount = scanner.nextInt();
                childAccount.withdraw(amount);
                checkInput();
            } else {
                System.out.println("You have not created a child account yet!");
                checkInput();
            }

        } else {
            checkInput();
        }
    }

    private static void calculateInterst(SavingAccount account) {
        if (savingAccount != null) {
            double value = ((account.getYears() * account.getBalance()) * account.getInterestRate());
            System.out.println("Your interests value is: " + value);
            checkInput();
        } else {
            System.out.println("You have not created an saving account yet!");
            checkInput();
        }
    }
}