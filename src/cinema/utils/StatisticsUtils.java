package cinema.utils;

import cinema.response.statistics.StatisticsResponse;
import cinema.services.StatisticsService;

public class StatisticsUtils {

    public static StatisticsResponse transformToResponse(StatisticsService statisticsService) {
        return new StatisticsResponse(
                statisticsService.getCurrentIncome(),
                statisticsService.getNumberOfAvailableSeats(),
                statisticsService.getNumberOfPurchasedTickets()
        );
    }
}
