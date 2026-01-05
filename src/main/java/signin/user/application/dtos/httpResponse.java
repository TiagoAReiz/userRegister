package signin.user.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class httpResponse {
    HttpStatus status;
    String message;
}
