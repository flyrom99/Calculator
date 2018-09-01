import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by tmoyer18 on 11/28/17.
 */
public class GUI extends KeyAdapter {
    private JPanel mainPanel = new JPanel(new GridLayout(6,5));
    private boolean inGraphingMode = false;
    private Point[] points;
    private Calculator calc = new Calculator();
    private JPanel graphingPanel = new JPanel(){
        @Override
        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;
            g.setColor(Color.white);
            g2.fillRect(0,0,graphingPanel.getWidth(),graphingPanel.getHeight());
            g.setColor(Color.black);
            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);
            g2.drawLine(0,graphingPanel.getHeight()/2,graphingPanel.getWidth(),graphingPanel.getHeight()/2);
            g2.drawLine(graphingPanel.getWidth()/2,0,graphingPanel.getWidth()/2,graphingPanel.getHeight());
            if(points!=null) {
                for (int i = 0; i < points.length - 1; i++) {
                    Point p1 = pointToPixelCoord(points[i]);
                    Point p2 = pointToPixelCoord(points[i+1]);
                    g2.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
                }
            }
        }
    };
    private JFrame frame = new JFrame("Calculator");
    JTextArea output = new JTextArea();
    public static String expression = "";
    boolean variablesEnabled = false;
    ArrayList<JComponent> components = new ArrayList<>();
    int xScale = 25; //how many pixels per 1.0 on the x axis
    int yScale = 25; //how many pixels per 1.0 on the y axis
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        GUI gui = new GUI();

    }
    public void toggleVariables()
    {
        if(variablesEnabled)
            variablesEnabled = false;
        else
            variablesEnabled = true;
    }
    public void disableFocusable(ArrayList<JComponent> components)
    {
        for(JComponent comp: components)
        {
            comp.setFocusable(false);
        }
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
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem graphingMode = new JMenuItem("toggle graphing mode");
        JMenuItem toggleVariables = new JMenuItem("Toggle variables");
        fileMenu.add(graphingMode);
        fileMenu.add(toggleVariables);
        bar.add(fileMenu);
        mod.setFocusable(false);
        components.add(mod);
        add.setFocusable(false);
        components.add(add);
        subtract.setFocusable(false);
        components.add(subtract);
        multiply.setFocusable(false);
        components.add(multiply);
        divide.setFocusable(false);
        components.add(divide);
        exp.setFocusable(false);
        components.add(exp);
        CE.setFocusable(false);
        components.add(CE);
        one.setFocusable(false);
        components.add(one);
        two.setFocusable(false);
        components.add(two);
        three.setFocusable(false);
        components.add(three);
        four.setFocusable(false);
        components.add(four);
        five.setFocusable(false);
        components.add(five);
        six.setFocusable(false);
        components.add(six);
        seven.setFocusable(false);
        components.add(seven);
        eight.setFocusable(false);
        components.add(eight);
        nine.setFocusable(false);
        components.add(nine);
        zero.setFocusable(false);
        components.add(zero);
        open.setFocusable(false);
        components.add(open);
        close.setFocusable(false);
        components.add(close);
        equals.setFocusable(false);
        components.add(equals);
        blank1.setFocusable(false);
        components.add(blank1);
        blank2.setFocusable(false);
        components.add(blank1);
        blank3.setFocusable(false);
        components.add(blank2);
        components.add(blank3);
        blank4.setFocusable(false);
        components.add(blank4);
        blank5.setFocusable(false);
        components.add(blank5);
        blank6.setFocusable(false);
        components.add(blank6);
        blank7.setFocusable(false);
        components.add(blank7);
        blank8.setFocusable(false);
        components.add(blank8);
        blank9.setFocusable(false);
        components.add(blank9);
        blank10.setFocusable(false);
        components.add(blank10);
        output.setText(expression);
        output.setEditable(false);
        output.setLineWrap(true);
        toggleVariables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleVariables();
            }
        });
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
                    if(variablesEnabled)
                    {
                        togglePanel(graphingPanel, mainPanel);
                        inGraphingMode = true;
                        variablesEnabled = true;
                    }
                    else {
                        expression = calc.insertMultiplication(expression);
                        String[] postFix = calc.infixToPostFix(expression);
                        double answer = calc.doCalc(postFix);
                        output.setText("" + answer);
                        expression = "" + answer;
                        mainPanel.setFocusable(true);
                    }
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
        graphingMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!inGraphingMode) {
                    togglePanel(graphingPanel, mainPanel);
                    inGraphingMode = true;
                    variablesEnabled = true;
                }
                else
                {
                    togglePanel(mainPanel,graphingPanel);
                    inGraphingMode = false;
                }

            }
        });
        graphingPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 71)
                {
                    if(!inGraphingMode) {
                        if(expression.length()>0) {
                            togglePanel(graphingPanel, mainPanel);
                            inGraphingMode = true;
                            variablesEnabled = true;
                        }
                    }
                    else
                    {
                        togglePanel(mainPanel,graphingPanel);
                        inGraphingMode = false;
                    }
                }
                else if(e.getKeyCode() == 75)
                {
                    System.out.println("went here");
                    xScale*=2;
                    yScale*=2;
                    graphingPanel.removeAll();
                    graphingPanel.repaint();

                }
                else if(e.getKeyCode() == 74)
                {
                    System.out.println("went here");
                    xScale/=2;
                    yScale/=2;

                    graphingPanel.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

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
                else if(e.getKeyCode() == 86)
                {
                    toggleVariables();
                }
                else if (e.getKeyCode() == 71)
                {
                    if(!inGraphingMode) {
                        togglePanel(graphingPanel, mainPanel);
                        inGraphingMode = true;
                        variablesEnabled = true;
                    }
                    else
                    {
                        togglePanel(mainPanel,graphingPanel);
                        inGraphingMode = false;
                    }
                }
                else if(e.getKeyChar() == 10)
                {
                    if(expression.length()>0) {
                        if(variablesEnabled)
                        {
                            togglePanel(graphingPanel, mainPanel);
                            inGraphingMode = true;
                            variablesEnabled = true;
                        }
                        else {
                            expression = calc.insertMultiplication(expression);
                            String[] postFix = calc.infixToPostFix(expression);
                            double answer = calc.doCalc(postFix);
                            output.setText("" + answer);
                            expression = "" + answer;
                            mainPanel.setFocusable(true);
                        }
                    }
                }
                else if(e.getKeyCode() == 187)
                {
                    System.out.println("went here");
                    xScale*=2;
                    yScale*=2;
                    graphingPanel.repaint();
                }
                else if(e.getKeyCode() == 189)
                {
                    System.out.println("went here");
                    xScale/=2;
                    yScale/=2;
                    graphingPanel.repaint();
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
                else
                {
                    if(variablesEnabled)
                    {
                        if(Character.isAlphabetic(ch.charAt(0))) {
                            expression+= ch;
                            output.setText(expression);
                        }
                    }
                    else
                    {
                        if(ch.equals("e"))
                        {
                            expression+="e";
                            output.setText(expression);
                        }
                    }
                }
                mainPanel.setFocusable(true);
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
        frame.setJMenuBar(bar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void togglePanel(JPanel newPanel,JPanel currentPanel)
    {
        frame.remove(currentPanel);
        frame.add(newPanel);
        frame.revalidate();
        expression = calc.insertMultiplication(expression);
        if(variablesEnabled && expression.length()>0)
            points =calc.calcForXValues(((graphingPanel.getWidth())*-1)/xScale,(graphingPanel.getWidth())/xScale,calc.infixToPostFix(expression),.01);
        frame.repaint();
        newPanel.requestFocusInWindow();
        disableFocusable(components);
    }
    public Point pointToPixelCoord(Point p)
    {
       Point center = new Point(graphingPanel.getWidth()/2,graphingPanel.getHeight()/2);
       center.x+=(p.getX()*xScale);
       if(p.getY()<0)
           center.y+=(Math.abs(p.getY()*yScale));
       else
           center.y-=(Math.abs(p.getY()*yScale));
       return center;
    }



}
