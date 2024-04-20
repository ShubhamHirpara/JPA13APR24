package co.pragra.learning.springjpa13apr24.repositories;

import co.pragra.learning.springjpa13apr24.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
}
