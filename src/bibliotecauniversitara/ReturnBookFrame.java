package bibliotecauniversitara;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
 import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class ReturnBookFrame extends JFrame
{
    //initiate frame objects
     private JButton exit = new JButton("Exit");
     private JButton returnB = new JButton("Return Book");
     
     private JTextField book = new JTextField();
     
     private JLabel bookId = new JLabel("Book ID");
     
     public ReturnBookFrame()
     {
         //set frame details
        setTitle("Return Book");
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
         returnB.setBounds(200, 400, 150, 25);
         
         add(exit);
         add(returnB);
         
         book.setBounds(200, 100, 80, 25);
         bookId.setBounds(100, 100, 80, 25);
         add(book);
         add(bookId);
         
     }
     
     private void initEvent()
     {
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
            public void actionPerformed(ActionEvent actionEvent) {
                exitEvent(actionEvent);

            }
        });
        
        returnB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                returnBookEvent(actionEvent);

            }
        });
     }
     
    private void exitEvent(ActionEvent actionEvent)
    {
        setVisible(false);
        dispose();
    }
    
    private void returnBookEvent(ActionEvent actionEvent)
    {
         try
        {
            String bookID = book.getText();
            String sql_updateBookStatus = "update books set status = 'RAFT' where bookId = ?";
            String sql_updateReturnDate = "update borrowlist bl inner join bookslist bk on bl.booksListId = bk.booksListId set bl.returnDate = CURRENT_TIMESTAMP where bk.book1Id = ? or bk.book2Id = ? or bk.book3Id = ? or bk.book4Id = ?";
            Connection conBR = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtBR = conBR.prepareStatement(sql_updateBookStatus);
            stmtBR.setString(1, bookID);
            stmtBR.execute();
            PreparedStatement stmtBRD = conBR.prepareStatement(sql_updateReturnDate);
            stmtBRD.setString(1, bookID);
            stmtBRD.setString(2, bookID);
            stmtBRD.setString(3, bookID);
            stmtBRD.setString(4, bookID);
            stmtBRD.execute();
            
            
            JOptionPane.showMessageDialog(null, "Book returned", "Returned", JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
