package Textbooks;
import Tools.EpicRandomizer;

public class EnglishTextbook implements Textbook{
    private EpicRandomizer randomizer = new EpicRandomizer();
    private String[] rawTitleAuthorDegree  = randomizer.getEngTxtbTtlAuthDeg();
    private final String degree = rawTitleAuthorDegree[2];
    private final String author = rawTitleAuthorDegree[1];
    private final String title = rawTitleAuthorDegree[0];

    @Override
    public String get_author() {
        return this.author;
    }

    @Override
    public String get_title() {
        return this.title;
    }

    public String get_degree() {
        return this.degree;
    }
}
