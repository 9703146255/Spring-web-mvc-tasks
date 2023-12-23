package in.thiru.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import in.thiru.entity.Book;
import in.thiru.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/books")
	public ModelAndView getBooks() {
		List<Book> allBooks = bookService.getAllBooks();

		ModelAndView mav = new ModelAndView();
		mav.addObject("books", allBooks);
		mav.setViewName("index");

		return mav;
	}

	@PostMapping(value = "/add")
	public String addBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("book", new Book());
		return "add";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable("id") Integer id) {
		Optional<Book> optionalBook = bookService.getBookById(id);

		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			ModelAndView mav = new ModelAndView();
			mav.addObject("book", book);
			mav.setViewName("book/edit");
			return mav;
		} else {
			// Handle the case when the book with the given ID is not found
			return new ModelAndView("redirect:/books");
		}
	}

	@GetMapping(value = "/delete/{bookId}")
	public String deleteBook(@PathVariable Integer bookId) {
		bookService.deleteBoook(bookId);
		return "redirect:/books";
	}
}
