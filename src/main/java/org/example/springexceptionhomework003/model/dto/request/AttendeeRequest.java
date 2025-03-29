package org.example.springexceptionhomework003.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
    @NotBlank(message = "please input attendee name , do not blank !")
    private String attendeeName;
    @Email(message = "please input email ,ex: google@gmail.com")
    private String email;
}
