package co.pragra.learning.springjpa13apr24.rest;

import co.pragra.learning.springjpa13apr24.dto.UserDTO;
import co.pragra.learning.springjpa13apr24.entities.ApplicationUser;
import co.pragra.learning.springjpa13apr24.repositories.ApplicationUserRepo;
import co.pragra.learning.springjpa13apr24.service.UserService;
import org.apache.el.lang.ELArithmetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<UserDTO> getUserById(@RequestParam Integer id){
        UserDTO userById = userService.getUserById(id);
        userById = null;
        if(Objects.nonNull(userById)){
            return ResponseEntity.status(250).header("status","1305")
                    .header("Content-Type","APPLICATION/JSON")
                    .body(userById);
        }
        return ResponseEntity.status(503).header("Error","Data not Found").build();
        //return userService.getUserById(id); // writing in Http response body
    }
    //1108,1209

//    @GetMapping("/getAll")
//    public List<ApplicationUser> getAllUsers(){
//        return userService.getAllUsers();
//    }

    @GetMapping("/getAll")
    public List<String> getAllUsers(){
        List<ApplicationUser> allUsers = userService.getAllUsers();
        List<String> reviewDescs = allUsers.stream().flatMap(u -> u.getReviews().stream().map(r -> r.getReviewDesc())).collect(Collectors.toList());
        return reviewDescs;
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
