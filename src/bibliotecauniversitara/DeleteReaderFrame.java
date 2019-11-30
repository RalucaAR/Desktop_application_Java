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

public class DeleteReaderFrame extends JFrame
{
    //initiate frame objects
    private JButton exit = new JButton("Exit");
    private JButton deleteR = new JButton("Delete");
    
    private JLabel IDR = new JLabel("ID Reader: ");
    private JTextField IdR = new JTextField();
     
    public DeleteReaderFrame()
    {
        //set frame details
        setTitle("Delete Reader");
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
        deleteR.setBounds(100, 500, 150, 25);
                     
        add(exit);
        add(deleteR);
             
        IDR.setBounds(100, 50, 150, 25);       
       add(IDR);
             
        IdR.setBounds(300, 50, 150, 25);       
        add(IdR);
         
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
             public void actionPerformed(ActionEvent actionEvent)
             {
                exitEvent(actionEvent);

              }
            });


        deleteR.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try
                {
                    deleteReaderEvent(actionEvent);
                } catch (SQLException ex) 
                {
                    Logger.getLogger(DeleteReaderFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
       }

    private void exitEvent(ActionEvent actionEvent)
    {
        setVisible(false);
        dispose();      
    }
        
    private void deleteReaderEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String id = IdR.getText();
            String sql_deleteReader = "delete from readers where readerId = ?";
            Connection conDelR = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtDelR = conDelR.prepareStatement(sql_deleteReader);
            stmtDelR.setString(1, id);
            stmtDelR.execute();
            JOptionPane.showMessageDialog(null, "Row successfully deleted", "Delete", JOptionPane.INFORMATION_MESSAGE);
        }
            catch (Exception ex)
            {
              JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }

    }
}
