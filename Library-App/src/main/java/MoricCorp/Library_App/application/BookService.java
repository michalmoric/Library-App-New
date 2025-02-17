package MoricCorp.Library_App.application;

import org.springframework.stereotype.Service;

import MoricCorp.Library_App.contract.BookReadModel;
import MoricCorp.Library_App.contract.BookWriteModel;
import MoricCorp.Library_App.domain.model.Book;
import MoricCorp.Library_App.domain.repositories.BookRepository;

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

    

}
