package avlyakulov.timur.library.controllers;

import avlyakulov.timur.library.dao.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}