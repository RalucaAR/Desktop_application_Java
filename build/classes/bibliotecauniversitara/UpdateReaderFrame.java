package bibliotecauniversitara;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateReaderFrame extends JFrame 
{
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
         private JLabel readerID = new JLabel("Reader ID");

        
         public UpdateReaderFrame()
        {
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
             exit.setBounds(250, 500, 80, 25);
             updateC.setBounds(100, 50, 150, 25);
             updateL.setBounds(100, 100, 150, 25);
             updateF.setBounds(100, 150, 150, 25);
             updateT.setBounds(100, 200, 150, 25);
             updateE.setBounds(100, 250, 150, 25);
             updateFa.setBounds(100, 300, 150, 25);
             
                     
             add(exit);
             
             add(updateC);
             add(updateL);
             add(updateF);
             add(updateT);
             add(updateE);
             add(updateFa);
             
             readerID.setBounds(300, 50, 150, 25);
             updateCNP.setBounds(300, 50, 150, 25);
             updateLastName.setBounds(300, 100, 150, 25);
             updateFirstName.setBounds(300, 150, 150, 25);
             updateTelephone.setBounds(300, 200, 150, 25);
             updateEmail.setBounds(300, 300, 250, 25);
             updateFaculty.setBounds(300, 300, 150, 25);
             
             add(updateCNP);
             add(updateLastName);
             add(updateFirstName);
             add(updateTelephone);
             add(updateEmail);
             add(updateFaculty);
             add(readerID);
                    
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
            public void actionPerformed(ActionEvent actionEvent) {
                exitEvent(actionEvent);
               
            }
        });
      
        }
//        updateD.addActionListener(new ActionListener() 
//        {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//               // updateDomainEvent(actionEvent);
//               
//            }
//        });
//        }

        private void exitEvent(ActionEvent actionEvent)
        {
            setVisible(false);
            dispose();
        }
        
//        private void updateDomainEvent(ActionEvent actionEvent) throws SQLException
//        {
//            String instruction = updateDomain.getText();
//            Statement stmDomain = BibliotecaUniversitara.getConnection().createStatement();
//            String sql_updateD = "alter tabel books set domain = instruction where bookId = ";
//            //ResultSet rs = stmDomain.executeUpdate(sql_updateD);
//            
//            
//            
//        }
        
        

}
