package Nim;

import java.util.Arrays;

public class Nim {

    Pile[] piles = new Pile[3];

    public Nim(int pileSize){
        for(int i = 0; i < 3; i++){
            piles[i] = new Pile(pileSize);
        }
    }

    public void removePieces(int number, int targetPile) throws IllegalStateException {
        if(!isValidMove(number, targetPile))
            throw new IllegalStateException("The move is not valid! Try again...");

        var pile = piles[targetPile];
        pile.removeTiles(number);
    }

    private boolean isValidMove(int number, int targetPile)  {
        if (targetPile < 0 || targetPile >= piles.length)
            return false;

        int pilesLeft = piles[targetPile].getAmount();
        return pilesLeft >= number;
    }

    public boolean isGameOver(){
        return Arrays.stream(piles).anyMatch(x -> x.getAmount() == 0);
    }

    public String printGameBoard() {
        StringBuilder board = new StringBuilder();

        for (int index = 0; index < piles.length; index++) {
            board.append(index + 1).append(": ");

            for (int i = 0; i < piles[index].getAmount(); i++) {
                board.append(String.format("[%d]", i));
            }
            board.append(System.lineSeparator());
        }
        board.append(System.lineSeparator());

        return board.toString();
    }


    public int getPile(int targetPile){
        return piles[targetPile].getAmount();
    }

    @Override
    public String toString() {
        return printGameBoard();
    }
}
