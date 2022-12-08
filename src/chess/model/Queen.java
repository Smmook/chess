package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(PieceColor color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public List<Location> getMoves() {
        List<Location> moves = new ArrayList<>();
        checkDirection(moves, 1, 0);
        checkDirection(moves, 1, 1);
        checkDirection(moves, 0, 1);
        checkDirection(moves, -1, 1);
        checkDirection(moves, -1, 0);
        checkDirection(moves, -1, -1);
        checkDirection(moves, 0, -1);
        checkDirection(moves, 1, -1);
        return moves;
    }
}
