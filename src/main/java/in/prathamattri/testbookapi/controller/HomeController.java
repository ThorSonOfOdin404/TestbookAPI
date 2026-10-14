package in.prathamattri.testbookapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok().body("<h2>Home</h2><p>Checkout <a href=\"/api/books\">/api/books</a></p>");
    }
}
