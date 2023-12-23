package in.thiru.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.thiru.entity.Book;
import in.thiru.repo.BookRepo;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private BookRepo bookRepository;

	@Override
	public void run(String... args) throws Exception {
		insertSampleData();
	}

	private void insertSampleData() {
		List<Book> books = new ArrayList<>();

		for (int i = 1; i <= 20; i++) {
			Book book = new Book();
			book.setBookName("Book " + i);
			book.setBookPrice(19.99 * i);
			book.setBookAuthor("Author " + i);
			books.add(book);
		}

		bookRepository.saveAll(books);
	}
}
