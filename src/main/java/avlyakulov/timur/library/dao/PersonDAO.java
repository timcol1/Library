package avlyakulov.timur.library.dao;


import avlyakulov.timur.library.entity.Book;
import avlyakulov.timur.library.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getPeople() {
        return jdbcTemplate.query("select * from people order by idperson", new BeanPropertyRowMapper<>(Person.class));
    }

    public void createPerson(Person person) {
        jdbcTemplate.update("insert into people (fullname, date_birth) values(?,?)", person.getFullname(), person.getDate_birth());
    }

    public Person getPerson(int id) {
        return jdbcTemplate.query("select * from people where idperson = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void updatePerson(Person updatedPerson, int id) {
        jdbcTemplate.update("update people set fullname = ?, date_birth = ? where idperson = ?", updatedPerson.getFullname(), updatedPerson.getDate_birth(), id);
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("delete from people where idperson = ?", id);
    }

    public List<Book> getBooksByUserId(int id) {
        return jdbcTemplate.query("select * from book where idperson = ?", new Object[]{id}, new BookMapper());
    }
}
