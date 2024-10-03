import java.util.ArrayList;
import java.util.List;

public class UserReadAction {
    private ArrayList<Book> books = new ArrayList<>();

//    public UserReadAction(List<Book> book) {
//        this.books = book;
//    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void borrowDocument(String id) {
        for(Book book : books) {
            if(book.getId().equals(id) && book.isAvailable()) {

            }
        }
    }


}
