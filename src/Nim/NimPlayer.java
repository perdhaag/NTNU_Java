package Nim;

public class NimPlayer {
    private String name;
    private int age;
    private Pile selectedPile;
    private int performedTurns;

    public NimPlayer(String name, int age) {
        this.name = name;
        this.age = age;
        performedTurns = 0;
    }

    public void selectPile(Pile pile) {
        if (selectedPile == null)
            selectedPile = pile;
    }

    public void incrementPlayerTurn() {
        performedTurns += 1;
    }

    public int getSelectedPile() {
        return selectedPile.getPileIndex();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "NimPlayer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", performedTurns=" + performedTurns +
                '}';
    }
}
