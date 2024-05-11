package Textbooks;

import Tools.EpicRandomizer;

public class RussianTextBook implements Textbook {
    private EpicRandomizer randomizer = new EpicRandomizer();
    private String[] rawTitle = randomizer.getRusTxtbTtl();
    private final String title = rawTitle[0];
    private final String author = "Без автора";

    @Override
    public String get_author() {
        return this.author;
    }

    @Override
    public String get_title() {
        return this.title;
    }
}
