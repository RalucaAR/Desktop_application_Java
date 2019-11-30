
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertReaderFrame extends JFrame
{
    //initiate frame objects
    private JButton exit = new JButton("Exit");
    private JButton insert = new JButton("Insert");
         
    private JTextField insertCNP = new JTextField();
    private JTextField insertLastName = new JTextField();
    private JTextField insertFirstName = new JTextField();
    private JTextField insertTelephone = new JTextField();
    private JTextField insertEmail = new JTextField();
    private JTextField insertFaculty = new JTextField();
    private JTextField readerID = new JTextField();
         
    private JLabel CNP = new JLabel("CNP: ");
    private JLabel lastName = new JLabel("Last Name: ");
    private JLabel firstName = new JLabel("First Name: ");
    private JLabel telephone = new JLabel("Telephone: ");
    private JLabel email = new JLabel("Email: ");
    private JLabel faculty = new JLabel("Faculty: ");
    private JLabel reader = new JLabel("Reader ID: ");
                
    public InsertReaderFrame()
    {
            //set frame details
            setTitle("Insert Reader");
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
         insert.setBounds(100, 500, 150, 25);

         add(exit);
         add(insert);

         readerID.setBounds(300, 50, 150, 25);
         insertCNP.setBounds(300, 100, 300, 25);
         insertLastName.setBounds(300, 150, 300, 25);
         insertFirstName.setBounds(300, 200, 300, 25);
         insertTelephone.setBounds(300, 250, 300, 25);
         insertEmail.setBounds(300, 300, 300, 25);
         insertFaculty.setBounds(300, 350, 300, 25);

         add(insertCNP);
         add(insertLastName);
         add(insertFirstName);
         add(insertTelephone);
         add(insertEmail);
         add(insertFaculty);
         add(readerID);

         reader.setBounds(100, 50, 150, 25);
         CNP.setBounds(100, 100, 150, 25);
         lastName.setBounds(100, 150, 150, 25);
         firstName.setBounds(100, 200, 150, 25);
         telephone.setBounds(100, 250, 150, 25);
         email.setBounds(100, 300, 150, 25);
         faculty.setBounds(100, 350, 150, 25);


         add(CNP);
         add(lastName);
         add(firstName);
         add(telephone);
         add(email);
         add(faculty);
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
         });

        exit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                exitEvent(actionEvent);

            }
        });


        insert.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                insertReaderEvent(actionEvent);

            }
        });
    }

    private void exitEvent(ActionEvent actionEvent)
    {
        setVisible(false);
        dispose();
    }

    private void insertReaderEvent(ActionEvent actionEvent)
    {
        try
        {
            String idField = readerID.getText();
            String CNPField = insertCNP.getText();
            String lastField = insertLastName.getText();
            String firstField = insertFirstName.getText();
            String telephoneField = insertTelephone.getText();
            String emailField = insertEmail.getText();
            String facultyField = insertFaculty.getText();

            Connection con = BibliotecaUniversitara.getConnection();
            String insertReader = "insert into readers values(?,?,?,?,?,?,?)";
            PreparedStatement pstmtReader = con.prepareStatement(insertReader);
            pstmtReader.setString(1, idField);
            pstmtReader.setString(2, CNPField);
            pstmtReader.setString(3, lastField);
            pstmtReader.setString(4, firstField);
            pstmtReader.setString(5, telephoneField);
            pstmtReader.setString(6, emailField);
            pstmtReader.setString(7, facultyField);
            pstmtReader.execute();
            JOptionPane.showMessageDialog(null, "Row successfully inserted", "Insert", JOptionPane.INFORMATION_MESSAGE);

        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
