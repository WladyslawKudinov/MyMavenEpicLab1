package Factories;

import FictionBooks.FictionBook;
import FictionBooks.RussianFictionBook;
import Textbooks.RussianTextBook;
import Textbooks.Textbook;
import Tools.FictionBooksBuildingDirector;

public class RussianLiteratureFactory implements LiteratureFactory {

    @Override
    public FictionBook createFictionBook() {
        FictionBooksBuildingDirector director = new FictionBooksBuildingDirector();
        FictionBook book = director.directBookCreation("ru");
        return book;
    }

    @Override
    public Textbook createTextbook() {
        return new RussianTextBook();
    }
}
