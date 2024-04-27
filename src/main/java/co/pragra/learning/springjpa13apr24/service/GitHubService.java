package co.pragra.learning.springjpa13apr24.service;

import co.pragra.learning.springjpa13apr24.dto.GitUserDTO;
import co.pragra.learning.springjpa13apr24.dto.UserDTO;
import co.pragra.learning.springjpa13apr24.feignConsumer.GitUserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class GitHubService {
    @Autowired
    RestTemplate template;
    @Autowired
    GitUserFeignClient gitUserFeignClient;

    public GitUserDTO getGitHubUser(String username){
        GitUserDTO gitUserDTO = template.getForObject("https://api.github.com/users/"+username,GitUserDTO.class);
        return gitUserDTO;
    }

    public GitUserDTO getGitUserwithWebClient(String username){
        WebClient webClient = WebClient.builder().build();
        GitUserDTO gitUserDTOMono = webClient
                .get()
                .uri("https://api.github.com/users/" + username)
                .retrieve()
                .bodyToMono(GitUserDTO.class)
                .timeout(Duration.ofMillis(1000))
                .block();
        return gitUserDTOMono;
    }

    public GitUserDTO getGitUserwithFeign(String username){
        return gitUserFeignClient.getGitHubUserwithFeignClient(username);
    }
}
