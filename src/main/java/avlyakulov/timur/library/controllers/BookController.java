package avlyakulov.timur.library.controllers;

import avlyakulov.timur.library.dao.BookDAO;
import avlyakulov.timur.library.dao.PersonDAO;
import avlyakulov.timur.library.entity.Book;
import avlyakulov.timur.library.entity.Person;
import avlyakulov.timur.library.util.BookValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library")
public class BookController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;
    private final BookValidator bookValidator;

    @Autowired
    public BookController(BookDAO bookDAO, PersonDAO personDAO, BookValidator bookValidator) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
        this.bookValidator = bookValidator;
    }

    @GetMapping()
    public String listOfBooks(Model model) {
        model.addAttribute("books", bookDAO.getListOfBooks());
        model.addAttribute("dao", personDAO);
        return "library/list_books";
    }

    @GetMapping("/create_book")
    public String showBookCreateForm(Model model) {
        model.addAttribute(new Book());

        return "library/create_book";
    }

    @PostMapping()
    public String createBook(@ModelAttribute @Valid Book book, BindingResult bindingResult) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors())
            return "library/create_book";

        bookDAO.addBook(book);
        return "redirect:/library";
    }

    @GetMapping("/{id}")
    public String showBookById(Model model, @PathVariable int id, @ModelAttribute("personSend") Person person) {
        model.addAttribute("book", bookDAO.showBookById(id));
        model.addAttribute("person", personDAO.getPerson(bookDAO.showBookById(id).getIdPerson()));
        model.addAttribute("people", personDAO.getPeople());
        return "/library/book";
    }

    @PatchMapping("/{id}/free")
    public String freeBookFromUser(@PathVariable("id") int idBook) {
        bookDAO.freeBookFromUser(idBook);
        return "redirect:/library";
    }

    @PatchMapping("/{id}/appoint")
    public String appointUserForBook(@ModelAttribute("personSend") Person person, @PathVariable int id) {
        bookDAO.appointUserForBook(person.getIdPerson(), id);
        return "redirect:/library";
    }

    @GetMapping("/{id}/edit")
    public String getFormEditingBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookDAO.showBookById(id));

        return "/library/edit_book";
    }


    //PathVariable - это все из юрл ссылки
    //ModelAttribute - это все что передается из форм в форму
    @PatchMapping("/{id}")
    public String editBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, @PathVariable int id) {
        if (bindingResult.hasErrors())
            return "/library/edit_book";
        bookDAO.editBook(book, id);
        return "redirect:/library";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookDAO.deleteBook(id);
        return "redirect:/library";
    }
}