package co.pragra.learning.springjpa13apr24.repositories;

import co.pragra.learning.springjpa13apr24.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationUserRepo extends JpaRepository<ApplicationUser, Integer> {
    List<ApplicationUser> findAllByFirstName(String firstName);

    @Query("SELECT au FROM ApplicationUser au WHERE au.firstName = ?1")
    List<ApplicationUser> byFName(String firstName);

    @Query("SELECT au.lastName FROM ApplicationUser au where au.firstName = ?1")
    List<String> lstNmfrmFn(String firstName);

    @Query(value = "SELECT au.first_name FROM app_user au where au.last_name = ?1", nativeQuery = true)
    List<String> fstNmFromLn(String lastName);

    // SQL queries, 2 ways: 1) JPQL/HQL 2) Native query
//DataAccessException
}
