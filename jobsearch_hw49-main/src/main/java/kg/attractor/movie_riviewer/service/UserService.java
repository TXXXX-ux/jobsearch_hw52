package kg.attractor.movie_riviewer.service;

import kg.attractor.movie_riviewer.model.User;
import kg.attractor.movie_riviewer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Получаем всех пользователей для вывода списка
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Поиск по email (то, что просили в ТЗ 51)
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Пользователь с email " + email + " не найден"));
    }

    // Поиск по номеру телефона (тоже пункт из ТЗ)
    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Пользователь с телефоном " + phone + " не найден"));
    }
}