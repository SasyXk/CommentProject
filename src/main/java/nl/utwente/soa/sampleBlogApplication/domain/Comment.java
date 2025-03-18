package nl.utwente.soa.sampleBlogApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// The following annotations are from lombok (https://projectlombok.org/)
// They automatically generate Getters and Setters for the objects.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long blogId;
    private Long id;
    private String author;
    private String comment;
}
