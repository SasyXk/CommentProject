package nl.utwente.soa.sampleBlogApplication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.utwente.soa.sampleBlogApplication.domain.Blog;
import nl.utwente.soa.sampleBlogApplication.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BlogService {
    private static List<Blog> blogs = new ArrayList<>();

    @PostConstruct
    public void blogSetup(){
        blogs.add(
            new Blog(
                1L,
                "Test Blog 1",
                "Summary1",
                "Content 1",
                Arrays.asList(
                    new Comment(1L, "Leon", "Nice blog"),
                    new Comment(1L, "Leon",  "Wow awesome blog")
                )
            )
        );
        blogs.add(
            new Blog(
                2L,
                "Test Blog 2",
                "summary 2",
                "Content 2",
                Arrays.asList(
                    new Comment(1L, "Leon",  "Stupid post"),
                    new Comment(1L, "Leon",  "Test 2")
                )
            )
        );
    }

    public List<Blog> getBlogs(){
        return blogs;
    }

    public Blog getBlogById(Long id){
        return blogs.stream().filter(blog -> blog.getId() == id).findFirst().orElse(null);
    }
}
