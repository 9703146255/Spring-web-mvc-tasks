package in.thiru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.thiru.entity.Book;

public interface BooksRepo extends JpaRepository<Book, Integer> {

}
