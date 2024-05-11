package Factories;

import FictionBooks.FictionBook;
import Textbooks.Textbook;

public interface LiteratureFactory {
    FictionBook createFictionBook();
    Textbook createTextbook();
}
