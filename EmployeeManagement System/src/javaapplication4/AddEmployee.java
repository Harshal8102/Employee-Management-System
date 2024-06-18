
package javaapplication4;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tffname,tfsalary,tfadd,tfphone,tfemail,tfdesignation,tfadhar;
    JLabel lblempid;
    JDateChooser dcdob;
    JComboBox tfedu;
    JButton add,back;
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        //name
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        //father name
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        //dob
        JLabel labeldob = new JLabel("Date of birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        //salary
        JLabel labelsalary = new JLabel("Employee salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        //Address
        JLabel labeladdress = new JLabel("Employee address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdress);
        
        tfadd = new JTextField();
        tfadd.setBounds(200,250,150,30);
        add(tfadd);
        
        //phone
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        
        //email
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //highest education
        JLabel labeleducation = new JLabel("Highest education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeleducation);
        
        String[] courses = {"BE","BTech","BSC","MSC","MCA","BCS","MCS","BCOM","BA","BCA","MA","MBA","MTech","PHD"};
        tfedu = new JComboBox(courses);
        tfedu.setBackground(Color.WHITE);
        tfedu.setBounds(600,300,150,30);
        add(tfedu);
        
        
        //Designation
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        //Addhar no.
        JLabel labelaadhar = new JLabel("Aadhar no.");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelaadhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(600,350,150,30);
        add(tfadhar);
        
        //emp id
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelempId);
        
        lblempid = new JLabel("" + number);
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(lblempid);
        
        
        add = new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfadd.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfedu.getSelectedItem().toString();
            String designation = tfdesignation.getText();
            String aadhar = tfadhar.getText();
            String empid = lblempid.getText();
            
            try{
                Conn con = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully..!");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String[] args){
         new AddEmployee();
    }
}
