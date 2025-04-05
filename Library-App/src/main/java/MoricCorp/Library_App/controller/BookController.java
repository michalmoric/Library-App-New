package MoricCorp.Library_App.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MoricCorp.Library_App.application.BookService;
import MoricCorp.Library_App.contract.BookReadModel;
import MoricCorp.Library_App.contract.BookWriteModel;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<BookReadModel> CreateBook(@RequestBody BookWriteModel toCreate){
        BookReadModel result = service.createBook(toCreate);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    ResponseEntity<BookReadModel> GetBook(@PathVariable int id){
        try{
            BookReadModel result = service.getBookById(id);
            return ResponseEntity.ok(result);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    ResponseEntity<List<BookReadModel>> GetAllBooks(){
        List<BookReadModel> result = service.getAllBooks();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> DeleteBook(@PathVariable int id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
    
}
