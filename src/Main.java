import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static IAccount normalAccount,savingAccount,childAccount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        checkInput(scanner);
    }

    private static void checkInput(Scanner scanner){
        System.out.println("Welcome to my little bank :D");
        System.out.println("1. Create an account");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("Please select an option.");
        while (true) {
            for (int i = 1; i > 4; i++) {
                if (scanner.nextInt() == 1) {
                    createAccount(scanner);
                } else if (scanner.nextInt() == 2) {
                    checkBalance(scanner);
                } else if (scanner.nextInt() == 3) {
                    depositBalance(scanner);
                } else if (scanner.nextInt() == 4) {
                    withdrawBalance(scanner);
                } else {
                    checkInput(scanner);
                }
            }
        }
    }


    private static void checkBalance(Scanner scanner){
        System.out.println("Please choose an account:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Child Account");
        if(scanner.nextInt() == 1){
            System.out.println(normalAccount.getBalance());
        }
        if(scanner.nextInt() == 2){
            System.out.println(savingAccount.getBalance());
        }
        if(scanner.nextInt() == 3){
            System.out.println(childAccount.getBalance());
        }else{
            checkInput(scanner);
        }
    }

    private static void depositBalance(Scanner scanner){
        System.out.println("Please choose an account:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Child Account");
        if (scanner.nextInt() == 1) {
            System.out.println("Please enter the amount you want to deposit.");
            int amount = scanner.nextInt();
            normalAccount.deposit(amount);
            System.out.println(amount + " has been deposit into your account");
        }
        if (scanner.nextInt() == 2) {
            System.out.println("Please enter the amount you want to deposit.");
            int amount = scanner.nextInt();
            savingAccount.deposit(amount);
            System.out.println(amount + " has been deposit into your account");

        }
        if (scanner.nextInt() == 3) {
            System.out.println("Please enter the amount you want to deposit.");
            int amount = scanner.nextInt();
            childAccount.deposit(amount);
            System.out.println(amount + " has been deposit into your account");
        }else{
            checkInput(scanner);
        }
    }

    private static void withdrawBalance(Scanner scanner){
        System.out.println("Please choose an account:");
        System.out.println("1. Normal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Child Account");
        if (scanner.nextInt() == 1) {
            System.out.println("Please enter the amount you want to deposit.");
            int amount = scanner.nextInt();
            normalAccount.withdraw(amount);
            System.out.println(amount + " has been taken off your account");
        }
        if (scanner.nextInt() == 2) {
            System.out.println("Please enter the amount you want to deposit.");
            int amount = scanner.nextInt();
            savingAccount.withdraw(amount);
            System.out.println(amount + " has been taken off your account");

        }
        if (scanner.nextInt() == 3) {
            System.out.println("Please enter the amount you want to deposit.");
            int amount = scanner.nextInt();
            childAccount.withdraw(amount);
            System.out.println(amount + " has been taken off your account");
        }else{
            checkInput(scanner);
        }
    }

    private static void createAccount(Scanner scanner){
            System.out.print("Please enter your name: ");
            String name = scanner.next();
            System.out.println("Please enter your balance: ");
            int balance = scanner.nextInt();

            System.out.println("Please select an option");
            System.out.println("1. Normal Account");
            System.out.println("2. Saving Account");
            System.out.println("3. Child Account");
            if(scanner.nextInt() == 1){
                normalAccount = new Account(UUID.randomUUID(), name, balance);
                System.out.println("Account created successfully");
                checkInput(scanner);
            }
            if(scanner.nextInt() == 2){
                System.out.println("Please enter how many years do you want the interest to continue");
                savingAccount = new SavingAccount(UUID.randomUUID(), name, balance,scanner.nextInt());
                System.out.println("Account created successfully");
                checkInput(scanner);

            }
            if(scanner.nextInt() == 3){
                System.out.println("Please enter the child's name");
                String child = scanner.nextLine();
                System.out.println("Please enter the maximum withdraw balance");
                int maximumWithdraw = scanner.nextInt();
                childAccount = new ChildAccount(UUID.randomUUID(),name, child, balance, maximumWithdraw);
                System.out.println("Account created successfully");
                checkInput(scanner);

            }else{
                checkInput(scanner);
            }

    }
}