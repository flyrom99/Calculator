import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * Created by tmoyer18 on 11/28/17.
 */
public class Calculator {
    public final String[] operatorsArray = {"*", "/", "^", "%", "+", "-", "(", ")"};
    public final ArrayList<String> operatorsList = new ArrayList<>(Arrays.asList(operatorsArray));
    public final int[] priorities = {2, 2, 3, 2, 1, 1, 0, 0, 0};

    public String insertMultiplication(String expression)
    {
        char currentChar = expression.charAt(0);
        for(int i = 1;i<expression.length();i++)
        {
            char previousChar = currentChar;
            currentChar = expression.charAt(i);
            if(currentChar == '(' && Character.isLetterOrDigit(previousChar) || (currentChar == '(' && previousChar == ')')
                    || (previousChar == ')' && Character.isLetterOrDigit(currentChar)) ||
                    (Character.isDigit(previousChar) && Character.isLetter(currentChar)))
            {
                expression = expression.substring(0,i) + " * " + expression.substring(i,expression.length());
            }
        }
        return expression;
    }
    public double doCalc(String[] input) {
        /**
         * @param input array of separated terms of equation in postFix format e.g. ('3','4','+')
         */
        Stack<String> stack = new Stack<String>();
        for (String s : input) {
            if (!operatorsList.contains(s)) {
                stack.push(s);
            } else {
                String r = stack.pop();
                String l = stack.pop();
                double right;
                double left;
                if(l.equals("e"))
                    left = Math.E;
                else
                    left = Double.parseDouble(l);
                if(r.equals("e"))
                    right = Math.E;
                else
                    right = Double.parseDouble(r);
                if (s.equals("+")) {
                    stack.push("" + (left + right));
                } else if (s.equals("-")) {
                    stack.push("" + (left - right));
                } else if (s.equals("*")) {
                    stack.push("" + (left * right));
                } else if (s.equals("/")) {
                    stack.push("" + (left / right));
                } else if (s.equals("%")) {
                    stack.push("" + (left % right));
                } else if (s.equals("^")) {
                    stack.push("" + (Math.pow(left, right)));
                }

            }
        }
        return Double.parseDouble(stack.peek());
    }
    public double doVariableCalc(String[] input, double x)
    {
        /**
         * @param input array of separated terms of equation in postFix format e.g. ('3','4','+')
         * @param x double that represents the single variable used throughout the equation
         */
        for(int i = 0;i<input.length;i++)
        {
            if(input[i].charAt(0) == 'e')
            {
                input[i] = "" + Math.E;
            }
            else if(input[i].length() == 1 && Character.isAlphabetic(input[i].charAt(0)))
            {
                input[i] = "" + x;
            }
        }
        return doCalc(input);
    }

    public String[] infixToPostFix(String infix) {
        Stack<String> operators = new Stack<>();
        ArrayList<String> outputs = new ArrayList<>();
        String[] infixArr = infix.split(" ");
        ArrayList<String> infixList = new ArrayList<>(Arrays.asList(infixArr));
        for (int i = 0; i < infixList.size(); i++) {
            String g = infixList.get(i);
            if (g.isEmpty())
                infixList.remove(i);
        }
        infixArr = new String[infixList.size()];
        for (int i = 0; i < infixList.size(); i++) {
            infixArr[i] = infixList.get(i);
        }
        String previousChar = "";
        for (int i = 0; i < infixArr.length; i++) {
            String token = "" + infixArr[i];
            boolean madeItANumber = false;
            if (token.isEmpty())
                continue;
            if (!operatorsList.contains(token)) {
                outputs.add(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    String popped = operators.pop();
                    outputs.add(popped);
                }
                operators.pop(); //this pops (

            } else if (operatorsList.contains(token)) {
                if (token.equals("-") && ( i==0 || !Character.isLetterOrDigit(previousChar.charAt(0)) )) {
                    i++;
                    outputs.add("-" + infixArr[i]);
                    madeItANumber = true;
                }
                while (!operators.isEmpty() && (priorities[operatorsList.indexOf(token)] <= priorities[operatorsList.indexOf(operators.peek())])) {
                    try {
                        String popped = operators.pop();
                        outputs.add(popped);
                    } catch (EmptyStackException ex) {
                        break;
                    }

                }
                if(!madeItANumber)
                    operators.push(token);
            }
            if (madeItANumber) {
                previousChar = infixArr[i];
            }
            else {

                previousChar = token;
            }
        }

        while (!operators.isEmpty()) {
            String popped = operators.pop();
            outputs.add(popped);
        }

        String[] resultArr = new String[outputs.size()];
        for (int i = 0; i < outputs.size(); i++) {
            resultArr[i] = outputs.get(i);
        }
        return resultArr;
    }
    public Point[] calcForXValues(double lowerBound, double upperBound,String[] input,double increment)
    {
        ArrayList<Point> pointList = new ArrayList<>();
        for(double x = lowerBound;x<upperBound;x+=increment)
        {
            String[] copied = Arrays.copyOf(input,input.length);
            double result = doVariableCalc(copied,x);
            pointList.add(new Point(x,result));
        }
        return pointList.toArray(new Point[pointList.size()]);
    }
}


