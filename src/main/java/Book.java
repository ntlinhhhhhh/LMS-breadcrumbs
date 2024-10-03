public class Book extends Document {

    private String ISBN;
    private int pages; // so trang

    public Book(String id, String ISBN, String title, String author, String genre, String description, int pages) {
        super(id, title, author, genre, description);
        this.ISBN = ISBN;
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    @Override
    public void PrintInfo () {
        super.PrintInfo();
        System.out.println("ISBN: " + ISBN + " genre: " + pages);
    }

}
