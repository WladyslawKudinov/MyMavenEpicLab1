package FictionBooks;

public abstract class FictionBook {
    protected String title;
    protected String[] titleArr;

    public String getFullTitle() {
        return title;
    }

    public String[] getTitleArr() {
        return titleArr;
    }

    public void setTitle(String title, String[] titleArr) {
        this.title = title;
        this.titleArr = titleArr;
    }
}