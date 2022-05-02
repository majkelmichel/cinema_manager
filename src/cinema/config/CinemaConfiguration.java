package cinema.config;

import cinema.services.CinemaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaConfiguration {

    @Bean
    CinemaService cinemaService() {
        return new CinemaService(9, 9);
    }
}
