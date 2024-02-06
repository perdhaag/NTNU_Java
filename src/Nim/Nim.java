package Nim;

import java.util.Arrays;

public class Nim {
    Pile[] piles = new Pile[3];
    NimPlayer playerOne;
    NimPlayer playerTwo;
    NimPlayer currentPlayer;

    public Nim(int pileSize) {
        for (int i = 0; i < 3; i++) {
            piles[i] = new Pile(pileSize, i);
        }
    }

    public Nim(int pileSize, NimPlayer playerOne, NimPlayer playerTwo) {
        for (int i = 0; i < 3; i++) {
            piles[i] = new Pile(i, pileSize);
        }
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        currentPlayer = playerOne;
    }

    public NimPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void changeCurrentPlayer() {
        currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;
    }

    public void removePieces(NimPlayer player, int number) throws IllegalStateException {
        if (!isValidMove(number, player.getSelectedPile()))
            throw new IllegalStateException("The move is not valid! Try again...");
        var pile = piles[player.getSelectedPile()];
        pile.removeTiles(number);
        player.incrementPlayerTurn();
    }

    public boolean isValidMove(int number, int targetPile) {
        if (targetPile < 0 || targetPile >= piles.length)
            return false;

        int pilesLeft = piles[targetPile].getAmount();
        return pilesLeft >= number;
    }

    public boolean isGameOver() {
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


    public Pile getPile(int targetPile) {
        return piles[targetPile];
    }

    @Override
    public String toString() {
        return printGameBoard();
    }
}
