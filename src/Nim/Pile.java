package Nim;

public class Pile {

    private int pileIndex;
    private int amount;

    public Pile(int pileIndex, int amount) {
        this.pileIndex = pileIndex;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void removeTiles(int amount) {
        this.amount -= amount;
    }

    public int getPileIndex() {
        return pileIndex;
    }

    public void setPileIndex(int pileIndex) {
        this.pileIndex = pileIndex;
    }
}
