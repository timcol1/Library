package avlyakulov.timur.library.dao;

import avlyakulov.timur.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LibraryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getListOfBooks() {
        return jdbcTemplate.query("select * from book order by id_book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void addBook(Book book) {
        jdbcTemplate.update("insert into book(name_book, author_book, date_book) values(?,?,?)", book.getNameBook(), book.getAuthorBook(), book.getDateBook());
    }

    public Book showBookById(int id) {
        return jdbcTemplate.query("select * from book where id_book = ?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }


    public void editBook(Book updatedBook, int id) {
        jdbcTemplate.update("update book set name_book = ?, author_book = ?, date_book = ? where id_book = ?",
                updatedBook.getNameBook(), updatedBook.getAuthorBook(), updatedBook.getDateBook(), id);
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("delete from book where id_book = ?", id);
    }
}
