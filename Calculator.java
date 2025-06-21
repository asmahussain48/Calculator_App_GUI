import java.awt.*;
import javax.swing.*;
public class Calculator{

        int boarderWidth = 360;
        int boarderHeight = 540;
       
        Color customLightGrey = new Color(212,212, 210);
        Color customDarkGrey = new Color(80,80,80); 
        Color customBlack = new Color(28,28,28);
        Color customOrange = new Color(255,149,0);
        
        JFrame  frame = new JFrame();
        JLabel displayLabel = new JLabel();
        JPanel displayPanel = new JPanel();




        Calculator(){
                frame.setTitle("Calculator");
                frame.setVisible(true);
                frame.setSize(boarderWidth, boarderHeight);
                frame.setLocationRelativeTo(null); // This centers the Window Frame
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout()); // Set to north, south , west, east
                displayLabel.setBackground(customBlack);
                displayLabel.setForeground(Color.white);                
        }
}