package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(PieceColor color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public List<Location> getMoves() {
        List<Location> moves = new ArrayList<>();
        checkMove(moves, 1, 2);
        checkMove(moves, 2, 1);
        checkMove(moves, 2, -1);
        checkMove(moves, 1, -2);
        checkMove(moves, -1, -2);
        checkMove(moves, -2, -1);
        checkMove(moves, -2, 1);
        checkMove(moves, -1, 2);
        return moves;
    }

    private void checkMove(List<Location> moves, int fileOffset, int rankOffset) {
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
