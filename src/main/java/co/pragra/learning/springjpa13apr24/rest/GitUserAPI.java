package co.pragra.learning.springjpa13apr24.rest;

import co.pragra.learning.springjpa13apr24.dto.GitUserDTO;
import co.pragra.learning.springjpa13apr24.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gituser")
public class GitUserAPI {

    @Autowired
    GitHubService gitHubService;

    @GetMapping("/{username}")
    public GitUserDTO getUserbyUsername(@PathVariable String username){
        return gitHubService.getGitUserwithFeign(username);
    }
}
