package bibliotecauniversitara;

import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
 import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class BorrowBookFrame extends JFrame
{ 
    //initiate frame objects
    private JButton exit = new JButton("Exit");
    public JButton borrowBook = new JButton("Borrow");
    
    public JLabel book1 = new JLabel("Book 1 ID:");
    public JLabel book2 = new JLabel("Book 2 ID:");
    public JLabel book3 = new JLabel("Book 3 ID:");
    public JLabel book4 = new JLabel("Book 4 ID:");
    public JLabel readerId = new JLabel("Reader ID:");
    public JLabel number = new JLabel("Number:");
    public JLabel borrowDate = new JLabel("Borrow Date:");
    public JLabel returnDate = new JLabel("Return Date");
    public JLabel bookL = new JLabel("Book List ID:");
    public JLabel borrowL = new JLabel("Borrow ID:");
    
    public JDateChooser borrowBar = new JDateChooser();
    public JDateChooser returnBar = new JDateChooser();
    
    public JTextField book1I =  new JTextField();
    public JTextField book2I =  new JTextField();
    public JTextField book3I =  new JTextField();
    public JTextField book4I =  new JTextField();
    public JTextField readerI =  new JTextField();
    public JTextField numberB =  new JTextField();
    public JTextField bookList =  new JTextField();
    public JTextField borrowList =  new JTextField();
    
    public BorrowBookFrame()
    {
        //set frame details
        setTitle("Borrow Book");
        setSize(1000, 600);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

        setLocation (new Point(x, y));
        setLayout(null);
        setResizable(false);

        initComponents();
        initEvent();
    } 
    
    private void initComponents()
    {
        //put coordinate on frame objects
        exit.setBounds(250, 500, 80, 25);
        borrowBook.setBounds(100, 500, 150, 25);
                     
        add(exit);
        add(borrowBook);
        
        book1.setBounds(100, 100, 80, 25);
        book2.setBounds(100, 150, 80, 25);
        book3.setBounds(100, 200, 80, 25);
        book4.setBounds(100, 250, 80, 25);
        number.setBounds(100, 300, 80, 25);
        readerId.setBounds(100, 350, 80, 25);
        borrowDate.setBounds(100, 400, 80, 25);
        returnDate.setBounds(100, 450, 80, 25);
        bookL.setBounds(550, 100, 80, 25);
        borrowL.setBounds(550, 150, 80, 25);
        
        add(book1);
        add(book2);
        add(book3);
        add(book4);
        add(number);
        add(readerId);
        add(borrowDate);
        add(returnDate);
        add(bookL);
        add(borrowL);
        
        book1I.setBounds(300, 100, 150, 25);
        book2I.setBounds(300, 150, 150, 25);
        book3I.setBounds(300, 200, 150, 25);
        book4I.setBounds(300, 250, 150, 25);
        numberB.setBounds(300, 300, 150, 25);
        readerI.setBounds(300, 350, 150, 25);
        borrowBar.setBounds(300, 400, 150, 25);
        returnBar.setBounds(300, 450, 150, 25);
        bookList.setBounds(650, 100, 150, 25);
        borrowList.setBounds(650, 150, 150, 25);
        add(book1I);
        add(book2I);
        add(book3I);
        add(book4I);
        add(numberB);
        add(readerI);
        add(borrowBar);
        add(returnBar);
        add(bookList);
       add(borrowList);
    }
    
    private void initEvent()
    {
        //add events for every button of the frame
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });
        
        exit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                exitEvent(actionEvent);

            }
            });
        
        borrowBook.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                borrowEvent(actionEvent);

            }
            });
    }
    
    private void exitEvent(ActionEvent actionEvent)
    {
        setVisible(false);
        dispose();
    }  
    
     private void borrowEvent(ActionEvent actionEvent)
    { 
        // execute query for borrow book
        try{
            //get dates from textFields
                String book1 = book1I.getText();
                String book2 = book2I.getText();
                String book3 = book3I.getText();
                String book4 = book4I.getText();
                String reader = readerI.getText();
                String bkList = bookList.getText();
                String brList = borrowList.getText();
                String no = numberB.getText();
                int noB = Integer.parseInt(no);
                java.util.Date borrowD = borrowBar.getDate();
                java.util.Date returnD = returnBar.getDate();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                String borrowDate = sdf1.format(borrowBar.getDate().getTime());
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                String returnDate = sdf2.format(returnBar.getDate().getTime());

                
                // connecting at data base
                Connection con = BibliotecaUniversitara.getConnection();
                //sql query
                String sql_listBook = "insert into bookslist values(?,?,?,?,?,?)";
                PreparedStatement pstmtB = con.prepareStatement(sql_listBook);
                pstmtB.setString(1, bkList);
                pstmtB.setInt(2, noB);
                pstmtB.setString(3, book1);
                pstmtB.setString(4, book2);
                pstmtB.setString(5, book3);
                pstmtB.setString(6, book4);
                pstmtB.execute();
                String sql_borrowList = "insert into borrowlist values(?,?,?,?,?, NULL)";
               PreparedStatement pstmtBL = con.prepareStatement(sql_borrowList);
                pstmtBL.setString(1, brList);
                pstmtBL.setString(2,  borrowDate);
                pstmtBL.setString(3, returnDate);
                pstmtBL.setString(4, reader);
                pstmtBL.setString(5, bkList); 
                pstmtBL.execute();
                
                //update the books table
                if (book1 != null )
                {
                String sql_statusUpdate1 = "update books  set status = 'IMPRUMUTAT' where bookId = ? ";
                PreparedStatement pstmt1 = con.prepareStatement(sql_statusUpdate1);
                pstmt1.setString(1, book1);
                pstmt1.execute();
                }
                
                if (book2 != null )
                {
                String sql_statusUpdate2 = "update books  set status = 'IMPRUMUTAT' where bookId = ? ";
                PreparedStatement pstmt2 = con.prepareStatement(sql_statusUpdate2);
                pstmt2.setString(1, book2);
                pstmt2.execute();
                }
                if (book3 != null )
                {
                String sql_statusUpdate3 = "update books  set status = 'IMPRUMUTAT' where bookId = ? ";
                PreparedStatement pstmt3 = con.prepareStatement(sql_statusUpdate3);
                pstmt3.setString(1, book3);
                pstmt3.execute();
                }
                if (book4 != null )
                {
                String sql_statusUpdate4 = "update books  set status = 'IMPRUMUTAT' where bookId = ? ";
                PreparedStatement pstmt4 = con.prepareStatement(sql_statusUpdate4);
                pstmt4.setString(1, book4);
                pstmt4.execute();
                }
                // mesage for success
                JOptionPane.showMessageDialog(null, "Borrow successful!", "Insert", JOptionPane.INFORMATION_MESSAGE);
                }
                //message for error cases
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
    }  
}
