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
        if (!isValidMove(number, player.getSelectedPile().getPileIndex()))
            throw new IllegalStateException("The move is not valid! Try again...");
        var pile = piles[player.getSelectedPile().getPileIndex()];
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

        int maxPileSize = 0;

        // Find the maximum size of piles to determine the number of rows needed
        for (Pile pile : piles) {
            maxPileSize = Math.max(maxPileSize, pile.getAmount());
        }

        // Iterate vertically in reverse order
        for (int i = maxPileSize - 1; i >= 0; i--) {
            for (Pile pile : piles) {
                if (i < pile.getAmount()) {
                    board.append(String.format("[ %2d  ]", i + 1));
                } else {
                    board.append(String.format("[ %2s  ]", ""));
                }
                board.append(" ");
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
