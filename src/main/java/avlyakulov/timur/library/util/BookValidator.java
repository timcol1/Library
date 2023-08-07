package avlyakulov.timur.library.util;

import avlyakulov.timur.library.dao.BookDAO;
import avlyakulov.timur.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class BookValidator implements Validator {
    private BookDAO bookDAO;

    @Autowired
    public BookValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        //посмотреть есть ли человек с таким же email в бд
        if (bookDAO.showBookById(book.getNameBook()).isPresent()) { //тут мы получаем объект класса Optional и просто вызываем метод isPresent, есть ли там значение? Нашли мы человека
            errors.rejectValue("nameBook", "", "This book was added to library"); //1 - поле в объекте на котором произошла ошибка, 2 - код ошибки, 3- сообщение которое выводится
        }
    }
}