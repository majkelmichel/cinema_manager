package cinema.response.cinema;

import java.util.UUID;

public class PurchasedTicket {
    private UUID token;
    private PricedSeat ticket;

    public PurchasedTicket() {
    }

    public PurchasedTicket(UUID token, PricedSeat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public PricedSeat getTicket() {
        return ticket;
    }

    public void setTicket(PricedSeat ticket) {
        this.ticket = ticket;
    }
}
