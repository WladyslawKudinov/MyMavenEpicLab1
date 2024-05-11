package Tools;

import FictionBooks.FictionBook;
import FictionBooks.RussianFictionBook;


public class FictionBooksBuildingDirector {

    public FictionBook directBookCreation(String language) {
        try {
            if (language.equals("en")) {
                FictionBook book = EngBookCreation(language);
                return book;
            } else if (language.equals("ru")) {
                FictionBook book = RusBookCreation(language);
                return book;
            } else {
                throw new IllegalArgumentException("Language not recognized");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
// Eng books: TtlYearGenre. Rus books: YearGenreTtl
    private FictionBook RusBookCreation(String language){
        // creating book info
        EpicRandomizer randomizer = new EpicRandomizer();
        String[] bookInfo = randomizer.getFicbTtlYaerGenre(language);
        String bookTitle = bookInfo[1] + "; " + bookInfo[2] + "; " + bookInfo[0] + ".";

        FictionBook createdBook = new RussianFictionBook();

        createdBook.setTitle(bookTitle, bookInfo);
        return createdBook;
    }
    private FictionBook EngBookCreation(String language){
        EpicRandomizer randomizer = new EpicRandomizer();
        String[] bookInfo = randomizer.getFicbTtlYaerGenre(language);
        String bookTitle = bookInfo[0] + "; " + bookInfo[1] + "; " + bookInfo[2] + ".";

        FictionBook createdBook = new RussianFictionBook();

        createdBook.setTitle(bookTitle, bookInfo);
        return createdBook;
    }
}
