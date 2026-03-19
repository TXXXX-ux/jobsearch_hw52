package kg.attractor.movie_riviewer.service;

import kg.attractor.movie_riviewer.model.Resume;
import kg.attractor.movie_riviewer.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public List<Resume> getResumesByUserId(Integer userId) {
        return resumeRepository.findByUserId(userId);
    }

    public List<Resume> getResumesByCategory(String category) {
        return resumeRepository.findByCategory(category);
    }
}