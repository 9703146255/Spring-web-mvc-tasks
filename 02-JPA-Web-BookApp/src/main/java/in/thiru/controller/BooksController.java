package in.thiru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.thiru.entity.Book;
import in.thiru.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BooksController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/books")
	public ModelAndView getAllBooks() {
		List<Book> allBooks = bookService.getAllBooks();

		ModelAndView mav = new ModelAndView();

		mav.addObject("allBooks", allBooks);
		
		mav.setViewName("books");

		return mav;
	}

}                    
