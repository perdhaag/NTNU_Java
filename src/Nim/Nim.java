package Nim;

import jdk.jshell.spi.ExecutionControl;

import java.text.MessageFormat;
import java.util.ArrayList;

public class Nim {

    Pile[] piles = new Pile[3];

    public Nim(int pileSize){
        for(int i = 0; i < 3; i++){
            piles[i] = new Pile(pileSize);
        }
    }

    public void removePieces(int number, int targetPile) {
        //isValidMove(number, targetPile);
        var pile = piles[targetPile];
        pile.setAmount(number);
    }

    private void isValidMove(int number, int targetPile) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Implement");
    }

    public int getPile(int targetPile){
        return piles[targetPile].getAmount();
    }

    @Override
    public String toString() {
        return MessageFormat.format("Nim'{'Pile 1: {0} | Pile 2: {1} | Pile 3: {2} | '}'",
                piles[0].getAmount(), piles[1].getAmount(), piles[2].getAmount());
    }
}
