package bibliotecauniversitara;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class InsertBooksFrame extends JFrame
{
    //initiate frame objects
     private JButton exit = new JButton("Exit");
     private JButton insertD = new JButton("Insert");
       
    private JTextField insertDomain = new JTextField();
    private JTextField insertTitle = new JTextField();
    private JTextField insertAuthor = new JTextField();
    private JTextField insertAppearance = new JTextField();
    private JTextField insertPublishing = new JTextField();
    private JTextField insertStatus = new JTextField();
    private JTextField bookID = new JTextField();
         
    private JLabel domain = new JLabel("Domain: ");
    private JLabel title = new JLabel("Title: ");
    private JLabel author = new JLabel("Author: ");
    private JLabel appearance = new JLabel("Appearance: ");
    private JLabel publishing = new JLabel("Publishing: ");
    private JLabel status = new JLabel("Status: ");
    private JLabel book = new JLabel("Book ID: ");

    public InsertBooksFrame()
    {
        //set frame details
        setTitle("Insert Book");
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
        insertD.setBounds(100, 500, 150, 25);
                     
        add(exit);
        add(insertD);
             
        book.setBounds(100, 50, 150, 25);
        domain.setBounds(100, 100, 150, 25);
        title.setBounds(100, 150, 150, 25);
        author.setBounds(100, 200, 150, 25);
        appearance.setBounds(100, 250, 150, 25);
        publishing.setBounds(100, 300, 150, 25);
        status.setBounds(100, 350, 150, 25);
            
        add(domain);
        add(title);
        add(author);
        add(appearance);
        add(publishing);
        add(status);
        add(book);
             
        bookID.setBounds(300, 50, 150, 25);
        insertDomain.setBounds(300, 100, 300, 25);
        insertTitle.setBounds(300, 150, 300, 25);
        insertAuthor.setBounds(300, 200, 300, 25);
        insertAppearance.setBounds(300, 250, 300, 25);
        insertPublishing.setBounds(300, 300, 300, 25);
        insertStatus.setBounds(300, 350, 300, 25);
             
        add(insertDomain);
        add(insertTitle);
        add(insertAuthor);
        add(insertAppearance);
        add(insertPublishing);
        add(insertStatus);
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
      
        
        insertD.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               insertEvent(actionEvent);
               
            }
        });
       }

        private void exitEvent(ActionEvent actionEvent)
        {
            setVisible(false);
            dispose();
        }
        
        private void insertEvent(ActionEvent actionEvent)
        {
            try{
                String idField = bookID.getText();
                String domainField = insertDomain.getText();
                String titleField = insertTitle.getText();
                String authorField = insertAuthor.getText();
                String appearanceField = insertAppearance.getText();
                int appField = Integer.parseInt(appearanceField);
                String publishingField = insertPublishing.getText();
                String statusField = insertStatus.getText();

                Connection con = BibliotecaUniversitara.getConnection();
                String sql = "insert into books values(?,?,?,?,?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, idField);
                pstmt.setString(2, domainField);
                pstmt.setString(3, titleField);
                pstmt.setString(4, authorField);
                pstmt.setString(5, publishingField);
                pstmt.setInt(6, appField);
                pstmt.setString(7, statusField);
                pstmt.execute();
                JOptionPane.showMessageDialog(null, "Row successfully inserted", "Insert", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
}
