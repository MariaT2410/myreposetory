import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.awt.print.Book;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
public class FactoryLibrary {

    private static final int BOOKS_SIZE = 10;
    private static final int AUTORS_SIZE = 50;

    private static Map<Integer, Book> books = new HashMap<Integer, Book>();
    private static Map<Integer, Autor> autors = new HashMap<Integer, Autor>();
    private AtomicInteger numberOfId;


    Library l = new Library();
        l.setId(5689);
        l.setName("Библиотека");

    private final Random random = new Random();

    private void populateBooks() {
        for (int i = 0; i < BOOKS_SIZE; i++) {
            Book d = new Book(numberOfId.getAndIncrement(), "Book  " + i,  random.nextInt(AUTORS_SIZE));
            books.put(d.getId(), d);
        }
    }

    private void populateAutors() {
        for (int i = 0; i < BOOKS_SIZE; i++) {
            Book d = new Book(numberOfId.getAndIncrement(), "Autor  " + i);
            books.put(d.getId(), d);
        }
    }

    public List<Book> getBooksByAutorId(int idAutor) {
        Collection<Book> c = books.values();
        List<Book> list = new ArrayList<Book>(c);
        List<Book> booksGet = new ArrayList<>();
        for (Book book : list) {
            if (book.getId() == idAutor) {
                booksGet.add(book);
            }
        }
        return booksGet;
    }

}
