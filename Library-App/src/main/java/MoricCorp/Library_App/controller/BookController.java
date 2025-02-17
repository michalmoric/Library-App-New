package MoricCorp.Library_App.controller;

import org.springframework.http.ResponseEntity;
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
    ResponseEntity<BookReadModel> createBook(@RequestBody BookWriteModel toCreate){
        BookReadModel result = service.createBook(toCreate);
        return ResponseEntity.ok(result);
    }
}
