// lop cha dinh nghia truu tuong
public abstract class Document {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String description = "";
    private boolean available = false; // trang thai co san

    Document(String id, String title, String author, String genre, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.available = true;
    }

    // getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }





    public void PrintInfo() {
        System.out.print("ID: " + id + " Title: " + title + " Author: " + author + " genre: " + genre + " available: " + available);
    }
}
