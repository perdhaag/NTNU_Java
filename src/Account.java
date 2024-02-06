public class Account {
    private double balance;
    private double interestRate;

    public Account(double balance, double interestRate) throws IllegalArgumentException {

        //Validate positive values for initialAmount and Interest.
        if(balance < 0 || interestRate < 0){
            throw new IllegalArgumentException("Both initialamount and interest have positive values");
        }

        this.balance = balance;
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void deposit(double amount) throws IllegalArgumentException{
        if(amount < 0){
            throw new IllegalArgumentException("Amount must be larger than 0");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException{
        if (amount < 0){
            throw new IllegalArgumentException("Amount must be larger than 0");
        }
        if(balance - amount < 0){
            throw new IllegalArgumentException("Amount cannot be larger than balance");
        }

        balance -= amount;
    }

    public void addInterest(){
        balance = balance * interestRate;
    }
}
