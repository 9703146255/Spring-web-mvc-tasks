package in.thiru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.thiru.entity.Book;
import in.thiru.repo.BooksRepo;

@Service
public class BookService {

	@Autowired
	private BooksRepo bookRepo;

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public void saveBook(Book bookObj) {
		bookRepo.save(bookObj);
	}

	public void deleteBoook(Integer bookId) {
		bookRepo.deleteById(bookId);
	}

	public void updateBook(Integer BookId, Book book) {
		book.setBookId(BookId);

		bookRepo.save(book);
	}
	
	public Optional<Book> getBookById(Integer id) {
        return bookRepo.findById(id);
    }

}
