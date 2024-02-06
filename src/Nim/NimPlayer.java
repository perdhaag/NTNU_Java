package Nim;

public class NimPlayer {
    private final String name;
    private final int age;
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

    public int getPerformedTurns() {
        return performedTurns;
    }

    public void incrementPlayerTurn() {
        performedTurns += 1;
    }

    public Pile getSelectedPile() {
        return selectedPile;
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
