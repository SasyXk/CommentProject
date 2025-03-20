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
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {
    //private static List<Blog> blogs = new ArrayList<>();
    private static List<Comment> comments = new ArrayList<>();

    @Autowired private RestTemplate restTemplate;

    @PostConstruct
    public void commentSetUp(){
        String endpoint = "http://localhost:8080/SubscribePlugin";
        String url = "http://localhost:8082/comments/";
        String checkUrl = "http://localhost:8082/health";
        String checkDeleteUrl = "http://localhost:8082/checkComment/";
        String name = "comment";
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
       
        Set<Long> uniqueBlogIndex = comments.stream()
                                       .map(Comment::getBlogId)
                                       .collect(Collectors.toSet());
        //uniqueBlogIndex.add(3L);                              
        uniqueBlogIndex.forEach(blogId -> {
            String fullUrl = url + blogId;
            restTemplate.postForObject(endpoint + "?name=" + name + "&url=" + fullUrl + "&checkUrl=" + checkUrl + "&checkDeleteUrl=" + checkDeleteUrl, null, String.class);
        });
    }

    public List<Comment> getCommentsByIdBlog(Long blogId){
        return comments.stream().filter(comment -> comment.getBlogId() == blogId).collect(Collectors.toList());
    }

    public boolean checkComment(Long blogId){
        List<Comment> commentsForBlog = comments.stream()
                                        .filter(comment -> comment.getBlogId().equals(blogId))
                                        .collect(Collectors.toList());
        return commentsForBlog.isEmpty();
    }
}
