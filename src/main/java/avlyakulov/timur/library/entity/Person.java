package avlyakulov.timur.library.entity;

public class Person {
    private int id;
    private String fullname;
    private String date_birth;



    public Person(int id, String name, String birthday) {
        this.id = id;
        this.fullname = name;
        this.date_birth = birthday;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId_Person(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirth() {
        return date_birth;
    }

    public void setDate_Birth(String date_birth) {
        this.date_birth = date_birth;
    }
}