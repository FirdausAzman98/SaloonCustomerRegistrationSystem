/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaloonCustomer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public final class SaloonCustomer {
    
    
 ArrayList<Beauty> beautylist = new ArrayList<Beauty>();
    String header[] = new String[]{"ID","Name", "Phone", "Address" ,"Date"};
    DefaultTableModel dtm = new DefaultTableModel(header, 1);
    
    SaloonCustomer() {
        
        JFrame framelg = new JFrame("Login");
        framelg.setSize(300, 300);
        
         //Username
        JLabel jlUsername = new JLabel("Username");
        jlUsername.setBounds(50, 70, 60, 20);
        framelg.add(jlUsername);
        
        JTextField jtfUsername = new JTextField();
        jtfUsername.setBounds(120, 70, 120, 20);
        framelg.add(jtfUsername);
        
        //Password
        JLabel jlPass = new JLabel("Password");
        jlPass.setBounds(50, 90, 60, 20);
        framelg.add(jlPass);
  
        JTextField jtfPass = new JTextField();
        jtfPass.setBounds(120, 90, 120, 20);
        framelg.add(jtfPass);
        
        JButton jbuttonOk = new JButton("OK");
        jbuttonOk.setBounds(140, 120, 70, 20);
        framelg.add(jbuttonOk);
        
        framelg.setResizable(false);
        framelg.setLocationRelativeTo(null);
        framelg.setLayout(null);
        framelg.setVisible(true);
        framelg.setDefaultCloseOperation(framelg.EXIT_ON_CLOSE);
        
        //############################################################################
        //############################################################################
        
        
        jbuttonOk.addMouseListener(new MouseAdapter() {        
        public void mouseClicked(MouseEvent e) {
           
            String username = jlUsername.getText();
            String password = jlPass.getText();

            if (username.equals("fiqa") && password.equals("12345")) {
                JOptionPane.showMessageDialog(null, "Login successfil");
                jlUsername.setText(null);
                jlPass.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Details");
                jlUsername.setText(null);
                jlPass.setText(null);
            }


        
        JFrame frame = new JFrame("Beauty Saloon Customer Registration");
        frame.setSize(450, 450);
        frame.getContentPane().setBackground( Color.lightGray );
        
        
        
        JLabel jlabel = new JLabel("ID");
        jlabel.setBounds(110, 10, 80, 20);
        frame.add(jlabel);

        JLabel jlabel2= new JLabel("Name");
        jlabel2.setBounds(110, 30, 80, 20);
        frame.add(jlabel2);
        
        JLabel jlabel3= new JLabel("Phone");
        jlabel3.setBounds(110, 50, 80, 20);
        frame.add(jlabel3);
        
        JLabel jlabel4 = new JLabel("Address");
        jlabel4.setBounds(110, 70, 80, 20);
        frame.add(jlabel4);
        
        JLabel jlabel5 = new JLabel("Date");
        jlabel5.setBounds(110, 90, 80, 20);
        frame.add(jlabel5);
        
        JTextField jtfid = new JTextField();
        jtfid.setBounds(190, 10, 150, 20);
        frame.add(jtfid);
        
        JTextField jtfname = new JTextField();
        jtfname.setBounds(190, 30, 150, 20);
        frame.add(jtfname);
          
        JTextField jtfphone = new JTextField();
        jtfphone.setBounds(190, 50, 150, 20);
        frame.add(jtfphone);
        
        JTextField jtfaddress = new JTextField();
        jtfaddress.setBounds(190, 70, 150, 20);
        frame.add(jtfaddress);
        
        JTextField jtfdate = new JTextField();
        jtfdate.setBounds(190, 90, 150, 20);
        frame.add(jtfdate);
        
        
        JButton jbuttoninsert = new JButton("INSERT");
        jbuttoninsert.setBounds(190, 120, 90, 20);
        frame.add(jbuttoninsert);
        jbuttoninsert.setBackground(Color.WHITE);

     

        //table creation
        JTable jtable = new JTable();
        jtable.setBounds(45, 140, 350, 250);
        frame.add(jtable);
        jtable.setModel(dtm);
        JScrollPane scrollPane = new JScrollPane(jtable);
        scrollPane.setBounds(45, 140, 350, 250);
        frame.add(scrollPane);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(80);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(80);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(40);

        
        jtable.setBackground(Color.LIGHT_GRAY);
        
        
        jbuttoninsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String id = jtfid.getText();
                
                if (!isInteger(id)) {
                    JOptionPane.showMessageDialog(frame, "ID should only contain integer!!!");
                    return;
                }
                String name = jtfname.getText().toUpperCase();
                String phone = jtfphone.getText();
                if (!isInteger(name)) {
                    JOptionPane.showMessageDialog(frame, "Phone should only contain integer!!!");
                    return;
                }
                
                String address = jtfaddress.getText();
                String date = jtfdate.getText();
               
                
                Beauty beauty = new Beauty( id,name,phone, address, date);
                beautylist.add(beauty);//create object list array
                writeData();
            }
        }); 
       
        

        readData();
        jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jtable.getSelectedRow();
                
                jtfid.setText(dtm.getValueAt(row, 0).toString());
                jtfname.setText(dtm.getValueAt(row, 1).toString());
                jtfphone.setText(dtm.getValueAt(row, 2).toString());
                jtfdate.setText(dtm.getValueAt(row, 3).toString());
                jtfaddress.setText(dtm.getValueAt(row, 3).toString());
            }
        });

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new SaloonCustomer();

    }

    void readData() { 
        try {
            File file = new File("data.txt"); 
            file.createNewFile();
            FileReader f = new FileReader("data.txt");
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '-') {
                    System.out.println(sb);
                    String beautyarray[] = sb.toString().split(",");
                    Beauty beauty = new Beauty(beautyarray[0], beautyarray[1], beautyarray[2], beautyarray[3], beautyarray[4]);
                   beautylist.add(beauty);
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            dtm.setRowCount(0); 
            for (int i = 0; i < beautylist.size(); i++) {
                Object[] objs = {beautylist.get(i).getid(), beautylist.get(i).getname(), beautylist.get(i).getphone()
                        , beautylist.get(i).getdate(), beautylist.get(i).getaddress()};
                dtm.addRow(objs);
            }
        } catch (IOException e) {
        }
    }

    private void writeData() { 
        try (FileWriter f = new FileWriter("data.txt")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < beautylist.size(); i++) {
                sb.append(beautylist.get(i).getid()+","+beautylist.get(i).getname()+","+beautylist.get(i).getphone()
                        +","+beautylist.get(i).getdate()+","+beautylist.get(i).getaddress()+"-");
            }
            f.write(sb.toString());
            f.close();
        } catch (IOException e) {
            return;
        }
        dtm.setRowCount(0); 
        for (int i = 0; i < beautylist.size(); i++) {
            Object[] objs = {beautylist.get(i).getid(),beautylist.get(i).getname(), beautylist.get(i).getphone()
                    , beautylist.get(i).getdate(), beautylist.get(i).getaddress()};
            dtm.addRow(objs);
        }
    }

    public boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
}

