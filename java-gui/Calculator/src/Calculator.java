import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class Calculator {
    JFrame jFrame;
    JTextField jTextField;
    double firstNum, secondNum, result;
    String operator;

    public Calculator() {
        jFrame = new JFrame("Calculator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 600);
        jFrame.setLayout(null);
        jFrame.setResizable(false);

        Font textFieldFont = new Font("Serif", Font.BOLD, 40);
        jTextField = new JTextField();
        jTextField.setBounds(40, 40, 350, 60);
        jTextField.setFont(textFieldFont);
        jTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField.setEditable(false);
        LineBorder border = new LineBorder(Color.BLACK);
        jTextField.setBorder(border);
        jFrame.add(jTextField);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        int x = 40, y = 120;
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBounds(x, y, 80, 80);
            button.setFont(new Font("Serif", Font.BOLD, 30));
            button.addActionListener(new ButtonClickListener());
            jFrame.add(button);
            x += 90;
            if ((i + 1) % 4 == 0) {
                x = 40;
                y += 90;
            }
        }

        JButton clearButton = new JButton("C");
        clearButton.setBounds(310, 480, 80, 60);
        clearButton.setFont(new Font("Serif", Font.BOLD, 30));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
                firstNum = 0;
                secondNum = 0;
                result = 0;
                operator = "";
            }
        });
        jFrame.add(clearButton);

        jFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            try {
                if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
                    jTextField.setText(jTextField.getText() + command);
                } else if (command.charAt(0) == '=') {
                    secondNum = Double.parseDouble(jTextField.getText());
                    switch (operator) {
                        case "+":
                            result = firstNum + secondNum;
                            break;
                        case "-":
                            result = firstNum - secondNum;
                            break;
                        case "*":
                            result = firstNum * secondNum;
                            break;
                        case "/":
                            result = firstNum / secondNum;
                            break;
                    }
                    jTextField.setText(String.valueOf(result));
                    firstNum = result;
                } else {
                    if (!jTextField.getText().isEmpty()) {
                        firstNum = Double.parseDouble(jTextField.getText());
                        operator = command;
                        jTextField.setText("");
                    }
                }
            } catch (NumberFormatException ex) {
                jTextField.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

