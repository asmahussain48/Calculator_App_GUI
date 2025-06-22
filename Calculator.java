import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.LineBorder;
public class Calculator{

        int boarderWidth = 360;
        int boarderHeight = 540;
        // for tracking the Two numbers and Operators 
        // A+B, A-B, A*B, A/B simple Calculator will update it later
        String A = "0";
        String Operator = null;
        String B = null;
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
                        button.setBorder(new LineBorder(Color.black,1));
                        // Prevents the button from showing a focus border when selected or clicked
                        button.setFocusPainted(false); 
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
                        button.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                        JButton button = (JButton) e.getSource();
                                        String buttonValue = button.getText();
                                        if(Arrays.asList(rightSymbols).contains(buttonValues)){

                                        } else if(Arrays.asList(topSymbols).contains(buttonValues)){
                                                //conditions for top Symbols 
                                                if(buttonValue == "AC"){

                                                }
                                                else if(buttonValue == "+/-"){

                                                }
                                                else if(buttonValue == "%"){

                                                }
                                        } else {
                                                 if(buttonValue == "."){
                                                        // if a number doesn't have decimal . then we can add one . but if it has it can not have . anothe
                                                        // =2.45 is okay but 2.45. is not this below code is for handling this
                                                        if(!displayLabel.getText().contains(buttonValue)){
                                                                displayLabel.setText(displayLabel.getText() + buttonValue);
                                                                
                                                        }
                                                 }
                                                 else if("0123456789".contains(buttonValue)){
                                                        // 05 = 5
                                                        if(displayLabel.getText() == "0"){
                                                                displayLabel.setText(buttonValue);
                                                        }
                                                        else{
                                                                displayLabel.setText(displayLabel.getText() + buttonValue);

                                                        }
                                                 }
                                        }
                                }
                        });


                }


        }


          public static void main(String[] args) {
        // Obje ct to call the calculator
                Calculator calculator = new Calculator();
        }
}