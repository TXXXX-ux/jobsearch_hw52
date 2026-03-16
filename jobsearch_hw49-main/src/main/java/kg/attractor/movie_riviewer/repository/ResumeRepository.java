package kg.attractor.movie_riviewer.repository;

import kg.attractor.movie_riviewer.model.Resume;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResumeRepository {
    private final List<Resume> resumes = new ArrayList<>();

    public void save(Resume resume) {
        resumes.add(resume);
    }

    public List<Resume> findAll() {
        return resumes;
    }
}