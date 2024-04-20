package co.pragra.learning.springjpa13apr24.rest;

import co.pragra.learning.springjpa13apr24.entities.ApplicationUser;
import co.pragra.learning.springjpa13apr24.repositories.ApplicationUserRepo;
import co.pragra.learning.springjpa13apr24.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/getById")
    public Optional<ApplicationUser> getUserById(@RequestParam Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/getAll")
    public List<ApplicationUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete")
    public String deleteUserById(@RequestParam Integer id){
        userService.deleteById(id);
        return "User with id: " + id + " have been deleted successfully.";
    }

    @PutMapping("/update")
    public Optional<ApplicationUser> updateUser(@RequestBody ApplicationUser user){
        return userService.updateUser(user);
    }
    @RequestMapping(value = "/firstname/{fn}",method = RequestMethod.GET)
    public List<ApplicationUser> getByfName(@PathVariable("fn") String firstName){
        return userService.getByFName(firstName);
    }

    @RequestMapping(value = "/lastname/{fn}",method = RequestMethod.GET)
    public List<String> getLnameByFName(@PathVariable("fn") String firstName){
        return userService.getLnamesByfName(firstName);
    }

    @RequestMapping(value = "/first/{ln}",method = RequestMethod.GET)
    public List<String> getFnameByLName(@PathVariable("ln") String lastName){
        return userService.getfNameBylName(lastName);
    }

}
