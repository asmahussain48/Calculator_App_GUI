import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.*;
public class Calculator{

        int boarderWidth = 360;
        int boarderHeight = 540;

        String[] buttonValues = {       
                "AC", "+/-", "%", "/",
                "7", "8", "9", "x",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".","√", "="
        };
        String[] rightSymbols = {"/", "x", "-", "+", "="};
        String[] topSymbols = {"AC", "+/-", "%"};
        
        JFrame  frame = new JFrame();
        JLabel displayLabel = new JLabel();
        JPanel displayPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();




        Calculator(){
                frame.setTitle("Calculator");
                frame.setVisible(true);
                frame.setSize(boarderWidth, boarderHeight);
                frame.setLocationRelativeTo(null); // This centers the Window Frame
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout()); // Set to north, south , west, east

                displayLabel.setBackground(Color.BLACK);
                displayLabel.setForeground(Color.WHITE);  
                displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
                displayLabel.setHorizontalAlignment(JLabel.RIGHT);
                displayLabel.setText("0"); // defalut text 
                displayLabel.setOpaque(true);

                displayPanel.setLayout(new BorderLayout());
                displayPanel.add(displayLabel);
                frame.add(displayPanel, BorderLayout.NORTH);

                buttonsPanel.setLayout(new GridLayout(5, 4)); // 5 rows and 4 columns
                buttonsPanel.setBackground(Color.BLACK);
                // Add a border to the buttons panel
                // Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
                // buttonsPanel.setBorder(border);
                frame.add(buttonsPanel);
                
                for(int i = 0; i<buttonValues.length; i++){
                        JButton button = new JButton();
                        String buttonValue = buttonValues[i];
                        button.setFont(new Font("Arial", Font.PLAIN, 30));
                        button.setText(buttonValue);
                        button.setFocusable(false);// to remove the recatngle our text
                        if(Arrays.asList(topSymbols).contains(buttonValue)){
                                button.setBackground(Color.lightGray);
                                button.setForeground(Color.BLACK);

                        } else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                                button.setBackground(new Color(255,149,0));
                                button.setForeground(Color.WHITE);
                        } else {
                                button.setBackground(Color.DARK_GRAY);
                                button.setForeground(Color.WHITE);
                        }

                        buttonsPanel.add(button);

                }


        }


          public static void main(String[] args) {
        // Obje ct to call the calculator
                Calculator calculator = new Calculator();
        }
}