//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var account = new Account(1000, 1.05);

        System.out.println(account.getBalance());
        System.out.println(account.getInterestRate());

        account.deposit(5000);
        System.out.println(account.getBalance());

    }
}