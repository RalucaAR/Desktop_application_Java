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

public class UpdateReaderFrame extends JFrame 
{
    //initiate frame objects
    private JButton exit = new JButton("Exit");
    private JButton updateC = new JButton("Update CNP");
    private JButton updateL = new JButton("Update Last Name");
    private JButton updateF = new JButton("Update First Name");
    private JButton updateT = new JButton("Update Telephone");
    private JButton updateE = new JButton("Update Email");
    private JButton updateFa= new JButton("Update Faculty");


     private JTextField updateCNP = new JTextField();
     private JTextField updateLastName = new JTextField();
     private JTextField updateFirstName = new JTextField();
     private JTextField updateTelephone = new JTextField();
     private JTextField updateEmail = new JTextField();
     private JTextField updateFaculty = new JTextField();
     private JTextField reader = new JTextField();
     private JLabel readerID = new JLabel("Reader ID");


     public UpdateReaderFrame()
    {
        //initiate frame coordinate
        setTitle("Update Reader");
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
         readerID.setBounds(100, 50, 150, 25);
         updateC.setBounds(100, 100, 150, 25);
         updateL.setBounds(100, 150, 150, 25);
         updateF.setBounds(100, 200, 150, 25);
         updateT.setBounds(100, 250, 150, 25);
         updateE.setBounds(100, 300, 150, 25);
         updateFa.setBounds(100, 350, 150, 25);


         add(exit);

         add(readerID);
         add(updateC);
         add(updateL);
         add(updateF);
         add(updateT);
         add(updateE);
         add(updateFa);

         reader.setBounds(300, 50, 150, 25);
         updateCNP.setBounds(300, 100, 150, 25);
         updateLastName.setBounds(300, 150, 150, 25);
         updateFirstName.setBounds(300, 200, 150, 25);
         updateTelephone.setBounds(300, 250, 150, 25);
         updateEmail.setBounds(300, 300, 150, 25);
         updateFaculty.setBounds(300, 350, 150, 25);

         add(updateCNP);
         add(updateLastName);
         add(updateFirstName);
         add(updateTelephone);
         add(updateEmail);
         add(updateFaculty);
         add(reader);


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
        public void actionPerformed(ActionEvent actionEvent) {
            exitEvent(actionEvent);

        }
    });


    updateC.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try 
            {
                updateCNPEvent(actionEvent);
            } catch (SQLException ex)
              {
                  Logger.getLogger(UpdateReaderFrame.class.getName()).log(Level.SEVERE, null, ex);
              }              
        }
    });

    updateL.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try
            {
                updateLastEvent(actionEvent);
            } catch (SQLException ex) 
              {
                  Logger.getLogger(UpdateReaderFrame.class.getName()).log(Level.SEVERE, null, ex);
              }

        }
    });

    updateF.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) 
        {
            try 
            {
                updateFirstEvent(actionEvent);
            } catch (SQLException ex) 
              {
                  Logger.getLogger(UpdateReaderFrame.class.getName()).log(Level.SEVERE, null, ex);
              }              
        }
    });

    updateT.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) 
        {
            try 
            {
                updateTelephoneEvent(actionEvent);
            } catch (SQLException ex)
              {
                  Logger.getLogger(UpdateReaderFrame.class.getName()).log(Level.SEVERE, null, ex);
              }

        }
    });

    updateE.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) 
        {
            try 
            {
                updateEmailEvent(actionEvent);
            } catch (SQLException ex) 
              {
                  Logger.getLogger(UpdateReaderFrame.class.getName()).log(Level.SEVERE, null, ex);
              }

        }
    });

   updateFa.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            try 
            {
                updateFacultyEvent(actionEvent);
            } catch (SQLException ex) 
              {
                  Logger.getLogger(UpdateReaderFrame.class.getName()).log(Level.SEVERE, null, ex);
              }

        }
    });

    }
    private void exitEvent(ActionEvent actionEvent)
    {
        setVisible(false);
        dispose();
    }

    private void updateCNPEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String id = reader.getText();
            String instruction = updateCNP.getText();
            String sql_updateCNP = "update readers set CNP = ?  where readerId = ?";
            Connection conC = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtC = conC.prepareStatement(sql_updateCNP);
            stmtC.setString(1, instruction);
            stmtC.setString(2, id);
            stmtC.execute();
            JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }            
    } 

    private void updateLastEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String id = reader.getText();
            String instruction = updateLastName.getText();
            String sql_updateLastName = "update readers set lastName = ?  where readerId = ?";
            Connection conL = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtL = conL.prepareStatement(sql_updateLastName);
            stmtL.setString(1, instruction);
            stmtL.setString(2, id);
            stmtL.execute();
            JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }            
    } 

    private void updateFirstEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String id = reader.getText();
            String instruction = updateFirstName.getText();
            String sql_updateFirstName = "update readers set firstName = ?  where readerId = ?";
            Connection conF = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtF = conF.prepareStatement(sql_updateFirstName);
            stmtF.setString(1, instruction);
            stmtF.setString(2, id);
            stmtF.execute();
            JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }            
    } 

    private void updateTelephoneEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String id = reader.getText();
            String instruction = updateTelephone.getText();
            String sql_updateTelephone = "update readers set telephone = ?  where readerId = ?";
            Connection conT = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtT = conT.prepareStatement(sql_updateTelephone);
            stmtT.setString(1, instruction);
            stmtT.setString(2, id);
            stmtT.execute();
            JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }            
    } 

    private void updateEmailEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String id = reader.getText();
            String instruction = updateEmail.getText();
            String sql_updateEmail = "update readers set email = ?  where readerId = ?";
            Connection conE = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtE = conE.prepareStatement(sql_updateEmail);
            stmtE.setString(1, instruction);
            stmtE.setString(2, id);
            stmtE.execute();
            JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }            
    } 


    private void updateFacultyEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String id = reader.getText();
            String instruction = updateFaculty.getText();
            String sql_updateFaculty = "update readers set faculty = ?  where readerId = ?";
            Connection conF = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtF = conF.prepareStatement(sql_updateFaculty);
            stmtF.setString(1, instruction);
            stmtF.setString(2, id);
            stmtF.execute();
            JOptionPane.showMessageDialog(null,  "Row successfully updated", "Update", JOptionPane.INFORMATION_MESSAGE);   
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }            
    } 
}
