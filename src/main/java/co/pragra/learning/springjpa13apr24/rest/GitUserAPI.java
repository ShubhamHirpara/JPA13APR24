package co.pragra.learning.springjpa13apr24.rest;

import co.pragra.learning.springjpa13apr24.dto.GitUserDTO;
import co.pragra.learning.springjpa13apr24.service.GitHubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/gituser")
public class GitUserAPI {

    @Autowired
    GitHubService gitHubService;

    Logger logger = LoggerFactory.getLogger(GitUserAPI.class);

    @GetMapping("/{username}")
    public GitUserDTO getUserbyUsername(@PathVariable String username){
        //logger.info(Instant.now() + " Method Invoked: GitUserAPI.class: getUserbyUsername, Parameters: username = " + username);

        GitUserDTO gitUserwithWebClient = gitHubService.getGitUserwithWebClient(username);
        //logger.info(Instant.now() + " Method Finished: GitUserAPI.class: getUserbyUsername, Returns: " + gitUserwithWebClient);
        return gitUserwithWebClient;
    }
}
