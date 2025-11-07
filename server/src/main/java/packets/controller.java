import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/api/words")
public class WordController {

    private final WordService wordService;
//Assuming WordService is a service class that handles the business logic for words
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public List<String> getWords() {
        return wordService.getAllWords();
    }
// Additional CRUD operations to POST new words, DELETE existing words, and UPDATE words
    @PostMapping
    public String addWord(@RequestBody String word) {
        wordService.addWord(word);
        return "Added: " + word;
    }

    @DeleteMapping("/{word}")
    public String deleteWord(@PathVariable String word) {
        boolean removed = wordService.removeWord(word);
        return removed ? "Deleted: " + word : "Word not found";
    }

    @PutMapping("/{oldWord}")
    public String updateWord(@PathVariable String oldWord, @RequestBody String newWord) {
        boolean updated = wordService.updateWord(oldWord, newWord);
        return updated ? "Updated: " + oldWord + " -> " + newWord : "Word not found";
    }
}
