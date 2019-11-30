package bibliotecauniversitara;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteBookFrame extends JFrame{
    private JButton exit = new JButton("Exit");
    private JButton delete = new JButton("Delete");
    
     private JLabel ID = new JLabel("ID Book: ");
     private JTextField Id = new JTextField();
     
       public DeleteBookFrame()
        {
            setTitle("Delete Book");
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
             delete.setBounds(100, 500, 150, 25);
                     
             add(exit);
             add(delete);
             
             ID.setBounds(100, 50, 150, 25);
        
             add(ID);
             
             Id.setBounds(300, 50, 150, 25);
        
             add(Id);
         
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
      
        
//        updateD.addActionListener(new ActionListener() 
//        {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//               // updateDomainEvent(actionEvent);
//               
//            }
//        });
       }

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
//            ResultSet rs = stmDomain.executeUpdate(sql_updateD);
//            
//            
//            
//        }
}
