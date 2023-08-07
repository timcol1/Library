package avlyakulov.timur.library.dao;

import avlyakulov.timur.library.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId_Book(rs.getInt("id_book"));
        book.setIdPerson(rs.getInt("idperson"));
        book.setNameBook(rs.getString("name_book"));
        book.setAuthorBook(rs.getString("author_book"));
        book.setDateBook(rs.getString("date_book"));
        return book;
    }
}
