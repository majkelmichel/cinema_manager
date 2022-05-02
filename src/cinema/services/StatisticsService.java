package cinema.services;

import cinema.domain.cinema.Seat;
import cinema.utils.SeatUtils;

public class StatisticsService {

    private int currentIncome = 0;
    private int numberOfAvailableSeats = 81;
    private int numberOfPurchasedTickets = 0;

    public StatisticsService() {
    }

    public synchronized void sold(Seat seat) {
        numberOfAvailableSeats--;
        numberOfPurchasedTickets++;
        currentIncome += SeatUtils.getPrice(seat);
    }

    public synchronized void refunded(Seat seat) {
        numberOfAvailableSeats++;
        numberOfPurchasedTickets--;
        currentIncome -= SeatUtils.getPrice(seat);
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }
}
