package co.pragra.learning.springjpa13apr24.dto;

import co.pragra.learning.springjpa13apr24.entities.Account;
import co.pragra.learning.springjpa13apr24.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String fName;
    private String lName;
    private String emailAddress;
    private Account accountInfo;
    private List<Review> reviews;
}
