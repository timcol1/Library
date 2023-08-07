package avlyakulov.timur.library.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class Book {
    private int idBook;
    private int idPerson;

    @NotEmpty(message = "Enter the name of book")
    private String nameBook;
    @NotEmpty(message = "Enter the author of book")
    private String authorBook;
    @Pattern(regexp = "[1|2]\\w{3}", message = "you enter wrong date!")
    private String dateBook;

    public Book(int idBook,int idPerson, String nameBook, String authorBook, String dateBook) {
        this.idBook = idBook;
        this.idPerson = idPerson;
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.dateBook = dateBook;

    }

    public Book() {

    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdBook() {
        return idBook;
    }
    public void setId_Book(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public String getDateBook() {
        return dateBook;
    }

    public void setDateBook(String dateBook) {
        this.dateBook = dateBook;
    }
}