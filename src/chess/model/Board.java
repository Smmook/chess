package chess.model;

import java.util.List;

public class Board {
    private static Board instance;
    private final static int BOARD_SIZE = 8;

    private final Piece[][] squares;
    private Board() {
        squares = new Piece[BOARD_SIZE][BOARD_SIZE];
        initBoard();
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public boolean contains(Location location) {
        if (location == null) return false;
        return location.getRank() > 0 && location.getRank() <= BOARD_SIZE;
    }

    public Piece getPiece(Location location) {
        if (location.getRank() < 1 || location.getRank() > BOARD_SIZE) {
            return null;
        }
        return squares[BOARD_SIZE - location.getRank()][location.getFile().ordinal()];
    }

    public void setPiece(Location location, Piece piece) {
        if (location.getRank() < 1 || location.getRank() > BOARD_SIZE) {
            System.out.println("Invalid location: " + location);
            return;
        }
        piece.setLocation(location);
        squares[BOARD_SIZE - location.getRank()][location.getFile().ordinal()] = piece;
    }

    private void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            setPiece(new Location(File.values()[i], 2), new Pawn(PieceColor.WHITE));
            setPiece(new Location(File.values()[i], 7), new Pawn(PieceColor.BLACK));
        }
        setPiece(new Location(File.A, 1), new Rook(PieceColor.WHITE));
        setPiece(new Location(File.H, 1), new Rook(PieceColor.WHITE));
        setPiece(new Location(File.A, 8), new Rook(PieceColor.BLACK));
        setPiece(new Location(File.H, 8), new Rook(PieceColor.BLACK));
        setPiece(new Location(File.B, 1), new Knight(PieceColor.WHITE));
        setPiece(new Location(File.G, 1), new Knight(PieceColor.WHITE));
        setPiece(new Location(File.B, 8), new Knight(PieceColor.BLACK));
        setPiece(new Location(File.G, 8), new Knight(PieceColor.BLACK));
        setPiece(new Location(File.C, 1), new Bishop(PieceColor.WHITE));
        setPiece(new Location(File.F, 1), new Bishop(PieceColor.WHITE));
        setPiece(new Location(File.C, 8), new Bishop(PieceColor.BLACK));
        setPiece(new Location(File.F, 8), new Bishop(PieceColor.BLACK));
        setPiece(new Location(File.D, 1), new Queen(PieceColor.WHITE));
        setPiece(new Location(File.D, 8), new Queen(PieceColor.BLACK));
        setPiece(new Location(File.E, 1), new King(PieceColor.WHITE));
        setPiece(new Location(File.E, 8), new King(PieceColor.BLACK));
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Piece piece = squares[i][j];
                System.out.print("[ " + (piece == null ? " " : piece.getPieceType().getSymbol()) + " ]");
            }
            System.out.println();
        }
    }

    public void printMoves(Piece p) {
        List<Location> moves = p.getMoves();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Piece piece = squares[i][j];
                System.out.print(
                        "[ " +
                        (piece == null ? " " : piece.getPieceType().getSymbol()) +
                        (moves.contains(Location.fromIndex(i, j)) ? "*" : " ") +
                        "]");
            }
            System.out.println();
        }
    }
}
