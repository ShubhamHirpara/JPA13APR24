package co.pragra.learning.springjpa13apr24.repositories;

import co.pragra.learning.springjpa13apr24.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}
