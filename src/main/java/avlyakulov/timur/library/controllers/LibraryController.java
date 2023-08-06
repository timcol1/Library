package avlyakulov.timur.library.controllers;

import avlyakulov.timur.library.dao.LibraryDAO;
import avlyakulov.timur.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library")
public class LibraryController {

    private final LibraryDAO libraryDAO;

    @Autowired
    public LibraryController(LibraryDAO libraryDAO) {
        this.libraryDAO = libraryDAO;
    }

    @GetMapping()
    public String listOfBooks(Model model) {
        model.addAttribute("books", libraryDAO.getListOfBooks());
        return "library/list_books";
    }

    @GetMapping("/create_book")
    public String showBookCreateForm(Model model) {
        model.addAttribute(new Book());

        return "library/create_book";
    }

    @PostMapping()
    public String createBook(@ModelAttribute Book book) {
        libraryDAO.addBook(book);
        return "redirect:/library";
    }

    @GetMapping("/{id}")
    public String showBookById(Model model, @PathVariable int id) {
        model.addAttribute("book", libraryDAO.showBookById(id));
        return "/library/book";
    }

    @GetMapping("/{id}/edit")
    public String getFormEditingBook(@PathVariable int id, Model model) {
        model.addAttribute("book", libraryDAO.showBookById(id));
        return "/library/edit_book";
    }


    //PathVariable - это все из юрл ссылки
    //ModelAttribute - это все что передается из форм в форму
    @PatchMapping("/{id}")
    public String editBook(@ModelAttribute("book") Book book, @PathVariable int id) {
        libraryDAO.editBook(book, id);
        return "redirect:/library";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        libraryDAO.deleteBook(id);
        return "redirect:/library";
    }
}