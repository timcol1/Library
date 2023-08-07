package avlyakulov.timur.library.dao;


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
        return jdbcTemplate.query("select * from people order by id_person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void createPerson(Person person) {
        jdbcTemplate.update("insert into people (fullname, date_birth) values(?,?)", person.getFullname(), person.getDate_birth());
    }

    public Person getPerson(int id) {
        return jdbcTemplate.query("select * from people where id_person = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void updatePerson(Person updatedPerson, int id) {
        jdbcTemplate.update("update people set fullname = ?, date_birth = ? where id_person = ?", updatedPerson.getFullname(), updatedPerson.getDate_birth(), id);
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("delete from people where id_person = ?", id);
    }
}
