package in.thiru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.thiru.entity.Book;
import in.thiru.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	
	@GetMapping(value="/books")
	public ModelAndView getBooks() 
	{
		List<Book> allBooks = bookService.getAllBooks();
		
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("books",allBooks);
		
		mav.setViewName("index");
		
		return mav;
		
	}

}
