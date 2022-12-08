package chess.model;

/**
 * The type of chess piece.
 */
public enum PieceType {
    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;

    public char getSymbol() {
        switch (this) {
            case PAWN:
                return 'p';
            case KNIGHT:
                return 'N';
            case BISHOP:
                return 'B';
            case ROOK:
                return 'R';
            case QUEEN:
                return 'Q';
            case KING:
                return 'K';
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
