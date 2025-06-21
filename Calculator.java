import java.awt.*;
import javax.swing.*;
public class Calculator{

        int boarderWidth = 360;
        int boarderHeight = 540;
        JFrame  frame = new JFrame();
        Calculator(){
                frame.setTitle("Calculator");
                frame.setVisible(true);
                frame.setSize(boarderWidth, boarderHeight);
                frame.setLocationRelativeTo(null); // This centers the Window Frame
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout()); // Set to north, south , west, east
                 
        }
}