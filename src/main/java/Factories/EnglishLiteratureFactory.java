package Factories;

import FictionBooks.EnglishFictionBook;
import FictionBooks.FictionBook;
import FictionBooks.RussianFictionBook;
import Textbooks.EnglishTextbook;
import Textbooks.RussianTextBook;
import Textbooks.Textbook;
import Tools.FictionBooksBuildingDirector;

public class EnglishLiteratureFactory implements LiteratureFactory {

    @Override
    public FictionBook createFictionBook() {
        FictionBooksBuildingDirector director = new FictionBooksBuildingDirector();
        FictionBook book = director.directBookCreation("en");
        return book;
    }

    @Override
    public Textbook createTextbook() {
        return new EnglishTextbook();
    }
}