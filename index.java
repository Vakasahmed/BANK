import java.util.Scanner;

class BankDetails {
    private String accNumber;
    private String name;
    private long balance;
    Scanner sc = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Create Account No: ");
        accNumber = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accNumber);
        System.out.println("Balance: " + balance);
    }

    public void showBalance() {
        System.out.println("Your account balance is " + balance);
    }

    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
    }

    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    public boolean search(String ac_no) {
        if (accNumber.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

class BankingApp {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many acounts do you want to open?");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new BankDetails();
            C[i].createAccount();
        }
        int ch;
        do {
            System.out.println(
                    "1. Search by Account number\n 2. Deposit the amount \n 3. Withdraw the amount \n 4.Show Balance ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account doesn't exist..!!");
                    }
                    break;
                case 2:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].showBalance();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account doesn't exist..!!");
                    }
                    break;
            }
        } while (ch != 4);
    }
}