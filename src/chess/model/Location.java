package chess.model;

import java.util.Objects;

/**
 * The square on the chess board.
 */
public class Location {
    private final File file;
    private final Integer rank;

    public Location(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public File getFile() {
        return file;
    }

    public Integer getRank() {
        return rank;
    }

    public static Location build(Location location, Integer fileOffset, Integer rankOffset) {
        try {
            return new Location(File.values()[location.getFile().ordinal() + fileOffset], location.getRank() + rankOffset);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid location: " + location);
            return null;
        }
    }

    public static Location fromIndex(int row, int col) {
        return new Location(File.values()[col], 8 - row);
    }

    @Override
    public String toString() {
        return "(" + file + ", " + rank + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return file == location.file && Objects.equals(rank, location.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
