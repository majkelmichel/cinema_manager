package cinema.controllers;

import cinema.domain.cinema.Seat;
import cinema.domain.exceptions.AlreadyBookedException;
import cinema.domain.exceptions.RowColumnBoundsException;
import cinema.domain.exceptions.WrongTokenException;
import cinema.request.cinema.RefundRequest;
import cinema.request.cinema.SeatRequest;
import cinema.response.cinema.CinemaInfoWithPrices;
import cinema.response.cinema.PurchasedTicket;
import cinema.response.cinema.ReturnedTicket;
import cinema.services.CinemaService;
import cinema.services.StatisticsService;
import cinema.utils.SeatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController {

    final
    CinemaService cinemaService;
    private final StatisticsService statisticsService;


    @Autowired
    public CinemaController(CinemaService cinemaService, StatisticsService statisticsService) {
        this.cinemaService = cinemaService;
        this.statisticsService = statisticsService;
    }

    @GetMapping("/seats")
    public CinemaInfoWithPrices getCinemaInformation() {
        return new CinemaInfoWithPrices(cinemaService);
    }

    @PostMapping("/purchase")
    public PurchasedTicket purchaseTicket(@RequestBody SeatRequest seat) {
        Seat returned = cinemaService.book(seat.getRow(), seat.getColumn());
        statisticsService.sold(returned);
        return SeatUtils.transformToPurchased(returned);
    }

    @PostMapping("/return")
    public ReturnedTicket refundTicket(@RequestBody RefundRequest refundRequest) {
        UUID token = UUID.fromString(refundRequest.getToken());
        Seat refunded = cinemaService.refund(token);
        statisticsService.refunded(refunded);
        return SeatUtils.transformToReturned(refunded);
    }

    @ExceptionHandler({RowColumnBoundsException.class})
    public ResponseEntity<Map<String, String>> handleRowColumnBoundsException() {
        return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AlreadyBookedException.class})
    public ResponseEntity<Map<String, String>> handleAlreadyBookedException() {
        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({WrongTokenException.class})
    public ResponseEntity<Map<String, String>> handleWrongTicketException() {
        return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
    }
}
