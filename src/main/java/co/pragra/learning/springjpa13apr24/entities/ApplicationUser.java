package co.pragra.learning.springjpa13apr24.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "APP_USER")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(length = 25)
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne
    private Account account;
    @OneToMany(cascade = CascadeType.DETACH)
    private List<Review> reviews;

}
