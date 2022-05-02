package cinema.response.cinema;

import cinema.domain.cinema.Seat;
import cinema.services.CinemaService;
import cinema.utils.SeatUtils;

import java.util.ArrayList;
import java.util.List;

public class CinemaInfoWithPrices {
    private int total_rows;
    private int total_columns;
    private List<PricedSeat> available_seats = new ArrayList<>();

    public CinemaInfoWithPrices() {
    }

    public CinemaInfoWithPrices(CinemaService cinemaService) {
        for (Seat seat : cinemaService.getSeats()) {
            if (!seat.isBooked()) {
                this.available_seats.add(SeatUtils.transformToPriced(seat));
            }
        }
        this.total_columns = cinemaService.getTotalColumns();
        this.total_rows = cinemaService.getTotalRows();
    }

    public CinemaInfoWithPrices(int totalRows, int totalColumns, List<PricedSeat> seats) {
        this.total_rows = totalRows;
        this.total_columns = totalColumns;
        this.available_seats = seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int totalColumns) {
        this.total_columns = totalColumns;
    }

    public List<PricedSeat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<PricedSeat> available_seats) {
        this.available_seats = available_seats;
    }
}
