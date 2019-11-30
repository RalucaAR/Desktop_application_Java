package bibliotecauniversitara;
public class BorrowList
{
    String listId;
    Date borrowDate;
    Date returnDate;

    public BorrowList() 
    {
        
    }

    public BorrowList(String listId, Date borrowDate, Date returnDate) 
    {
        this.listId = listId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    
}
