package bibliotecauniversitara;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchBookFrame extends JFrame
{
    private JLabel titleB = new JLabel("Book title:");
    private JLabel authorB = new JLabel("Book author:");
    
    private JTextField titleBook = new JTextField();
    private JTextField authorBook = new JTextField();
    
    private JButton searchBook = new JButton("Search");
    private JButton exit = new JButton("Exit");
    
    public SearchBookFrame()
    {
        setTitle("Search Book");
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
        titleB.setBounds(100, 100, 100, 25);
        authorB.setBounds(100, 200, 100, 25);
        add(exit);
        add(titleB);
        add(authorB);
        
        titleBook.setBounds(200, 100, 300, 25);
        authorBook.setBounds(200, 200, 300, 25);
        add(titleBook);
        add(authorBook);
        
        searchBook.setBounds(200, 300, 100, 25);
        add(searchBook);
        
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
