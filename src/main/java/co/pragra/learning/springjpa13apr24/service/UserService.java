package co.pragra.learning.springjpa13apr24.service;

import co.pragra.learning.springjpa13apr24.entities.ApplicationUser;
import co.pragra.learning.springjpa13apr24.repositories.AccountRepo;
import co.pragra.learning.springjpa13apr24.repositories.ApplicationUserRepo;
import co.pragra.learning.springjpa13apr24.repositories.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    //@Autowired
    final ApplicationUserRepo applicationUserRepo;
    final AccountRepo accountRepo;
    final ReviewRepo reviewRepo;

    public ApplicationUser addUser(ApplicationUser user){
        accountRepo.save(user.getAccount());
        reviewRepo.saveAll(user.getReviews());
        return applicationUserRepo.save(user);
    }

    public Optional<ApplicationUser> updateUser(ApplicationUser user){
        Optional<ApplicationUser> updatedUser = Optional.empty();
        Optional<ApplicationUser> optionalApplicationUser = getUserById(user.getUserId());
        if(optionalApplicationUser.isPresent()){
            updatedUser = Optional.ofNullable(addUser(user));
            return updatedUser;
        }
        return updatedUser;
    }

    public Optional<ApplicationUser> getUserById(Integer id){
        return applicationUserRepo.findById(id);
    }

    public List<ApplicationUser> getAllUsers(){
        return applicationUserRepo.findAll();
    }

    public void deleteById(Integer id){
        applicationUserRepo.deleteById(id);
    }

    public List<ApplicationUser> getByFName(String firstName){
        return applicationUserRepo.byFName(firstName);
        //return applicationUserRepo.findAllByFirstName(firstName);
    }

    public List<String> getLnamesByfName(String firstName){
        return applicationUserRepo.lstNmfrmFn(firstName);
    }

    public List<String> getfNameBylName(String lastName){
        return applicationUserRepo.fstNmFromLn(lastName);
    }





}
