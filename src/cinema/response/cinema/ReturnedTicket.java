package cinema.response.cinema;

public class ReturnedTicket {
    private PricedSeat returned_ticket;


    public ReturnedTicket() {
    }

    public ReturnedTicket(PricedSeat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public PricedSeat getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(PricedSeat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
