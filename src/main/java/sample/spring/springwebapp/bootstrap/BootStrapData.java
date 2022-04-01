package sample.spring.springwebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sample.spring.springwebapp.domain.Author;
import sample.spring.springwebapp.domain.Book;
import sample.spring.springwebapp.domain.Publisher;
import sample.spring.springwebapp.repositories.AuthorRepository;
import sample.spring.springwebapp.repositories.BookRepository;
import sample.spring.springwebapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap started");

        Publisher publisher1 = new Publisher("Jags publications", "vyshnava street", "Vizianagaram", "Andhra Pradesh", "535001");
        publisherRepository.save(publisher1);

        Author jags = new Author("Jagadeesh", "Dachepalli");
        Book artOfSwinging = new Book("TheArtOfSwingBowling", "1234");

        jags.getBooks().add(artOfSwinging);
        artOfSwinging.getAuthors().add(jags);
        artOfSwinging.setPublisher(publisher1);
        publisher1.getBooks().add(artOfSwinging);

        authorRepository.save(jags);
        bookRepository.save(artOfSwinging);

//        Author jags = new Author("Jagadeesh", "Dachepalli");
        Book problemsOfIntrovert = new Book("ProblemsOfIntrovert", "1235");

        jags.getBooks().add(problemsOfIntrovert);
        problemsOfIntrovert.getAuthors().add(jags);
        problemsOfIntrovert.setPublisher(publisher1);
        publisher1.getBooks().add(problemsOfIntrovert);

        authorRepository.save(jags);
        bookRepository.save(problemsOfIntrovert);

        System.out.println("Authors saved: " + authorRepository.count());
        System.out.println("Books stored: " + bookRepository.count());
        System.out.println("Publishers stored: " + publisher1.getBooks().size());

    }
}
