package MoricCorp.Library_App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import MoricCorp.Library_App.domain.model.Book;
import MoricCorp.Library_App.domain.repositories.BookRepository;

public interface SqlBookRepository extends BookRepository ,JpaRepository<Book,Integer> {

}
