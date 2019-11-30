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

public class UpdateBooksFrame extends JFrame 
{
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
      
        
        updateD.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               // updateDomainEvent(actionEvent);
               
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
            String instruction = updateDomain.getText();
            Statement stmDomain = BibliotecaUniversitara.getConnection().createStatement();
            String sql_updateD = "alter tabel books set domain =" + instruction + "where bookId = ";
            int rs = stmDomain.executeUpdate(sql_updateD);
            
            
            
        }
        
        

}
