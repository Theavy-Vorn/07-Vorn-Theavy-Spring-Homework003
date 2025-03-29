package org.example.springexceptionhomework003.model.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRespone {
    private String message;
    private HttpStatus status;
}
