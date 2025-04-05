package MoricCorp.Library_App.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import MoricCorp.Library_App.domain.model.Book;
import MoricCorp.Library_App.domain.repositories.BookRepository;

public interface SqlBookRepository extends BookRepository, JpaRepository<Book, Integer> {
    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM books WHERE id = ?1 AND is_deleted = false")
    Book getBookById(int Id);

    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM books WHERE is_deleted = false")
    List<Book> findAll();

    @Override
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE books SET is_deleted = true WHERE id = ?1")
    void delete(Integer id);

}
