package kg.attractor.movie_riviewer.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy {
    private Integer id;
    private Integer userId;
    private String category;
    private String title;
    private String description;
}