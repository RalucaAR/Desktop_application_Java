package bibliotecauniversitara;
public class BooksList
{
    String booksListId;
    String noBooks;
    String book1Id;
    String book2Id;
    String book3Id;
    String book4Id;

    public BooksList() 
    {
        
    }

    public BooksList(String booksListId, String noBooks, String book1Id)
    {
        this.booksListId = booksListId;
        this.noBooks = noBooks;
        this.book1Id = book1Id;
    }

    public BooksList(String booksListId, String noBooks, String book1Id, String book2Id) {
        this.booksListId = booksListId;
        this.noBooks = noBooks;
        this.book1Id = book1Id;
        this.book2Id = book2Id;
    }

    public BooksList(String booksListId, String noBooks, String book1Id, String book2Id, String book3Id)
    {
        this.booksListId = booksListId;
        this.noBooks = noBooks;
        this.book1Id = book1Id;
        this.book2Id = book2Id;
        this.book3Id = book3Id;
    }

    public BooksList(String booksListId, String noBooks, String book1Id, String book2Id, String book3Id, String book4Id)
    {
        this.booksListId = booksListId;
        this.noBooks = noBooks;
        this.book1Id = book1Id;
        this.book2Id = book2Id;
        this.book3Id = book3Id;
        this.book4Id = book4Id;
    }
}
