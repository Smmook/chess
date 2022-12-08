package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean hasMoved;
    private final int direction;

    public Pawn(PieceColor color) {
        super(PieceType.PAWN, color);
        this.direction = color == PieceColor.WHITE ? 1 : -1;
        this.hasMoved = false;
    }

    @Override
    public List<Location> getMoves() {
        List<Location> moves = new ArrayList<>();
        Board board = Board.getInstance();
        checkDiagonals(moves);
        Location front = Location.build(this.getLocation(), 0, direction);
        if (!(board.contains(front) && board.getPiece(front) == null)) return moves;
        moves.add(front);
        if (!hasMoved) {
            Location front2 = Location.build(this.getLocation(), 0, direction * 2);
            if (board.contains(front2) && board.getPiece(front2) == null) {
                moves.add(front2);
            }
        }
        return moves;
    }

    private void checkDiagonals(List<Location> moves) {
        Location left = Location.build(this.getLocation(), -1, direction);
        Location right = Location.build(this.getLocation(), 1, direction);
        Board board = Board.getInstance();
        if (board.contains(left) && board.getPiece(left) != null) {
            if (board.getPiece(left).getColor() != this.getColor()) {
                moves.add(left);
            }
        }
        if (board.contains(right) && board.getPiece(right) != null) {
            if (board.getPiece(right).getColor() != this.getColor()) {
                moves.add(right);
            }
        }
    }
}
