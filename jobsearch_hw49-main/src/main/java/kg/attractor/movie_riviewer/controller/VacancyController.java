package kg.attractor.movie_riviewer.controller;

import kg.attractor.movie_riviewer.model.Vacancy;
import kg.attractor.movie_riviewer.repository.VacancyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VacancyController {

    private final VacancyRepository vacancyRepository;

    public VacancyController(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;

        this.vacancyRepository.save(Vacancy.builder()
                .id(1)
                .name("Java Developer")
                .description("Нужен спец, который шарит в Spring")
                .salary(1500.0)
                .isActive(true)
                .createdDate(LocalDateTime.now())
                .build());
    }

    @GetMapping("/vacancies")
    public ResponseEntity<List<Vacancy>> getVacancies() {
        return ResponseEntity.ok(vacancyRepository.findAll());
    }

    @PostMapping("/vacancies")
    public ResponseEntity<Vacancy> addVacancy(@RequestBody Vacancy vacancy) {
        if (vacancy.getCreatedDate() == null) {
            vacancy.setCreatedDate(LocalDateTime.now());
        }

        vacancyRepository.save(vacancy);

        return ResponseEntity.status(HttpStatus.CREATED).body(vacancy);
    }

    @DeleteMapping("/vacancies/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable Integer id) {
        vacancyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}