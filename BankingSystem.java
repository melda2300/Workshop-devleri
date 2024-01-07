import java.util.Scanner;
public class BankingSystem {
    static final int MAX_ACCOUNTS = 100;
    String[] accountNumbers;
    String[] accountHolders;
    double[] accountBalance;
    int numberOfAccounts;

    public BankingSystem() {
        accountHolders = new String[MAX_ACCOUNTS];
        accountNumbers = new String[MAX_ACCOUNTS];
        accountBalance = new double[MAX_ACCOUNTS];
        numberOfAccounts = 0;
    }

    public void createAccount(String name) {
        if (numberOfAccounts < MAX_ACCOUNTS) {
            String accountNumber = generateAccountNumber();
            accountNumbers[numberOfAccounts] = accountNumber;
            accountHolders[numberOfAccounts] = name;
            accountBalance[numberOfAccounts] = 0.0;
            numberOfAccounts++;
            System.out.println("Account Created Successfully."); // Hesap Başarıyla Oluşturuldu
            System.out.println("Your account number: " + accountNumber); //Hesap Numaranız:
        } else {
            System.out.println("Maximum number of accounts reached");// Maksimum hesap sayısına ulaşıldı
        }
    }

    public String generateAccountNumber() {
        return "ACC" + (1000 + numberOfAccounts);
    }

    public void depositFunds(String accountNumber, double amount) {
        int accountIndex = findAccountIndex(accountNumber);

        if (accountIndex != -1) {
            accountBalance[accountIndex] += amount;
            System.out.println("Deposit successful. Current Balance: " + accountBalance[accountIndex]); // Para yatırma işlemi başarılı. Güncel Bakiye:
        } else {
            System.out.println("Invalid account number!"); // Geçersiz hesap numarası!
        }
    }

    public void withdrawFunds(String accountNumber, double amount) {
        int accountIndex = findAccountIndex(accountNumber);

        if (accountIndex != -1) {
            if (accountBalance[accountIndex] >= amount) {
                accountBalance[accountIndex] -= amount;
                System.out.println("Withdrawal successful. Current Balance: " + accountBalance[accountIndex]); // Para çekme işlemi başarılı. Güncel Bakiye:
            } else {
                System.out.println("Insufficient funds for withdrawal."); // Çekilmek istenen miktar için yeterli bakiye yok
            }
        } else {
            System.out.println("Invalid account number!"); // Geçersiz hesap numarası!
        }
    }

    public void checkBalance(String accountNumber) {
        int accountIndex = findAccountIndex(accountNumber);

        if (accountIndex != -1) {
            System.out.println("Account Holder: " + accountHolders[accountIndex]); //Hesap Sahibi
            System.out.println("Current Balance: " + accountBalance[accountIndex]); //Güncel Bakiye
        } else {
            System.out.println("Invalid account number!"); //Geçersiz hesap numarası
        }
    }

    public int findAccountIndex(String accountNumber) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accountNumbers[i].equals(accountNumber)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingSystem main = new BankingSystem();
        while (true) {
            System.out.println("Welcome to our bank");
            System.out.println("1. Create account");// Hesap Oluştur
            System.out.println("2. Deposit amount");// Para Yatırma
            System.out.println("3. Withdraw amount");//Para Çekme
            System.out.println("4. Check balance");//Bakiye Sorgula
            System.out.println("5. Exit");

            System.out.print("Enter your choice: "); //Lütfen seçiminizi yapınız:
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    main.createAccount(name);
                    break;
                case 2:
                    System.out.println("Enter your account number: "); //Hesap Numaranızı Giriniz
                    String depositAccountNumber = scanner.next();
                    System.out.println("Enter the amount to deposit: "); //Yatırmak istediğiniz miktarı giriniz:
                    double depositAmount = scanner.nextDouble();
                    main.depositFunds(depositAccountNumber, depositAmount);
                    break;
                case 3:
                    System.out.println("Enter your account number: ");
                    String withdrawAccountNumber = scanner.next();
                    System.out.println("Enter the amount to withdraw: ");// Çekmek istediğiniz miktarı giriniz
                    double withdrawAmount = scanner.nextDouble();
                    main.withdrawFunds(withdrawAccountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Enter your account number: ");
                    String checkBalanceAccountNumber = scanner.next();
                    main.checkBalance(checkBalanceAccountNumber);
                    break;
                case 5:
                    System.out.println("Exiting the banking system.");
                    System.exit(0);
            }
        }
    }
}
