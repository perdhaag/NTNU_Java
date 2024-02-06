package Nim;

import java.text.MessageFormat;
import java.util.ArrayList;

public class Nim {

    private ArrayList<Pile> Piles = new ArrayList<>();

    public Nim(int pileSize){
        for(int i = 0; i < 3; i++){
            Piles.add(new Pile(pileSize));
        }
    }

    public void removePieces(int number, int targetPile){
        var pile = Piles.get(targetPile);
        pile.setAmount(number);
    }

    public int getRemainingPileAmount(int pileNo){
        return Piles.get(pileNo).getAmount();
    }

    @Override
    public String toString() {
        return MessageFormat.format("Nim'{'Pile 1: {0} | Pile 2: {1} | Pile 3: {2} | '}'",
                Piles.get(0).getAmount(), Piles.get(1).getAmount(), Piles.get(2).getAmount());
    }
}
