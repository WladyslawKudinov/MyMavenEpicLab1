package Library;

import FictionBooks.FictionBook;
import Textbooks.Textbook;
import Tools.BooksGenerator;
import Tools.UserGenerator;
import Users.AbstractUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryCard {
    private BooksGenerator booksGenerator = new BooksGenerator();
    public Map<AbstractUser, List<FictionBook>> fictionBooksIssued = new HashMap<>();
    public Map<AbstractUser, List<Textbook>> textBooksIssued = new HashMap<>();
    public List<FictionBook> availableFictionBooks = booksGenerator.generateFiction(50);
    public List<Textbook> availableTextbooks = booksGenerator.generateTextbook(100);
    public UserGenerator generator = new UserGenerator();
    public List<AbstractUser> users = generator.generateUsers(20);


    public void issueTextBook(AbstractUser user, Textbook book) {
        List<Textbook> userBooks = textBooksIssued.getOrDefault(user, new ArrayList<>());
        userBooks.add(book);
        textBooksIssued.put(user, userBooks);
        availableTextbooks.remove(book);
    }

    public void issueFictionBook(AbstractUser user, FictionBook book) {
        List<FictionBook> userBooks = fictionBooksIssued.getOrDefault(user, new ArrayList<>());
        userBooks.add(book);
        fictionBooksIssued.put(user, userBooks);
        availableFictionBooks.remove(book);
    }
}
