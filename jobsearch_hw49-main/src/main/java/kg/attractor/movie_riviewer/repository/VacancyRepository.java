package kg.attractor.movie_riviewer.repository;

import kg.attractor.movie_riviewer.model.Vacancy;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VacancyRepository {
    private final List<Vacancy> vacancies = new ArrayList<>();

    public void save(Vacancy vacancy) {
        vacancies.add(vacancy);
    }

    public List<Vacancy> findAll() {
        return vacancies;
    }

    public boolean existsById(Integer id) {
        return false;
    }

    public void deleteById(Integer id) {
    }
}