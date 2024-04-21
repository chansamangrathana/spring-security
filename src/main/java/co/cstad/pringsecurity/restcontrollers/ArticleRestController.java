package co.cstad.pringsecurity.restcontrollers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleRestController {


//    read
    @GetMapping
    public String getAllArticles(){
        return "All articles";
    }
    @GetMapping("/read/{id}")
    public String readSigleArticle(@PathVariable int id){
        return "Read article"+id;
    }
    @PostMapping("/write")
    public String createArticle(@PathVariable int id){
        return "Create article"+id;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id){
        return "Delete article"+id;
    }
}
