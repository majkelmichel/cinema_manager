package cinema.services;

import cinema.domain.cinema.Seat;
import cinema.domain.exceptions.AlreadyBookedException;
import cinema.domain.exceptions.RowColumnBoundsException;
import cinema.domain.exceptions.WrongTokenException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CinemaService {
    private int totalRows;
    private int totalColumns;
    private List<Seat> seats = new ArrayList<>();

    public CinemaService() {
    }

    public CinemaService(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;

        for (int row = 1; row <= totalRows; row++) {
            for (int column = 1; column <= totalColumns; column++) {
                seats.add(new Seat(row, column, false));
            }
        }
    }

    public synchronized Seat book(int row, int column) {

        if (row < 0 || totalRows < row || column < 0 || column > totalColumns) {
            throw new RowColumnBoundsException("The number of a row or a column is out of bounds!");
        }

        final Seat found = seats.stream()
                .filter(seat -> seat.getColumn() == column && seat.getRow() == row).findAny().orElse(new Seat());

        if (found.isBooked()) {
            throw new AlreadyBookedException("The ticket has been already purchased!");
        }

        found.setBooked(true);

        return found;
    }

    public synchronized Seat refund(UUID token) {
        final List<Seat> seatList = seats.stream()
                .filter(seat -> seat.getToken().equals(token)).collect(Collectors.toList());

        if (seatList.isEmpty()) {
            throw new WrongTokenException("Wrong token");
        }

        final Seat found = seatList.get(0);

        found.setBooked(false);
        found.regenerateToken();

        return found;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "CinemaInformation{" +
                "totalRows=" + totalRows +
                ", totalColumns=" + totalColumns +
                ", seats=" + seats +
                '}';
    }
}
