package xyz.moonsod.youtubevideosearch.obj;

public class VideoEntry {
    private final String title, author;

    public VideoEntry(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}
