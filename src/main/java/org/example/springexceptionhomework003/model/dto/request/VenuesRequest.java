package org.example.springexceptionhomework003.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexceptionhomework003.model.entity.Venues;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenuesRequest {
    @NotBlank(message = "please input name , do not blank !")
//    @Size(min = 3,max = 50,message = "please input start from 3 character")
    private String venuesName;
    @NotBlank(message = "please input name of location , do not blank !")
//    @Size(min = 3,max = 60, message = "please input start from 3 character")
    private String location;

}
