package bibliotecauniversitara;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteBookFrame extends JFrame
{
    //initiate frame objects 
    private JButton exit = new JButton("Exit");
    private JButton delete = new JButton("Delete");
    
    private JLabel ID = new JLabel("ID Book: ");
    private JTextField Id = new JTextField();
     
    public DeleteBookFrame()
    {
        //set frame details
        setTitle("Delete Book");
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
        delete.setBounds(100, 500, 150, 25);
                     
        add(exit);
        add(delete);
             
        ID.setBounds(100, 50, 150, 25);
        add(ID);
          
        Id.setBounds(300, 50, 150, 25);
        add(Id);
         
    }
        
    private void initEvent()
    {
        this.addWindowListener(new WindowAdapter()
        {
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
        
        delete.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try
                {
                    deleteEvent(actionEvent);
                } catch (SQLException ex)
                {
                    Logger.getLogger(DeleteBookFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    private void exitEvent(ActionEvent actionEvent)
    {
        setVisible(false);
        dispose();
    }
    
    private void deleteEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String id = Id.getText();
            String sql_deleteBook = "delete from books where bookId = ?";
            Connection conD = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtDelB = conD.prepareStatement(sql_deleteBook);
            stmtDelB.setString(1, id);
            stmtDelB.execute();
            JOptionPane.showMessageDialog(null, "Row successfully deleted", "Delete", JOptionPane.INFORMATION_MESSAGE);
        }
            catch (Exception ex)
            {
              JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        
    }
        
 
}
