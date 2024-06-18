
package javaapplication4;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        
        getContentPane().setBackground(Color.WHITE); //Color class in awt pack
        setLayout(null);   //to dont use layout of swing, instead use own
        
        JLabel head = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        head.setBounds(80,30,1200,60); //(dist from left,dist from top,width of label,height of label)
        head.setFont(new Font("Raleway",Font.BOLD,60));
        head.setForeground(Color.red);
        add(head);  //to add components on the frame
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        
        JButton clickHere = new JButton("Click here to continue");
        clickHere.setBounds(400,400,300,70);
        clickHere.setBackground(Color.BLACK);
        clickHere.setForeground(Color.WHITE);
        clickHere.addActionListener(this); //this function tells when click on button that clickevent called
        image.add(clickHere);
        
        setSize(1170,750); //arg1 = length of frame, arg2 = width
        setLocation(200,50); //arg1 = distance from left, arg2 = dist from top
        setVisible(true);
        
//        while(true){
//            
//            head.setVisible(false);
//            
//            try{
//                Thread.sleep(500);
//            }catch(Exception e){
//                
//            }
//            head.setVisible(true);
//        }
    }
    
    public void actionPerformed(ActionEvent ae){    //function to perform action after clickevent
        
        setVisible(false);    //to close current frame      
        
        new Login();         //to open login frame
    }
    
    public static void main(String[] args){
        
        new Splash();
    }
}
