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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
 import java.text.SimpleDateFormat;


public class BorrowBookFrame extends JFrame
{ 
    private JButton exit = new JButton("Exit");
    public JButton borrowBook = new JButton("Borrow");
    
    public JLabel bookId = new JLabel("Book ID:");
    public JLabel readerId = new JLabel("Reader ID:");
    public JLabel borrowDate = new JLabel("Borrow Date:");
    public JLabel returnDate = new JLabel("Return Date");
    //jDateChooser1 = new com.toedter.calendar.JDateChooser();
    public JDateChooser borrowBar = new JDateChooser();
     public JDateChooser returnBar = new JDateChooser();
    
    public JTextField bookI =  new JTextField();
    public JTextField readerI =  new JTextField();
    
    public BorrowBookFrame()
    {
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
         exit.setBounds(250, 500, 80, 25);
         borrowBook.setBounds(100, 500, 150, 25);
                     
        add(exit);
        add(borrowBook);
        
        bookId.setBounds(100, 100, 80, 25);
        readerId.setBounds(100, 150, 80, 25);
        borrowDate.setBounds(100, 200, 80, 25);
        returnDate.setBounds(100, 250, 80, 25);
        add(bookId);
        add(readerId);
        add(borrowDate);
        add(returnDate);
        
        bookI.setBounds(300, 100, 150, 25);
        readerI.setBounds(300, 150, 150, 25);
        borrowBar.setBounds(300, 200, 150, 25);
        returnBar.setBounds(300, 250, 150, 25);

        add(bookI);
        add(readerI);
        add(borrowBar);
        add(returnBar);
    }
    
    private void initEvent()
    {
        this.addWindowListener(new WindowAdapter(){
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
    }
    
    private void exitEvent(ActionEvent actionEvent)
        {
            setVisible(false);
            dispose();
        }
    
    
}
