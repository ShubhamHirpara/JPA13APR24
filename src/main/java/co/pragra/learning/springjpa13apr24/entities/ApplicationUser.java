package co.pragra.learning.springjpa13apr24.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicationUser {
    @Id
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
}
