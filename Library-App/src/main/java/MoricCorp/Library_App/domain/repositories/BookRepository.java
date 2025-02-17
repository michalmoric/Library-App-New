package MoricCorp.Library_App.domain.repositories;

import MoricCorp.Library_App.domain.model.Book;

public interface BookRepository {

    Book save(Book entity);
    
}
