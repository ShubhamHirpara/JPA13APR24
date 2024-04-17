package co.pragra.learning.springjpa13apr24.repositories;

import co.pragra.learning.springjpa13apr24.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepo extends JpaRepository<ApplicationUser, Integer> {
//DataAccessException
}
