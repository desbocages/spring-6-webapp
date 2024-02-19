package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;


    public BootstapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author yo = new Author();
        yo.setFirstName("YAKAM");
        yo.setLastName("Olivier");

        Book tdd = new Book();
        tdd.setIsbn("1234567");
        tdd.setTitle("Test-Driven Development");

        Author kb = new Author();
        kb.setLastName("Beck");
        kb.setFirstName("Kent");

        Book idTP = new Book();
        idTP.setTitle("Identité d'une tradition primordiale");
        idTP.setIsbn("12345");

        Author yoSaved = authorRepository.save(yo);
        Author kbSaved = authorRepository.save(kb);

        Book tddSaved = bookRepository.save(tdd);
        Book idTPSaved = bookRepository.save(idTP);

        yoSaved.getBooks().add(idTPSaved);
        kbSaved.getBooks().add(tddSaved);
        tddSaved.getAuthors().add(kbSaved);
        idTPSaved.getAuthors().add(yoSaved);


        Publisher publisher = new Publisher();
        publisher.setAddress("Address 1");
        publisher.setPublisherName("Best Publisher");
        publisher.setZip("Zip");
        publisher.setState("The state");
        publisher.setCity("New City");
        Publisher savedPublisher = publisherRepository.save(publisher);

        tddSaved.setPublisher(savedPublisher);
        idTPSaved.setPublisher(savedPublisher);

        authorRepository.save(yoSaved);
        authorRepository.save(kbSaved);
        bookRepository.save(idTPSaved);
        bookRepository.save(tddSaved);

        System.out.println("Boot strap data class displaying:");
        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Books count: " + bookRepository.count());
        System.out.println("Saved publishers count: " + publisherRepository.count());


    }


}







