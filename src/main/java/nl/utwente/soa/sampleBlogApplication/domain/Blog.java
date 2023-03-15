package nl.utwente.soa.sampleBlogApplication.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// The following annotations are from lombok (https://projectlombok.org/)
// They automatically generate Getters and Setters for the objects.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Long id;
    private String title;
    private String summary;
    private String content;

    private List<Comment> comments = new ArrayList<>();
}
