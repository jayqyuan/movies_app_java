package site.jayqyuan.movies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indicate this class is a REST API controller
@RequestMapping("/api/v1/movies") //Maps all requests starting with "/api/v1/movies"
public class MovieController {
    //handle GET requests

    //GetMapping Maps HTTP Get requests
    @GetMapping
    public  String allMovies(){
        return "All Movies";
    }

}
