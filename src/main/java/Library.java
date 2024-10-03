import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<UserRead> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addDocument(Book book) {
        books.add(book);
        System.out.println("Document added successfully!");
    }

    public void removeDocument(String id) {
        books.removeIf(doc -> doc.getId().equals(id));
        System.out.println("Document removed successfully!");
    }

    public void updateDocument(String id, String newIsbn, String newTitle, String newAuthor, String newGenre, String newDescription, int newPages) {
        for (Document doc : books) {
            if (doc.getId().equals(id)) {
                // Cập nhật thông tin tài liệu
                // Giả sử bạn có phương thức setter trong lớp Document
                doc = new Book(id,newIsbn, newTitle, newAuthor, newGenre, newDescription, newPages); // Giả sử doc là Book
                System.out.println("Document updated successfully!");
                return;
            }
        }
        System.out.println("Document not found!");
    }

    public Document findDocument(String title) {
        for (Document doc : books) {
            if (doc.getTitle().equalsIgnoreCase(title)) {
                return doc;
            }
        }
        return null; // không tìm thấy
    }

    public void displayDocuments() {
        System.out.println("Document List:");
        for (Document doc : books) {
            doc.PrintInfo();
        }
    }

    public void addUser(UserRead user) {
        users.add(user);
        System.out.println("User added successfully!");
    }

    public void displayUsers() {
        System.out.println("User List:");
        for (UserRead user : users) {
            user.PrintInfo();
        }
    }
}
