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

public class DeleteReaderFrame extends JFrame{
    private JButton exit = new JButton("Exit");
    private JButton deleteR = new JButton("Delete");
    
     private JLabel IDR = new JLabel("ID Reader: ");
     private JTextField IdR = new JTextField();
     
       public DeleteReaderFrame()
        {
            setTitle("Delete Reader");
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
             deleteR.setBounds(100, 500, 150, 25);
                     
             add(exit);
             add(deleteR);
             
             IDR.setBounds(100, 50, 150, 25);
        
             add(IDR);
             
             IdR.setBounds(300, 50, 150, 25);
        
             add(IdR);
         
         }
        
        private void initEvent()
        {
             this.addWindowListener(new WindowAdapter(){
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
