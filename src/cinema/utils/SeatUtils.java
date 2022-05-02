package cinema.utils;

import cinema.domain.cinema.Seat;
import cinema.request.cinema.SeatRequest;
import cinema.response.cinema.PricedSeat;
import cinema.response.cinema.PurchasedTicket;
import cinema.response.cinema.ReturnedTicket;

public class SeatUtils {

    public static int getPrice(Seat seat) {
        return seat.getRow() <= 4 ? 10 : 8;
    }

    public static PricedSeat transformToPriced(Seat seat) {
        return new PricedSeat(seat.getRow(), seat.getColumn(), seat.getRow() <= 4 ? 10 : 8);
    }

    public static PurchasedTicket transformToPurchased(Seat seat) {
        return new PurchasedTicket(seat.getToken(), SeatUtils.transformToPriced(seat));
    }

    public static ReturnedTicket transformToReturned(Seat seat) {
        return new ReturnedTicket(SeatUtils.transformToPriced(seat));
    }
}
