package bibliotecauniversitara;

import javax.swing.JFrame;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NotReturnedFrame extends JFrame
{
    //initiate frame objects
    private JButton exit = new JButton("Exit");
    
    private JTable table = new JTable();
    
    private JScrollPane panel = new JScrollPane();
    private JButton id = new JButton("Book ID");
    private JButton domain = new JButton("Domain");
    private JButton title = new JButton("Title");
    private JButton author = new JButton("Author");
    private JButton publishing = new JButton("Publishing");
    private JButton appearance = new JButton("Appearance");
    private JButton status = new JButton("Status");
    private JButton go = new JButton("Go");
    
    
    DefaultTableModel model = new DefaultTableModel(new String[]{"Book ID", "Domain", "Title", "Author","Publishing", "Appearance", "Status"}, 0);
    public NotReturnedFrame()
    {
        //set frame details
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
        //put coordinate on frame objects
        exit.setBounds(250, 500, 80, 25);
        add(exit);
        
        go.setBounds(400, 100, 100, 25);
        add(go);
        
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
            public void actionPerformed(ActionEvent actionEvent) 
            {
                exitEvent(actionEvent);

            }
        });
        
        go.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) 
            {
                try {
                    goEvent(actionEvent);
                } catch (SQLException ex) {
                    Logger.getLogger(NotReturnedFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    
    private void exitEvent(ActionEvent actionEvent)
    {
        setVisible(false);
        dispose();
    }
    
    private void goEvent(ActionEvent actionEvent) throws SQLException
    {
         try
        { 
            String sql_notReturned = "select bookslist.book1Id, bookslist.book2Id, bookslist.book3Id, bookslist.book4Id  from borrowlist join bookslist on bookslist.booksListId = borrowlist.booksListId where returnDate is NULL and CURRENT_TIMESTAMP > deadline";
            Connection conSA = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtSA = conSA.prepareStatement(sql_notReturned);
            stmtSA.execute();
            ResultSet rez = stmtSA.executeQuery();
            int noRow = 0;
            while(rez.next())
            {
                String sqll = "select * from books where bookId = ? or bookId = ? or bookId = ? or bookId = ?";
                PreparedStatement stmtSA2 = conSA.prepareStatement(sqll);
                stmtSA2.setString(1,  rez.getString("book1Id"));
                stmtSA2.setString(2,  rez.getString("book2Id"));
                stmtSA2.setString(3,  rez.getString("book3Id"));
                stmtSA2.setString(4,  rez.getString("book4Id"));
                stmtSA2.execute();
                ResultSet rez1 = stmtSA2.executeQuery();
                if (rez1.last())
                {
                   noRow = rez1.getRow();
                    rez1.beforeFirst();
                }
                while(rez1.next())
                {
                    model.addRow(new Object[]{rez1.getString(1), rez1.getString(2), rez1.getString(3), rez1.getString(4),  rez1.getString(5), rez1.getString(6),  rez1.getString(7)});
                }
                table.setModel(model);
            }
            table.setModel(model);
            
        
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
