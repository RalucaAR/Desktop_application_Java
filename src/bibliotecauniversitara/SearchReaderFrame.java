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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchReaderFrame extends JFrame
{
    //initiate frame objects
    private JLabel nameR = new JLabel("Reader name:");
    private JLabel CNPR = new JLabel("Reader CNP:");
    
    private JTextField nameReader = new JTextField();
    private JTextField CNPReader = new JTextField();
    
    private JButton searchCNP = new JButton("Search by CNP");
    private JButton searchName = new JButton("Search by name");
    private JButton id = new JButton("Reader ID");
    private JButton cnp = new JButton("CNP");
    private JButton last = new JButton("Last Name");
    private JButton first = new JButton("First Name");
    private JButton tel = new JButton("Telephone");
    private JButton email = new JButton("Email");
    private JButton fac = new JButton("Faculty");
    private JButton exit = new JButton("Exit");
    
    private JTextArea textArea = new JTextArea();
    private JTable table = new JTable();
    
    private JScrollPane panel = new JScrollPane();
    
    DefaultTableModel model = new DefaultTableModel(new String[]{"Reader ID", "CNP", "Last name", "First Name","Telephone", "Email", "Faculty"}, 0);
    
    public SearchReaderFrame()
    {
        //set frame details
        setTitle("Search Reader");
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
        nameR.setBounds(100, 100, 100, 25);
        CNPR.setBounds(100, 200, 100, 25);
        add(exit);
        add(nameR);
        add(CNPR);
        
        nameReader.setBounds(200, 100, 300, 25);
        CNPReader.setBounds(200, 200, 300, 25);
        add(nameReader);
        add(CNPReader);
        
        searchCNP.setBounds(600, 200, 200, 25);
        searchName.setBounds(600, 100, 200, 25);
        add(searchCNP);
        add(searchName);
        
        id.setBounds(10, 275, 140, 25);
        cnp.setBounds(150, 275, 140, 25);
        last.setBounds(290, 275, 140, 25);
        first.setBounds(430, 275, 140, 25);
        tel.setBounds(570, 275, 140, 25);
        email.setBounds(710, 275, 140, 25);
        fac.setBounds(850, 275, 140, 25);
        add(id);
        add(cnp);
        add(last);
        add(first);
        add(tel);
        add(email);
        add(fac);
        

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
        
        searchCNP.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        searchByCNPEvent(actionEvent);
                    } catch (SQLException ex) {
                        Logger.getLogger(SearchBookFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        
        searchName.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        searchByNameEvent(actionEvent);
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
        
        private void searchByCNPEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String CNP = CNPReader.getText();
            String sql_searchCNP = "select * from readers where CNP = ?";
            Connection conCNP = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtCNP = conCNP.prepareStatement(sql_searchCNP);
            stmtCNP.setString(1, CNP);
            stmtCNP.execute();
            ResultSet rez = stmtCNP.executeQuery();
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
    
    private void searchByNameEvent(ActionEvent actionEvent) throws SQLException
    {
        try
        {
            String name = nameReader.getText();
            String sql_searchLastName = "select * from readers where lastName = ?";
            Connection conRN = BibliotecaUniversitara.getConnection();
            PreparedStatement stmtRN = conRN.prepareStatement(sql_searchLastName);
            stmtRN.setString(1, name);
            stmtRN.execute();
            ResultSet rez = stmtRN.executeQuery();
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
