import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * Created by tmoyer18 on 11/28/17.
 */
public class Calculator {
    public final String[] operatorsArray = {"*", "/", "^", "%", "+", "-", "(", ")"};
    public final ArrayList<String> operatorsList = new ArrayList<>(Arrays.asList(operatorsArray));
    public final Character[] operatorsCharArray = {'*', '/', '^', '%', '+', '-', '(', ')'};
    public final ArrayList<Character> operatorsCharList = new ArrayList<>(Arrays.asList(operatorsCharArray));
    public final int[] priorities = {2, 2, 3, 2, 1, 1, 0, 0, 0};

    public static void main(String[] args) {

    }

    public double doCalc(String[] input) {
        Stack<String> stack = new Stack<String>();
        for (String s : input) {
            if (!operatorsList.contains(s)) {
                stack.push(s);
            } else {
                String r = stack.pop();
                String l = stack.pop();
                double right = Double.parseDouble(r);
                double left = Double.parseDouble(l);

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
                if (token.equals("-") && ( i==0 || !Character.isDigit(previousChar.charAt(0)))) {
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

    public boolean inputIsCorrect(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                try {
                    stack.pop();
                } catch (EmptyStackException ex) {
                    return false;
                }
            }

        }

        boolean parenCorrect = stack.isEmpty();
        boolean spacesCorrect = true;
        char previousChar = 'a';
        char currentChar = 'b';
        for (int i = 0; i < s.length(); i++) {
            previousChar = currentChar;
            currentChar = s.charAt(i);
            if (Character.isDigit(previousChar) || operatorsCharList.contains(previousChar)) {
                if (currentChar != ' ' && !Character.isDigit(currentChar)) {
                    spacesCorrect = false;
                    break;
                }

            } else if (previousChar == ' ') {
                if (Character.isDigit(previousChar) || operatorsCharList.contains(previousChar)) {
                    spacesCorrect = false;
                    break;
                }
            }

        }
        return spacesCorrect && parenCorrect;
    }


}


