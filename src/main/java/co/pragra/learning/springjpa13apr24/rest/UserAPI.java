package co.pragra.learning.springjpa13apr24.rest;

import co.pragra.learning.springjpa13apr24.entities.ApplicationUser;
import co.pragra.learning.springjpa13apr24.repositories.ApplicationUserRepo;
import co.pragra.learning.springjpa13apr24.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserAPI {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody ApplicationUser user){
        userService.addUser(user);
        return "Data has been persisited in database successfully";
    }
}
