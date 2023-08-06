package avlyakulov.timur.library.entity;

import java.text.SimpleDateFormat;

public class Book {
    private int idBook;
    private String nameBook;
    private String authorBook;
    private String dateBook;
    private boolean isTaken;

    public Book(int idBook, String nameBook, String authorBook, String dateBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.dateBook = dateBook;

    }

    public Book() {

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