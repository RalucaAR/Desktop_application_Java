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

public class NotReturnedFrame extends JFrame
{
    private JButton exit = new JButton("Exit");
    public NotReturnedFrame()
    {
        setTitle("Not returned books");
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
        add(exit);
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
