package nl.utwente.soa.sampleBlogApplication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.utwente.soa.sampleBlogApplication.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    //private static List<Blog> blogs = new ArrayList<>();
    private static List<Comment> comments = new ArrayList<>();

    @PostConstruct
    public void commentSetUp(){
        comments.add(
            new Comment(1L, 1L, "Leon", "Nice blog")
        );
        comments.add(
            new Comment(1L, 2L, "Leon",  "Wow awesome blog")
        );
        comments.add(
            new Comment(2L, 3L, "Leon", "2222")
        );
        comments.add(
            new Comment(2L, 4L, "Leon",  "Wow awesome 2222")
        );        
    }

    public List<Comment> getCommentsByIdBlog(Long blogId){
        return comments.stream().filter(comment -> comment.getBlogId() == blogId).collect(Collectors.toList());
    }
}
