package Tools;

import FictionBooks.FictionBook;
import Library.LibraryCard;
import Textbooks.Textbook;
import Users.AbstractUser;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class IssuingGenerator {
    public LibraryCard simulateIssuing(LibraryCard libraryCard) {
        int size = libraryCard.users.size();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            AbstractUser currentUser = libraryCard.users.get(i);
            for (int j = 0; j < 3; j++) {
                String[] statuses = {"fiction", "textbook"};
                int randint = rand.nextInt(statuses.length);
                if (!libraryCard.availableFictionBooks.isEmpty() & !libraryCard.availableTextbooks.isEmpty()) {
                    if (statuses[randint].equals("fiction")){
                       libraryCard.issueFictionBook(currentUser, libraryCard.availableFictionBooks.getFirst());
                    } else if (statuses[randint].equals("textbook")){
                        libraryCard.issueTextBook(currentUser, libraryCard.availableTextbooks.getFirst());
                    }
                } else if (libraryCard.availableFictionBooks.isEmpty() & !libraryCard.availableTextbooks.isEmpty()) {
                    libraryCard.issueTextBook(currentUser, libraryCard.availableTextbooks.getFirst());
                } else if (!libraryCard.availableFictionBooks.isEmpty() & libraryCard.availableTextbooks.isEmpty()) {
                    libraryCard.issueFictionBook(currentUser, libraryCard.availableFictionBooks.getFirst());
                }
            }
        }
        return libraryCard;
    }
}
