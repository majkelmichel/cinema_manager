package cinema.domain.cinema;

import java.util.UUID;

public class Seat {
    private int row;
    private int column;
    private boolean booked;
    private UUID token;

    public Seat() {
    }

    public Seat(int row, int column, boolean booked) {
        this.row = row;
        this.column = column;
        this.booked = booked;
        this.token = UUID.randomUUID();
    }

    public void regenerateToken() {
        this.token = UUID.randomUUID();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", column=" + column +
                ", booked=" + booked +
                ", token=" + token +
                '}';
    }
}
