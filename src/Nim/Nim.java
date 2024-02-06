package Nim;

import java.text.MessageFormat;
import java.util.ArrayList;

public class Nim {

    private final ArrayList<Pile> piles = new ArrayList<>();

    public Nim(int pileSize){
        for(int i = 0; i < 3; i++){
            piles.add(new Pile(pileSize));
        }
    }

    public void removePieces(int number, int targetPile){
        var pile = piles.get(targetPile);
        pile.setAmount(number);
    }

    public int getRemainingPileAmount(int pileNo){
        return piles.get(pileNo).getAmount();
    }

    @Override
    public String toString() {
        return MessageFormat.format("Nim'{'Pile 1: {0} | Pile 2: {1} | Pile 3: {2} | '}'",
                piles.get(0).getAmount(), piles.get(1).getAmount(), piles.get(2).getAmount());
    }
}
