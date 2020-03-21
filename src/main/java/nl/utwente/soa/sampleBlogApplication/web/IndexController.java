package nl.utwente.soa.sampleBlogApplication.web;

import nl.utwente.soa.sampleBlogApplication.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired private BlogService blogService;

    @GetMapping("/")
    public String showOverview(Model model) {
        model.addAttribute("blogs", blogService.getBlogs());
        return "overview";
    }

    @GetMapping("/blog/{blogid}")
    public String showBlog(Model model, @PathVariable("blogid") Long blogId) {
        model.addAttribute("blog", blogService.getBlogById(blogId));
        return "detail";
    }
}
