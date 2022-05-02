package cinema.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlreadyBookedException extends RuntimeException {

    public AlreadyBookedException(String message) {
        super(message);
    }
}
