package Nim;

public class Pile {
    private int amount;

    public Pile(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount){
        this.amount -= amount;
    }
}