package kg.attractor.movie_riviewer.repository;

import kg.attractor.movie_riviewer.model.User;
import kg.attractor.movie_riviewer.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class VacancyRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Vacancy> findAll() {
        String sql = "SELECT * FROM vacancies"; // Теперь это сработает, т.к. в базе уже title
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class));
    }

    public List<Vacancy> findByCategory(String category) {
        // Явно приводим к нижнему регистру и в базе, и в коде
        String sql = "SELECT * FROM vacancies WHERE LOWER(category) = LOWER(:category)";

        Map<String, Object> params = Map.of("category", category.trim()); // trim() уберет лишние пробелы

        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Vacancy.class));
    }

    public List<User> findApplicantsByVacancyId(Integer vacancyId) {
        // Обернул в try-catch, чтобы если таблицы responses еще нет, сервер не падал
        try {
            String sql = "SELECT u.* FROM users u " +
                    "JOIN resumes r ON u.id = r.user_id " +
                    "JOIN responses res ON r.id = res.resume_id " +
                    "WHERE res.vacancy_id = :vacancyId";
            return jdbcTemplate.query(sql, Map.of("vacancyId", vacancyId),
                    new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e) {
            return List.of();
        }
    }
}