package bibliotecauniversitara;

import com.mysql.jdbc.Connection;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateBooksFrame extends JFrame 
{
    //initiate frame objects
    private JButton exit = new JButton("Exit");
    private JButton updateD = new JButton("Update Domain");
    private JButton updateT = new JButton("Update Title");
    private JButton updateAu = new JButton("Update Author");
    private JButton updateP = new JButton("Update Publishing");
    private JButton updateAp = new JButton("Update Appearance");
    private JButton updateS = new JButton("Update Status");

    private JLabel bookI = new JLabel("Book ID:");

     private JTextField updateDomain = new JTextField();
     private JTextField updateTitle = new JTextField();
     private JTextField updateAuthor = new JTextField();
     private JTextField updateAppearance = new JTextField();
     private JTextField updatePublishing = new JTextField();
     private JTextField updateStatus = new JTextField();
     private JTextField bookID = new JTextField();


     public UpdateBooksFrame()
    {
        //set frame details
        setTitle("Update Book");
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
         bookI.setBounds(100, 50, 150, 25);
         updateD.setBounds(100, 100, 150, 25);
         updateT.setBounds(100, 150, 150, 25);
         updateAu.setBounds(100, 200, 150, 25);
         updateAp.setBounds(100, 250, 150, 25);
         updateP.setBounds(100, 300, 150, 25);
         updateS.setBounds(100, 350, 150, 25);

         add(exit);
         add(bookI);
         add(updateD);
         add(updateT);
         add(updateAu);
         add(updateAp);
         add(updateP);
         add(updateS);

         bookID.setBounds(300, 50, 150, 25);
         updateDomain.setBounds(300, 100, 150, 25);
         updateTitle.setBounds(300, 150, 150, 25);
         updateAuthor.setBounds(300, 200, 150, 25);
         updateAppearance.setBounds(300, 250, 150, 25);
         updatePublishing.setBounds(300, 300, 150, 25);
         updateStatus.setBounds(300, 350, 150, 25);

         add(updateDomain);
         add(updateTitle);
         add(updateAuthor);
         add(updateAppearance);
         add(updatePublishing);
         add(updateStatus);
         add(bookID);

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
      
        
        updateD.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                try {
                    updateDomainEvent(actionEvent);
                } catch (SQLException ex)
                {
                    Logger.getLogger(UpdateBooksFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        
        updateT.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                try {
                    updateTitleEvent(actionEvent);
                } catch (SQLException ex)
                {
                    Logger.getLogger(UpdateBooksFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        
        updateAu.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                try {
                    updateAuthorEvent(actionEvent);
                } catch (SQLException ex) 
                {
                    Logger.getLogger(UpdateBooksFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        
        updateAp.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                try {
                    updateAppearanceEvent(actionEvent);
                } catch (SQLException ex)
                {
                    Logger.getLogger(UpdateBooksFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
         
        updateP.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                try {
                    updatePublishingEvent(actionEvent);
                } catch (SQLException ex)
                {
                    Logger.getLogger(UpdateBooksFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          
        updateS.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                try {
                    updateStatusEvent(actionEvent);
                } catch (SQLException ex)
                {
                    Logger.getLogger(UpdateBooksFrame.class.getName()).log(Level.SEVERE, null, ex);
                }              
            }
        });
        }

        private void exitEvent(ActionEvent actionEvent)
        {
            setVisible(false);
            dispose();
        }
        
        private void updateDomainEvent(ActionEvent actionEvent) throws SQLException
        { 
            try
            {
                String id = bookID.getText();
                String instruction = updateDomain.getText();
                String sql_updateD = "update books set domain = ?   where bookId = ? ";
                Connection conD = BibliotecaUniversitara.getConnection();
                PreparedStatement pstmtD = conD.prepareStatement(sql_updateD);
                pstmtD.setString(1, instruction);
                pstmtD.setString(2, id);
                pstmtD.execute();
                JOptionPane.showMessageDialog(null, "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);

            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
  
        } 
        
        private void updateTitleEvent(ActionEvent actionEvent) throws SQLException
        {
            try
            {
            String id = bookID.getText();
            String instruction = updateTitle.getText();
            String sql_updateT = "update books set title = ?  where bookId = ?";
            Connection conT = BibliotecaUniversitara.getConnection();
            PreparedStatement pstmtT = conT.prepareStatement(sql_updateT);
            pstmtT.setString(1, instruction);
            pstmtT.setString(2, id);
            pstmtT.execute();
            JOptionPane.showMessageDialog(null, "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
        
        private void updateAuthorEvent(ActionEvent actionEvent) throws SQLException
        {
            try
            {
                String id = bookID.getText();
                String instruction = updateAuthor.getText();
                String sql_updateAuthor = "update books set author = ?  where bookId = ?";
                Connection conAu = BibliotecaUniversitara.getConnection();
                PreparedStatement stmtAu = conAu.prepareStatement(sql_updateAuthor);
                stmtAu.setString(1, instruction);
                stmtAu.setString(2, id);
                stmtAu.execute();
                JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
            
        private void updateAppearanceEvent(ActionEvent actionEvent) throws SQLException
        {
            try
            {
                String id = bookID.getText();
                String instruction = updateAppearance.getText();
                String sql_updateAppearance = "update books set appearance = ?  where bookId = ?";
                Connection conAu = BibliotecaUniversitara.getConnection();
                PreparedStatement stmtAu = conAu.prepareStatement(sql_updateAppearance);
                stmtAu.setString(1, instruction);
                stmtAu.setString(2, id);
                stmtAu.execute();
                JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }            
        } 
            
        private void updatePublishingEvent(ActionEvent actionEvent) throws SQLException
        {
            try
            {
                String id = bookID.getText();
                String instruction = updatePublishing.getText();
                String sql_updatePublishing = "update books set publishing = ?  where bookId = ?";
                Connection conAu = BibliotecaUniversitara.getConnection();
                PreparedStatement stmtAu = conAu.prepareStatement(sql_updatePublishing);
                stmtAu.setString(1, instruction);
                stmtAu.setString(2, id);
                stmtAu.execute();
                JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
            
        private void updateStatusEvent(ActionEvent actionEvent) throws SQLException
        {
            try
            {
                String id = bookID.getText();
                String instruction = updateStatus.getText();
                String sql_updateStatus = "update books set status = ?  where bookId = ?";
                Connection conAu = BibliotecaUniversitara.getConnection();
                PreparedStatement stmtAu = conAu.prepareStatement(sql_updateStatus);
                stmtAu.setString(1, instruction);
                stmtAu.setString(2, id);
                stmtAu.execute();
                JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }             
        }
}


