package in.prathamattri.testbookapi.repository;

import in.prathamattri.testbookapi.dto.BookRequestDTO;
import in.prathamattri.testbookapi.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class BookRepository {
    private List<Book> books;
    {
        books = new ArrayList<>(Arrays.asList(
                new Book("India that is Bharat", "J. Sai Deepak", 650),
                new Book("Revolutionaries", "Sanjeev Sanyal", 250),
                new Book("Savarkar", "Dr. Vikram Sampath", 560)
        ));
    }
    public boolean addBook(BookRequestDTO bookRequestDTO){

        Book book = new Book(bookRequestDTO.getTitle(),bookRequestDTO.getAuthor(),bookRequestDTO.getPrice());
        books.add(book);
        return true;
    }

    public Optional<Book> getBookById(int id){
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public Optional<Book> getBookByTitle(String title){
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst();
    }

    public boolean deleteBookById(int id){
        return books.removeIf(book -> book.getId() == id);
    }

    public Optional<Book> updateBookById(int id, Book book){
        Optional<Book> first = books.stream().filter(book1 -> book1.getId() == id).findFirst();
        if(first.isPresent()){
            Book book1 = first.get();
            book1.setTitle(book.getTitle());
            book1.setAuthor(book.getAuthor());
            book1.setPrice(book.getPrice());
        }
        return first;
    }
}
