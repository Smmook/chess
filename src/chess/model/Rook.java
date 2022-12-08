package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    private boolean hasMoved;
    public Rook(PieceColor color) {
        super(PieceType.ROOK, color);
        this.hasMoved = false;
    }

    @Override
    public List<Location> getMoves() {
        List<Location> moves = new ArrayList<>();
        checkDirection(moves, 1, 0);
        checkDirection(moves, -1, 0);
        checkDirection(moves, 0, 1);
        checkDirection(moves, 0, -1);
        return moves;
    }
}
