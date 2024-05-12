package co.pragra.learning.springjpa13apr24.service;

import co.pragra.learning.springjpa13apr24.dto.GitUserDTO;
import co.pragra.learning.springjpa13apr24.dto.UserDTO;
import co.pragra.learning.springjpa13apr24.feignConsumer.GitUserFeignClient;

import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Service
public class GitHubService {
    @Autowired
    RestTemplate template;
    @Autowired
    GitUserFeignClient gitUserFeignClient;

    Logger logger = LoggerFactory.getLogger(GitHubService.class);

    public GitUserDTO getGitHubUser(String username){
        GitUserDTO gitUserDTO = template.getForObject("https://api.github.com/users/"+username,GitUserDTO.class);
        return gitUserDTO;
    }

    public GitUserDTO getGitUserwithWebClient(String username){
        //logger.info(Instant.now() + " Method Invoked: GitHubService.class: getGitUserwithWebClient, Parameters: username = " + username);
        WebClient webClient = WebClient.builder().build();
        GitUserDTO gitUserDTOMono = webClient
                .get()
                .uri("https://api.github.com/users/" + username)
                .retrieve()
                .bodyToMono(GitUserDTO.class)
                .timeout(Duration.ofMillis(1000))
                .block();
        //logger.info(Instant.now() + " Method Finished: GitHubService.class: getGitUserwithWebClient, return:  " + gitUserDTOMono);
        return gitUserDTOMono;
    }

    public GitUserDTO getGitUserwithFeign(String username){
        return gitUserFeignClient.getGitHubUserwithFeignClient(username);
    }
}
