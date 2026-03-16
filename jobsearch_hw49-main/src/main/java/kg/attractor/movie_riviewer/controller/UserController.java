package kg.attractor.movie_riviewer.controller;

import kg.attractor.movie_riviewer.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import kg.attractor.movie_riviewer.model.User;
import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userRepository.save(User.builder()
                .id(1)
                .name("Tyler")
                .surname("Durden")
                .email("soap@projectmayhem.com")
                .accountType("APPLICANT")
                .build());
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
