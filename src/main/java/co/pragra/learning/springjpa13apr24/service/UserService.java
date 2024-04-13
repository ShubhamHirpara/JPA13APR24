package co.pragra.learning.springjpa13apr24.service;

import co.pragra.learning.springjpa13apr24.entities.ApplicationUser;
import co.pragra.learning.springjpa13apr24.repositories.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    ApplicationUserRepo applicationUserRepo;

    public boolean addUser(ApplicationUser user){
        applicationUserRepo.save(user);
        return true;
    }

}
