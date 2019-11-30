package bibliotecauniversitara;

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

public class ReturnBookFrame extends JFrame
{
     private JButton exit = new JButton("Exit");
     private JButton returnB = new JButton("Return Book");
     
     private JTextField book = new JTextField();
     
     private JLabel bookId = new JLabel("Book ID");
     
     public ReturnBookFrame()
     {
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
     }
     
      private void exitEvent(ActionEvent actionEvent)
        {
            setVisible(false);
            dispose();
        }
    
}
