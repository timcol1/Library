package avlyakulov.timur.library.entity;

public class Book {
    private int id;

    private String nameBook;
    private String authorBook;

    private String dateBook;
    private boolean isTaken;

    public Book(int id, String nameBook, String authorBook, String dateBook, boolean isTaken) {
        this.id = id;
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.dateBook = dateBook;
        this.isTaken = isTaken;
    }

    public Book () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}