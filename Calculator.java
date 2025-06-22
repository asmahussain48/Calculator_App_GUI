import java.awt.*;
import java.awt.event.ActionEvent;
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
        /*
         * B = null means "waiting for user input for the second number".
           When the user starts typing, you update B to the entered value.
           If we  set B = "0" from the start, you can't distinguish between 
           "no value entered yet" and "user entered zero"
         */
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
        JLabel expressionLabel = new JLabel();
        JPanel displayPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        Calculator(){
                
        frame.setTitle("Calculator");
        ImageIcon icon = new ImageIcon("calculator.png"); // or use path like "resources/icon.png"
        frame.setIconImage(icon.getImage());

        // frame.setVisible(true); // make it in end for any issue 
        frame.setSize(boarderWidth, boarderHeight);
        frame.setLocationRelativeTo(null); // This centers the Window Frame
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Set to north, south , west, east
        frame.getContentPane().setBackground(Color.BLACK);
        expressionLabel.setBackground(Color.BLACK);
        expressionLabel.setForeground(Color.LIGHT_GRAY);
        expressionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        expressionLabel.setHorizontalAlignment(JLabel.RIGHT);
        expressionLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        expressionLabel.setOpaque(true);

        displayLabel.setBackground(Color.BLACK);
        displayLabel.setForeground(Color.WHITE);  
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0"); // defalut text 
        displayLabel.setOpaque(true);
        displayLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));

        displayPanel.setLayout(new GridLayout(2,1 )); // it will make 2 
        displayPanel.add(expressionLabel);
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5, 4,5,5)); // 5 rows and 4 columns
        buttonsPanel.setBackground(Color.BLACK);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // outer padding
        buttonsPanel.setLayout(new GridLayout(5, 4, 5, 5)); // 5px gaps

        // Add a border to the buttons panel
        // Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        // buttonsPanel.setBorder(border);
        frame.add(buttonsPanel);
        
        for(int i = 0; i<buttonValues.length; i++){
                JButton button = new JButton();
                String buttonValue = buttonValues[i];
                // if wants to make buttons to round then uncomment below line
                // RoundButton button = new RoundButton(buttonValue);
                button.setFont(new Font("Arial", Font.PLAIN, 30));
                button.setText(buttonValue);
                button.setFocusable(false);// to remove the recatngle our text
                // button.setBorder(new LineBorder(Color.black,1));
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
                if(Arrays.asList(rightSymbols).contains(buttonValue)){

                        if (buttonValue == "="){
                                if(A != null){
                                B = displayLabel.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);
                                
                                if (Operator == "+"){
                        
                                        displayLabel.setText(removeZeroDecimal(numA + numB)); // getting String Value
                                }
                                else if (Operator == "-"){
                                        displayLabel.setText(removeZeroDecimal(numA - numB)); // getting String Value
                                }
                                else if (Operator == "x"){
                                        displayLabel.setText(removeZeroDecimal(numA * numB)); // getting String Value
                                }
                                else if (Operator == "/"){
                                        displayLabel.setText(removeZeroDecimal(numA / numB)); // getting String Value
                                
                                }   
                                expressionLabel.setText(A + " " + Operator + " " + B + " = ");
                        }
        
                        }
                        else if ("+-x/".contains(buttonValue)){
                                if(Operator == null){
                                        A = displayLabel.getText(); // setting A to the any value that has written in displayLabel
                                        displayLabel.setText("0");
                                        B = "0";
                                }
                                // if user type button twise etc
                                Operator = buttonValue;
                                expressionLabel.setText(A + " " + Operator);

                        }



                        } 
                        else if (Arrays.asList(topSymbols).contains(buttonValue)){
                        //conditions for top Symbols 
                        if(buttonValue == "AC"){
                                // function to clear A, Operator, B
                                clearAll();
                        }
                        else if(buttonValue == "+/-"){
                                double numDisplay = Double.parseDouble(displayLabel.getText());
                                numDisplay = numDisplay*(-1);
                                //removeZeroDecimal is not built in method
                                        displayLabel.setText(removeZeroDecimal(numDisplay)); 
                                

                        }
                        else if(buttonValue == "%"){
                                        double numDisplay = Double.parseDouble(displayLabel.getText());
                                numDisplay = numDisplay/(100);
                                //removeZeroDecimal is not built in method
                                        displayLabel.setText(removeZeroDecimal(numDisplay)); 
                        }
                } else {
                                if(buttonValue == "."){
                                // if a number doesn't have decimal . then we can add one . but if it has it can not have . anothe
                                // =2.45 is okay but 2.45. is not this below code is for handling this
                                if(!displayLabel.getText().contains(buttonValue)){
                                        displayLabel.setText(displayLabel.getText() + buttonValue);

                                        }
                                }

                                else if (buttonValue == "√") {
                                        double num = Double.parseDouble(displayLabel.getText());

                                        if (num < 0) {
                                                displayLabel.setText("Error"); // Square root of negative number is not real
                                                expressionLabel.setText("√(" + displayLabel.getText() + ")");
                                        } else {
                                                double result = Math.sqrt(num);
                                                displayLabel.setText(removeZeroDecimal(result));
                                                expressionLabel.setText("√(" + removeZeroDecimal(num) + ") = ");
                                        }

                                        A = removeZeroDecimal(num);
                                        Operator = "√";
                                        B = null;
                                        }


                                else if("0123456789".contains(buttonValue)){
                                // 05 = 5
                                if(displayLabel.getText() == "0"){
                                        displayLabel.setText(buttonValue);
                                }
                                else{
                                        displayLabel.setText(displayLabel.getText() + buttonValue);

                                }

                                if (Operator != null) {
                                        expressionLabel.setText(A + " " + Operator + " " + displayLabel.getText());
                                }

                                }
                }
        }
                });


        }
        frame.setUndecorated(false); // keep OS window bar, or true if you want custom
        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true);
        }

        void clearAll(){
                A = "0";
                Operator = null;
                B = null;
                  expressionLabel.setText(""); // will clear the expression Label too
                  displayLabel.setText("0");
        }

        String removeZeroDecimal(double numDisplay){
                if(numDisplay % 1 == 0){
                        //whole number
                        return Integer.toString((int) numDisplay);
                }
                        return Double.toString(numDisplay);
                
                
        }



          public static void main(String[] args) {
        // Obje ct to call the calculator
                Calculator calculator = new Calculator();
        }
}