package MoricCorp.Library_App.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import MoricCorp.Library_App.domain.model.Book;

public interface BookRepository {

    Book getBookById(@Param("id") int Id);

    List<Book> findAll();

    Book save(Book entity);

    void delete(Integer id);
    
}
