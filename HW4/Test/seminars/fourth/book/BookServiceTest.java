package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    BookRepository mockBookRepository;
    BookService bookService;
    @BeforeEach
    void setup(){
        mockBookRepository = mock(BookRepository.class);
        bookService = new BookService(mockBookRepository);
    }

    @Test
    void testBookServiceFindById(){
        Book book = new Book("1", "SomeTitle", "AnyAuthor");
        when(mockBookRepository.findById("1")).thenReturn(book);

        Book actualBook = bookService.findBookById("1");

        assertThat(actualBook).isEqualTo(book);
    }

    @Test
    void testBookServiceFindAll(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "SomeTitle", "AnyAuthor"));
        books.add(new Book("2", "SomeTitle2", "AnyAuthor2"));
        when(mockBookRepository.findAll()).thenReturn(books);

        List<Book> actualBooksList = bookService.findAllBooks();

        assertThat(actualBooksList).isEqualTo(books);
    }
}
