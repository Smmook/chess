package chess.model;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private boolean hasMoved;

    public King(PieceColor color) {
        super(PieceType.KING, color);
        this.hasMoved = false;
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

    @Override
    protected void checkDirection(List<Location> moves, int fileOffset, int rankOffset) {
        Board board = Board.getInstance();
        Location next = Location.build(getLocation(), fileOffset, rankOffset);
        if (board.contains(next)) {
            if (board.getPiece(next) == null) {
                moves.add(next);
            } else if (board.getPiece(next).getColor() != getColor()) {
                moves.add(next);
            }
        }
    }
}
