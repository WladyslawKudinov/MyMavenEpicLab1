package Tools;

import Factories.EnglishLiteratureFactory;
import Factories.RussianLiteratureFactory;
import FictionBooks.FictionBook;
import Textbooks.Textbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BooksGenerator {
    public List<FictionBook> generateFiction(int amount){
        List<FictionBook> books = new ArrayList<>();
        Random random = new Random();
        RussianLiteratureFactory russianFactory = new RussianLiteratureFactory();
        EnglishLiteratureFactory englishFactory = new EnglishLiteratureFactory();
        String[] statuses = {"russian", "english"};
        for(int i = 0; i < amount; i++){
            int randint = random.nextInt(statuses.length);
            if (statuses[randint].equals("russian")){
                books.add(russianFactory.createFictionBook());
            } else if (statuses[randint].equals("english")){
                books.add(englishFactory.createFictionBook());
            }
        }
        return books;
    }
    public List<Textbook> generateTextbook(int amount){
        List<Textbook> books = new ArrayList<>();
        Random random = new Random();
        RussianLiteratureFactory russianFactory = new RussianLiteratureFactory();
        EnglishLiteratureFactory englishFactory = new EnglishLiteratureFactory();
        String[] statuses = {"russian", "english"};
        for(int i = 0; i < amount; i++){
            int randint = random.nextInt(statuses.length);
            if (statuses[randint].equals("russian")){
                books.add(russianFactory.createTextbook());
            } else if (statuses[randint].equals("english")){
                books.add(englishFactory.createTextbook());
            }
        }
        return books;
    }
}
