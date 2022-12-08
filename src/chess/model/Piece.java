package chess.model;

import java.util.List;

public abstract class Piece {
    private final PieceType type;
    private final PieceColor color;
    private Location location;

    public Piece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    public Piece(PieceType type, PieceColor color, Location location) {
        this.type = type;
        this.color = color;
        this.location = location;
    }

    public PieceType getPieceType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract List<Location> getMoves();

    protected void checkDirection(List<Location> moves, int fileOffset, int rankOffset) {
        Location next = Location.build(this.getLocation(), fileOffset, rankOffset);
        Board board = Board.getInstance();
        while (board.contains(next)) {
            if (board.getPiece(next) == null) {
                moves.add(next);
            } else {
                if (board.getPiece(next).getColor() != this.getColor()) {
                    moves.add(next);
                }
                break;
            }
            next = Location.build(next, fileOffset, rankOffset);
        }
    }
}
