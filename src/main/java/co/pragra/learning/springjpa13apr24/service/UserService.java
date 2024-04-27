package co.pragra.learning.springjpa13apr24.service;

import co.pragra.learning.springjpa13apr24.dto.UserDTO;
import co.pragra.learning.springjpa13apr24.entities.ApplicationUser;
import co.pragra.learning.springjpa13apr24.entities.Review;
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
        Optional<ApplicationUser> optionalApplicationUser = applicationUserRepo.findById(user.getUserId());;
        if(optionalApplicationUser.isPresent()){
            updatedUser = Optional.ofNullable(addUser(user));
            return updatedUser;
        }
        return updatedUser;
    }

    public UserDTO getUserById(Integer id){
//        ApplicationUser applicationUser = applicationUserRepo.findById(id).get();
//        List<Review> reviews = applicationUser.getReviews();
        UserDTO userDTO = UserDTO.builder().build();
        Optional<ApplicationUser> applicationUser = applicationUserRepo.findById(id);
        if(applicationUser.isPresent()){
            userDTO = converApplicationUserToUserDTO(applicationUser.get());
        }
        return userDTO;
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

    private UserDTO converApplicationUserToUserDTO(ApplicationUser user){
        UserDTO dto = UserDTO.builder()
                .fName(user.getFirstName())
                .lName(user.getLastName())
                .id(user.getUserId())
                .accountInfo(user.getAccount())
                .reviews(user.getReviews())
                .emailAddress(user.getEmail())
                .build();
        return dto;
    }





}
