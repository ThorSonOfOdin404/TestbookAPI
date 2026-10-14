package in.prathamattri.testbookapi.controller;

import in.prathamattri.testbookapi.entity.Book;
import in.prathamattri.testbookapi.dto.BookRequestDTO;
import in.prathamattri.testbookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books = bookRepository.getBooks();
        return ResponseEntity.ok().body(books);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookRequestDTO book){
        if(Objects.isNull(book)){
            return ResponseEntity.badRequest().body("Book cannot be null");
        }
        boolean bookAdded = bookRepository.addBook(book);
        if(bookAdded){
            return ResponseEntity.ok().body("Book added successfully!");
        }
        return ResponseEntity.internalServerError().body("Could not add the book, try again!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){
        boolean deleted = bookRepository.deleteBookById(id);
        if(deleted){
            return ResponseEntity.ok().body("Book deleted successfully!");
        }
        return ResponseEntity.internalServerError().body("Could not delete the book, try again!");
    }

}
