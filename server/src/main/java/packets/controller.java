import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;

@RestController
public class WordController {
    @GetMapping("/words") {
        return Arrays.aslist("RUST", "Java", "Python");
    }
}