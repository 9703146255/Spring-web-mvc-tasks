package in.thiru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.thiru.entity.Book;
import in.thiru.repo.BooksRepo;

@Service
public class BookService {
	
	@Autowired
	private BooksRepo bookRepo;
	
	
	public List<Book> getAllBooks()
	{
		return bookRepo.findAll();
	}
	

}
