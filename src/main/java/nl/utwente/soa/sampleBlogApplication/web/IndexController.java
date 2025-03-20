package nl.utwente.soa.sampleBlogApplication.web;

import nl.utwente.soa.sampleBlogApplication.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
public class IndexController {

    @Autowired private CommentService commentService;

    @GetMapping("/comments/{blogid}")
    public String showComments(Model model, @PathVariable("blogid") Long blogId) {
        model.addAttribute("comments", commentService.getCommentsByIdBlog(blogId));
        return "detail";
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Comment Service is online");
    }

    @GetMapping("/checkComment/{blogid}")
    public ResponseEntity<String> healthCheck( @PathVariable("blogid") Long blogId){
        boolean result =  commentService.checkComment(blogId);
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body("Can delete the Blog.");
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
    }

}
