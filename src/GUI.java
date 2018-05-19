import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by tmoyer18 on 11/28/17.
 */
public class GUI extends KeyAdapter {
    private JPanel mainPanel = new JPanel(new GridLayout(6,5));
    private JFrame frame = new JFrame("Calculator");
    JTextArea output = new JTextArea();
    public static String expression = "";
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        GUI gui = new GUI();

    }
    public GUI()
    {
        frame.setBounds(10,10,600,400);
        JTextArea blank1 = new JTextArea();
        JTextArea blank2 = new JTextArea();
        JTextArea blank3 = new JTextArea();
        JTextArea blank4 = new JTextArea();
        JTextArea blank5 = new JTextArea();
        JTextArea blank6 = new JTextArea();
        JTextArea blank7 = new JTextArea();
        JTextArea blank8 = new JTextArea();
        JTextArea blank9 = new JTextArea();
        JTextArea blank10 = new JTextArea();
        blank1.setEditable(false);
        blank2.setEditable(false);
        blank3.setEditable(false);
        blank4.setEditable(false);
        blank5.setEditable(false);
        blank6.setEditable(false);
        blank7.setEditable(false);
        blank8.setEditable(false);
        blank9.setEditable(false);
        blank10.setEditable(false);
        JButton add = new JButton("+");
        JButton subtract = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");
        JButton mod = new JButton("%");
        JButton exp = new JButton("^");
        JButton CE = new JButton("CE");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton zero = new JButton("0");
        JButton decimal = new JButton(".");
        JButton open = new JButton("(");
        JButton close = new JButton(")");
        JButton equals = new JButton("=");

        mod.setFocusable(false);
        add.setFocusable(false);
        subtract.setFocusable(false);
        multiply.setFocusable(false);
        divide.setFocusable(false);
        exp.setFocusable(false);
        CE.setFocusable(false);
        one.setFocusable(false);
        two.setFocusable(false);
        three.setFocusable(false);
        four.setFocusable(false);
        five.setFocusable(false);
        six.setFocusable(false);
        seven.setFocusable(false);
        eight.setFocusable(false);
        nine.setFocusable(false);
        zero.setFocusable(false);
        open.setFocusable(false);
        close.setFocusable(false);
        equals.setFocusable(false);
        blank1.setFocusable(false);
        blank2.setFocusable(false);
        blank3.setFocusable(false);
        blank4.setFocusable(false);
        blank5.setFocusable(false);
        blank6.setFocusable(false);
        blank7.setFocusable(false);
        blank8.setFocusable(false);
        blank9.setFocusable(false);
        blank10.setFocusable(false);
        output.setText(expression);
        output.setEditable(false);
        output.setLineWrap(true);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + " + ";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        decimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression+ ".";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + " - ";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + " * ";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + " / ";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        mod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + " % ";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        CE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = "";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(expression.length()>0)
                {
                    System.out.println("Calculating for: " + expression);

                    Calculator calc = new Calculator();
                    String[] postFix = calc.infixToPostFix(expression);
                    double answer = calc.doCalc(postFix);
                    System.out.println("Postfix: " + Arrays.toString(postFix));
                    output.setText("" + answer);
                    expression = "" + answer;
                    mainPanel.setFocusable(true);
                }
            }
        });
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "1";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "2";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "3";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "4";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "5";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "6";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "7";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "8";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }

        });
        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "9";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "0";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + "( ";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + " )";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = expression + " ^ ";
                output.setText(expression);
                mainPanel.setFocusable(true);
            }
        });

        mainPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String ch = "" + e.getKeyChar();
                if(ch.equals("0"))
                {
                    expression = expression + "0";
                    output.setText(expression);
                }
                else if(e.getKeyCode() == 8)
                {
                    if(expression.length()>0) {
                        expression = expression.substring(0, expression.length() - 1);
                        output.setText(expression);
                    }
                }
                else if(e.getKeyChar() == 10)
                {
                    if(expression.length()>0) {
                        Calculator calc = new Calculator();
                        String[] postFix = calc.infixToPostFix(expression);
                        double answer = calc.doCalc(postFix);
                        System.out.println("Postfix: " + Arrays.toString(postFix));
                        output.setText("" + answer);
                        expression = "" + answer;
                        mainPanel.setFocusable(true);
                    }
                }
                else if(ch.equals("."))
                {
                    expression = expression + ".";
                    output.setText(expression);
                }
                else if(ch.equals("1"))
                {
                    expression = expression + "1";
                    output.setText(expression);
                }
                else if(ch.equals("2"))
                {
                    expression = expression + "2";
                    output.setText(expression);
                }
                else if(ch.equals("3"))
                {
                    expression = expression + "3";
                    output.setText(expression);
                }
                else if(ch.equals("4"))
                {
                    expression = expression + "4";
                    output.setText(expression);
                }
                else if(ch.equals("5"))
                {
                    expression = expression + "5";
                    output.setText(expression);
                }
                else if(ch.equals("6"))
                {
                    expression = expression + "6";
                    output.setText(expression);
                }
                else if(ch.equals("7"))
                {
                    expression = expression + "7";
                    output.setText(expression);
                }
                else if(ch.equals("8"))
                {
                    expression = expression + "8";
                    output.setText(expression);
                }
                else if(ch.equals("9"))
                {
                    expression = expression + "9";
                    output.setText(expression);
                }
                else if(ch.equals("+"))
                {
                    expression = expression + " + ";
                    output.setText(expression);
                }
                else if(ch.equals("-"))
                {
                    expression = expression + " - ";
                    output.setText(expression);
                }
                else if(ch.equals("*"))
                {
                    expression = expression + " * ";
                    output.setText(expression);
                }
                else if(ch.equals("/"))
                {
                    expression = expression + " / ";
                    output.setText(expression);
                }
                else if(ch.equals("^"))
                {
                    expression = expression + " ^ ";
                    output.setText(expression);
                }
                else if(ch.equals("%"))
                {
                    expression = expression + " % ";
                    output.setText(expression);
                }
                else if(ch.equals("("))
                {
                    expression = expression + "( ";
                    output.setText(expression);
                }
                else if(ch.equals(")"))
                {
                    expression = expression + " )";
                    output.setText(expression);
                }



            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        mainPanel.add(blank1);
        mainPanel.add(blank2);
        mainPanel.add(output);
        mainPanel.add(blank3);
        mainPanel.add(CE);
        mainPanel.add(mod);
        mainPanel.add(seven);
        mainPanel.add(eight);
        mainPanel.add(nine);
        mainPanel.add(divide);
        mainPanel.add(open);
        mainPanel.add(four);
        mainPanel.add(five);
        mainPanel.add(six);
        mainPanel.add(multiply);
        mainPanel.add(close);
        mainPanel.add(one);
        mainPanel.add(two);
        mainPanel.add(three);
        mainPanel.add(subtract);
        mainPanel.add(exp);
        mainPanel.add(zero);
        mainPanel.add(decimal);
        mainPanel.add(equals);
        mainPanel.add(add);
        mainPanel.setFocusable(true);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }



}
