package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(PieceColor color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public List<Location> getMoves() {
        List<Location> moves = new ArrayList<>();
        checkDirection(moves, 1, 1);
        checkDirection(moves, -1, 1);
        checkDirection(moves, 1, -1);
        checkDirection(moves, -1, -1);
        return moves;
    }
}
