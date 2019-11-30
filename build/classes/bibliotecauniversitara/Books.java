package bibliotecauniversitara;
public class Books {
    String bookId;
    String domain;
    String title;
    String author;
    String publishing;
    String appearance;
    String status;

    public Books() {
    }

    public Books(String bookId, String domain, String title, String author, String publishing, String appearance, String status) {
        this.bookId = bookId;
        this.domain = domain;
        this.title = title;
        this.author = author;
        this.publishing = publishing;
        this.appearance = appearance;
        this.status = status;
    }
}
