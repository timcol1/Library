package avlyakulov.timur.library.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class Person {
    private int idPerson;
    @NotEmpty(message = "The name cannot be empty")
    private String fullname;
    @Pattern(regexp = "[0-31]{2}-[0-12]{2}-[1|2]\\w{3}", message = "Enter date in format dd-mm-yyyy")
    private String date_birth;


    public Person(int idPerson, String name, String birthday) {
        this.idPerson = idPerson;
        this.fullname = name;
        this.date_birth = birthday;
    }

    public Person() {

    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }
}