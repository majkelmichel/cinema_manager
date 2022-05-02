package cinema.controllers;

import cinema.domain.exceptions.WrongPasswordException;
import cinema.response.statistics.StatisticsResponse;
import cinema.security.StatisticsPasswordValidator;
import cinema.services.StatisticsService;
import cinema.utils.StatisticsUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatisticsController {


    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping("/stats")
    public StatisticsResponse getStatistics(@RequestParam(required = false) String password) {
        StatisticsPasswordValidator.validatePassword(password);
        return StatisticsUtils.transformToResponse(statisticsService);
    }

    @ExceptionHandler({WrongPasswordException.class})
    public ResponseEntity<Map<String, String>> handleWrongPasswordException() {
        return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
    }
}
