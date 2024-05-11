package Library;

import FictionBooks.FictionBook;
import Textbooks.Textbook;
import Tools.IssuingGenerator;
import Users.AbstractUser;

import java.util.List;
import java.util.Map;

public class Library {
    private LibraryCard libraryCard = new LibraryCard();
    private IssuingGenerator generatorIss = new IssuingGenerator();
    public Library(){
        libraryCard = generatorIss.simulateIssuing(libraryCard);
    }

    public Map<AbstractUser, List<FictionBook>> getIssuedFiction() {
        return libraryCard.fictionBooksIssued;
    }

    public Map<AbstractUser, List<Textbook>> getIssuedTextbooks() {
        return libraryCard.textBooksIssued;
    }
    public List<AbstractUser> getUsers() {
        return libraryCard.users;
    }
}
