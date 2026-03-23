package kg.attractor.movie_riviewer.controller;

import kg.attractor.movie_riviewer.model.Vacancy;
import kg.attractor.movie_riviewer.service.VacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;

    @GetMapping("/vacancies/category")
    public List<Vacancy> searchByCategory(@RequestParam(required = false) String category) {
        if (category == null || category.isEmpty()) {
            log.warn("Тайлер, категория не указана, возвращаю пустой список");
            return List.of();
        }
        log.info("Тайлер, ищем вакансии по категории: {}", category);
        return vacancyService.getVacanciesByCategory(category);
    }

    @GetMapping("/vacancies")
    public List<Vacancy> getVacancies() {
        log.info("Тайлер, пришел запрос на список вакансий"); // Добавь это
        return vacancyService.getAllVacancies();
    }
}

