package MoricCorp.Library_App.application;

import java.util.List;

import org.springframework.stereotype.Service;

import MoricCorp.Library_App.contract.BookReadModel;
import MoricCorp.Library_App.contract.BookWriteModel;
import MoricCorp.Library_App.domain.model.Book;
import MoricCorp.Library_App.domain.repositories.BookRepository;
import jakarta.transaction.Transactional;

@Service
public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookReadModel createBook(final BookWriteModel source){
        Book result = repository.save(source.toBook());
        return new BookReadModel(result);
    }

    public BookReadModel getBookById(final int id) throws IllegalArgumentException {
        Book result = repository.getBookById(id);
        if (result == null) {
            throw new IllegalArgumentException("Book not found");
        }
        return new BookReadModel(result);
    }
    public List<BookReadModel> getAllBooks() {
        List<Book> books = repository.findAll();
        List<BookReadModel> result = books.stream()
                .map(book -> new BookReadModel(book))
                .toList();
        return result;
    }
    
    @Transactional
    public void deleteBook(int id) {
        repository.delete(id);
    }

    

}
