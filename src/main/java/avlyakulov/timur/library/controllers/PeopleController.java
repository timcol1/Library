package avlyakulov.timur.library.controllers;

import avlyakulov.timur.library.dao.PersonDAO;
import avlyakulov.timur.library.entity.Book;
import avlyakulov.timur.library.entity.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String getPeople(Model model) {
        model.addAttribute("people", personDAO.getPeople());
        return "people/list_people";
    }

    @GetMapping("/new")
    public String getFormCreatePerson(Model model) {
        model.addAttribute("person", new Person());
        return "/people/create_person";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/create_person";

        personDAO.createPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable int id, Model model) {
        model.addAttribute("person", personDAO.getPerson(id));
        model.addAttribute("books", personDAO.getBooksByUserId(id));
        return "people/person";
    }

    @GetMapping("/{id}/edit")
    public String getFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "people/edit_person";
    }

    @PatchMapping("/{id}")
    public String editPerson(@PathVariable int id, @ModelAttribute @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/edit_person";
        personDAO.updatePerson(person, id);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable int id) {
        personDAO.deletePerson(id);
        return "redirect:/people";
    }
}
