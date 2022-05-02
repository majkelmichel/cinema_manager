package cinema.config;

import cinema.services.StatisticsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatisticsConfiguration {

    @Bean
    StatisticsService statisticsService() {
        return new StatisticsService();
    }
}
