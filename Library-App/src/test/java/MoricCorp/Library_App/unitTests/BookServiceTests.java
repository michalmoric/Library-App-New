package MoricCorp.Library_App.unitTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import MoricCorp.Library_App.application.BookService;
import MoricCorp.Library_App.contract.BookReadModel;
import MoricCorp.Library_App.contract.BookWriteModel;
import MoricCorp.Library_App.domain.model.Book;
import MoricCorp.Library_App.domain.repositories.BookRepository;





@SpringBootTest
class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBook() {
        // Arrange
        BookWriteModel writeModel = mock(BookWriteModel.class);
        Book book = new Book(); // Assuming Book has a default constructor
        when(writeModel.toBook()).thenReturn(book);
        when(repository.save(book)).thenReturn(book);

        // Act
        BookReadModel result = bookService.createBook(writeModel);

        // Assert
        assertNotNull(result);
        verify(repository).save(book);
    }

    @Test
    void testGetBookById_Found() {
        // Arrange
        int bookId = 1;
        Book book = new Book(); // Assuming Book has a default constructor
        when(repository.getBookById(bookId)).thenReturn(book);

        // Act
        BookReadModel result = bookService.getBookById(bookId);

        // Assert
        assertNotNull(result);
        verify(repository).getBookById(bookId);
    }

    @Test
    void testGetBookById_NotFound() {
        // Arrange
        int bookId = 1;
        when(repository.getBookById(bookId)).thenReturn(null);

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBookById(bookId);
        });
        assertEquals("Book not found", exception.getMessage());
        verify(repository).getBookById(bookId);
    }

    @Test
    void testGetAllBooks() {
        // Arrange
        Book book1 = new Book(); // Assuming Book has a default constructor
        Book book2 = new Book();
        List<Book> books = Arrays.asList(book1, book2);
        when(repository.findAll()).thenReturn(books);

        // Act
        List<BookReadModel> result = bookService.getAllBooks();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(repository).findAll();
    }
}
