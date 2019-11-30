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

public class SearchReaderFrame extends JFrame
{
    private JLabel nameR = new JLabel("Reader name:");
    private JLabel CNPR = new JLabel("Reader CNP:");
    
    private JTextField nameReader = new JTextField();
    private JTextField CNPReader = new JTextField();
    
    private JButton searchReader = new JButton("Search");
    private JButton exit = new JButton("Exit");
    
    public SearchReaderFrame()
    {
        setTitle("Search Reader");
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
        nameR.setBounds(100, 100, 100, 25);
        CNPR.setBounds(100, 200, 100, 25);
        add(exit);
        add(nameR);
        add(CNPR);
        
        nameReader.setBounds(200, 100, 300, 25);
        CNPReader.setBounds(200, 200, 300, 25);
        add(nameReader);
        add(CNPReader);
        
        searchReader.setBounds(200, 300, 100, 25);
        add(searchReader);
        
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
