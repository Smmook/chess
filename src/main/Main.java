package main;

import chess.model.*;

public class Main {
    public static void main(String[] args) {
        Board board = Board.getInstance();
        board.printMoves(board.getPiece(new Location(File.G, 1)));
    }
}
