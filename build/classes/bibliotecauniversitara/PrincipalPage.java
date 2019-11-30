package bibliotecauniversitara;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PrincipalPage extends JFrame{
    private JButton exit = new JButton("Exit");
    private JButton updateBook = new JButton("Update book");
    private JButton updateReader = new JButton("Update reader");
    private JButton insertBook = new JButton("Insert book");
    private JButton insertReader = new JButton("Insert reader");
    private JButton deleteBook = new JButton("Delete book");
    private JButton deleteReader = new JButton("Delete reader");
    private JButton searchBook = new JButton("Search book");
    private JButton searchReader = new JButton("Search reader");
    private JButton borrowBook = new JButton("Borrow book");
    private JButton returnBook = new JButton("Return book");
    private JButton notReturnedBooks = new JButton("Not Returned");
    
     public PrincipalPage()
    {
        setTitle("Biblioteca Universitara");
        setSize(1000, 600);
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        
         int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
         int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

         
         setLocation (new Point(x, y));
         setLayout(null);
         //setLayout(new BorderLayout());

        //JLabel background=new JLabel(new ImageIcon("C:\\Users\\Alexandra\\Downloads\\library.jpg"));

        //add(background);
        //background.setLayout(new FlowLayout());

         setResizable(false);
         
         initComponents();
         initEvent();
        
    }
    
      private void initComponents()
        {
            exit.setBounds(50, 500, 80, 25);
            updateBook.setBounds(100, 100, 200, 25);
            insertBook.setBounds(400, 100, 200, 25);
            deleteBook.setBounds(700, 100, 200, 25);
            updateReader.setBounds(100, 200, 200, 25);
            insertReader.setBounds(400, 200, 200, 25);
            deleteReader.setBounds(700, 200, 200, 25);
            searchBook.setBounds(250, 300, 200, 25);
            searchReader.setBounds(550, 300, 200, 25);
            borrowBook.setBounds(250, 400, 200, 25);
            returnBook.setBounds(550, 400, 200, 25);
            notReturnedBooks.setBounds(400, 500, 200, 25);

            add(exit);
            add(updateBook);
            add(insertBook);
            add(deleteBook);
            add(updateReader);
            add(insertReader);
            add(deleteReader);
            add(searchBook);
            add(searchReader);
            add(borrowBook);
            add(returnBook);
            add(notReturnedBooks);

        }
    
       private void initEvent()
       {
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        }
        );
        
        exit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                exitEvent(actionEvent);
            }
            
        });
        
        updateBook.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                updateBooksEvent(actionEvent);
            }
            
        });
        
        updateReader.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                updateReaderEvent(actionEvent);
            }
            
        });
        
        insertBook.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                insertBooksEvent(actionEvent);
            }
            
        });
        
        insertReader.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                insertReaderEvent(actionEvent);
            }
            
        });
        
        deleteBook.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                deleteBookEvent(actionEvent);
            }
            
        });
        
        deleteReader.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                deleteReaderEvent(actionEvent);
            }
            
        });
        
        searchBook.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                searchBookEvent(actionEvent);
            }
           
        });
        
        searchReader.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                searchReaderEvent(actionEvent);
            }
        });
        
        borrowBook.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                borrowBookEvent(actionEvent);
            }
        });
        
         returnBook.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                returnBookEvent(actionEvent);
            }
        });
         
        notReturnedBooks.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                notReturnedBooksEvent(actionEvent);
            }
        });
    }
    private void exitEvent(ActionEvent actionEvent)
    {
        System.exit(0);
    }
    
    private void updateBooksEvent(ActionEvent actionEvent)
    {
        UpdateBooksFrame upB = new UpdateBooksFrame();
        upB.setVisible(true);
    }  
    
    private void updateReaderEvent(ActionEvent actionEvent)
    {
        UpdateReaderFrame upR = new UpdateReaderFrame();
        upR.setVisible(true);
    } 
    
    private void insertBooksEvent(ActionEvent actionEvent)
    {
        InsertBooksFrame inB = new InsertBooksFrame();
        inB.setVisible(true);
    }   
    
    private void insertReaderEvent(ActionEvent actionEvent)
    {
        InsertReaderFrame inR = new InsertReaderFrame();
        inR.setVisible(true);
    } 
    
    private void deleteBookEvent(ActionEvent actionEvent)
    {
        DeleteBookFrame deB = new DeleteBookFrame();
        deB.setVisible(true);
    } 
    
    private void deleteReaderEvent(ActionEvent actionEvent)
    {
        DeleteReaderFrame deR = new DeleteReaderFrame();
        deR.setVisible(true);
    } 
    
    private void searchBookEvent(ActionEvent actionEvent)
    {
        SearchBookFrame seB = new SearchBookFrame();
        seB.setVisible(true);
    }
    
    private void searchReaderEvent(ActionEvent actionEvent)
    {
        SearchReaderFrame seR = new SearchReaderFrame();
        seR.setVisible(true);
    }
    
    private void borrowBookEvent(ActionEvent actionEvent)
    {
        BorrowBookFrame brB = new BorrowBookFrame();
        brB.setVisible(true);
    }
    
     private void returnBookEvent(ActionEvent actionEvent)
    {
        ReturnBookFrame rtB = new ReturnBookFrame();
        rtB.setVisible(true);
    }
     
     private void notReturnedBooksEvent(ActionEvent actionEvent)
    {
        NotReturnedFrame nrB = new NotReturnedFrame();
        nrB.setVisible(true);
    }
}
