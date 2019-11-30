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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchBookFrame extends JFrame
{
    //initiate frame objects
    private JLabel titleB = new JLabel("Book title:");
    private JLabel authorB = new JLabel("Book author:");
    
    private JTextField titleBook = new JTextField();
    private JTextField authorBook = new JTextField();
    
    private JButton searchBookTitle = new JButton("Search by title");
    private JButton searchBookAuthor = new JButton("Search by Author");
    private JButton id = new JButton("Book ID");
    private JButton domain = new JButton("Domain");
    private JButton title = new JButton("Title");
    private JButton author = new JButton("Author");
    private JButton publishing = new JButton("Publishing");
    private JButton appearance = new JButton("Appearance");
    private JButton status = new JButton("Status");
    private JButton exit = new JButton("Exit");
    
    private JTextArea textArea = new JTextArea();
    private JTable table = new JTable();
    
    private JScrollPane panel = new JScrollPane();
    
    DefaultTableModel model = new DefaultTableModel(new String[]{"Book ID", "Domain", "Title", "Author","Publishing", "Appearance", "Status"}, 0);
    
    public SearchBookFrame()
    {
        //set frame details
        setTitle("Search Book");
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
        
        exit.setBounds(250, 530, 80, 25);
        titleB.setBounds(100, 100, 100, 25);
        authorB.setBounds(100, 200, 100, 25);
        add(exit);
        add(titleB);
        add(authorB);
        
        titleBook.setBounds(200, 100, 300, 25);
        authorBook.setBounds(200, 200, 300, 25);
        add(titleBook);
        add(authorBook);
        
        searchBookTitle.setBounds(600, 100, 200, 25);
        searchBookAuthor.setBounds(600, 200, 200, 25);
        add(searchBookTitle);
        add(searchBookAuthor);
        id.setBounds(10, 275, 140, 25);
        domain.setBounds(150, 275, 140, 25);
        title.setBounds(290, 275, 140, 25);
        author.setBounds(430, 275, 140, 25);
        appearance.setBounds(570, 275, 140, 25);
        publishing.setBounds(710, 275, 140, 25);
        status.setBounds(850, 275, 140, 25);
        add(id);
        add(domain);
        add(title);
        add(author);
        add(appearance);
        add(publishing);
        add(status);
       

       table.setBounds(10, 300, 980, 95);
        add(table);
        
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
        
        searchBookTitle.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        searchByTitleEvent(actionEvent);
                    } catch (SQLException ex) {
                        Logger.getLogger(SearchBookFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        
        searchBookAuthor.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        searchByAuthorEvent(actionEvent);
                    } catch (SQLException ex) {
                        Logger.getLogger(SearchBookFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
    
    }
    
    private void exitEvent(ActionEvent actionEvent)
    {
        setVisible(false);
        dispose();
    }
    
    private void searchByTitleEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String title = titleBook.getText();
            String sql_searchTitle = "select * from books where title = ?";
            Connection conST = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtST = conST.prepareStatement(sql_searchTitle);
            stmtST.setString(1, title);
            stmtST.execute();
            ResultSet rez = stmtST.executeQuery();
            int noRow = 0;
            if (rez.last())
            {
               noRow = rez.getRow();
                rez.beforeFirst();
            }
        
            if (noRow >= 1)
                 JOptionPane.showMessageDialog(null, "Row found", "Search", JOptionPane.INFORMATION_MESSAGE); 
            else
                  JOptionPane.showMessageDialog(null, "Row not found!", "Error", JOptionPane.ERROR_MESSAGE);
            
            while(rez.next())
            {
               
                model.addRow(new Object[]{rez.getString(1), rez.getString(2), rez.getString(3),  rez.getString(4), rez.getString(5), rez.getString(6), rez.getString(7)});
            }
            table.setModel(model);

        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void searchByAuthorEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String author = authorBook.getText();
            String sql_searchAuthor = "select * from books where author = ?";
            Connection conSA = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtSA = conSA.prepareStatement(sql_searchAuthor);
            stmtSA.setString(1, author);
            stmtSA.execute();
            ResultSet rez = stmtSA.executeQuery();
            int noRow = 0;
            if (rez.last())
            {
               noRow = rez.getRow();
                rez.beforeFirst();
            }
        
            if (noRow >= 1)
                 JOptionPane.showMessageDialog(null, "Row found", "Search", JOptionPane.INFORMATION_MESSAGE); 
            else
                  JOptionPane.showMessageDialog(null, "Row not found!", "Error", JOptionPane.ERROR_MESSAGE);
            while(rez.next())
            {
               
                model.addRow(new Object[]{rez.getString(1), rez.getString(2), rez.getString(3),  rez.getString(4), rez.getString(5), rez.getString(6), rez.getString(7)});
            }
            table.setModel(model);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
