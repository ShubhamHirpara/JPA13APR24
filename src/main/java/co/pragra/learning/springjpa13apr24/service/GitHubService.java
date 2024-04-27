package co.pragra.learning.springjpa13apr24.service;

import co.pragra.learning.springjpa13apr24.dto.GitUserDTO;
import co.pragra.learning.springjpa13apr24.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {
    @Autowired
    RestTemplate template;
    public GitUserDTO getGitHubUser(String username){
        GitUserDTO gitUserDTO = template.getForObject("https://api.github.com/users/"+username,GitUserDTO.class);
        return gitUserDTO;
    }
}
