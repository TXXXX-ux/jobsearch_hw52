package kg.attractor.movie_riviewer.controller;

import kg.attractor.movie_riviewer.model.User;
import kg.attractor.movie_riviewer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/search")
    public User searchByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}