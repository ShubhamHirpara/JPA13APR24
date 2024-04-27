package co.pragra.learning.springjpa13apr24.feignConsumer;

import co.pragra.learning.springjpa13apr24.dto.GitUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "GitUserFeign", name = "GitUserFeign",url = "https://api.github.com/users")
public interface GitUserFeignClient {
    @GetMapping("/{username}")
    GitUserDTO getGitHubUserwithFeignClient(@PathVariable String username);
}
