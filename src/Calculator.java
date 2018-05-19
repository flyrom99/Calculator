import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * Created by tmoyer18 on 11/28/17.
 */
public class Calculator {
    public static final String[] operatorsArray = {"*","/","^","%","+","-","(",")"};
    public static final ArrayList<String> operatorsList = new ArrayList<>(Arrays.asList(operatorsArray));
    public static final Character[] operatorsCharArray = {'*','/','^','%','+','-','(',')'};
    public static final ArrayList<Character> operatorsCharList = new ArrayList<>(Arrays.asList(operatorsCharArray));
    public static final int[] priorities = {2,2,3,2,1,1,0,0,0};
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String expression = "";
        Calculator calculator = new Calculator();
        do {

            System.out.println("Enter expression");
            expression = keyboard.nextLine();

        }
        while(!inputIsCorrect(expression));
        {

        }
        String[] postfix = infixToPostFix(expression);
        System.out.println("infix: " + expression);
        System.out.println("postfix: " + Arrays.toString(postfix));
        System.out.println(doCalc(postfix));
    }
    public static int doCalc(String[] input)
    {
        Stack<String> stack = new Stack<String>();
        for(String s: input)
        {
            if(!operatorsList.contains(s))
            {
                stack.push(s);
            }
            else
            {
                double right = Double.parseDouble(stack.pop());
                double left = Double.parseDouble(stack.pop());
                if(s.equals("+"))
                {
                    stack.push("" + (int)(left+right));
                }
                else if(s.equals("-"))
                {
                    stack.push("" + (int)(left-right));
                }
                else if(s.equals("*"))
                {
                    stack.push("" + (int)(left*right));
                }
                else if(s.equals("/"))
                {
                    stack.push("" + (int)(left/right));
                }
                else if(s.equals("%"))
                {
                    stack.push("" + (int)(left%right));
                }
                else if(s.equals("^"))
                {
                    stack.push("" + (int)(Math.pow(left,right)));
                }

            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static String[] infixToPostFix(String infix) {
        Stack<String> operators = new Stack<>();
        ArrayList<String> outputs = new ArrayList<>();
        String[] infixArr = infix.split(" ");
        for (String token : infixArr) {
            if (!operatorsList.contains(token)) {
                outputs.add(token);
            }
            else if (token.equals("(")) {
                operators.push(token);
            }
            else if (token.equals(")")) {
                        while (!operators.peek().equals("(")) {
                    String popped = operators.pop() ;
                    outputs.add(popped) ;
                }
                operators.pop(); //this pops (

            } else if (operatorsList.contains(token)) {
                    while (!operators.isEmpty() && (priorities[operatorsList.indexOf(token)] <= priorities[operatorsList.indexOf(operators.peek())])) {
                        try {
                            String popped = operators.pop();
                            outputs.add(popped) ;
                        } catch (EmptyStackException ex) {
                            break;
                        }
                    }
                operators.push(token);
                }

            }

            while (!operators.isEmpty()) {
                String popped = operators.pop();
                outputs.add(popped) ;
            }

            String[] resultArr = new String[outputs.size()];
            for(int i = 0;i<outputs.size();i++)
            {
                resultArr[i] = outputs.get(i);
            }
            return resultArr;
        }

        public static String[] convertStringToArr(String input)
        {
            String[] output = new String[input.length()];
            if(inputIsCorrect(input))
            {
                for(int i = 0;i<input.length();i++)
                {
                    String character = "" + input.charAt(i);
                    output[i] = character;
                }
            }
            return output;
        }

        public static boolean inputIsCorrect(String s)
        {
            Stack stack = new Stack();
            for(int i = 0;i<s.length();i++)
            {
                if(s.charAt(i) == '(')
                {
                    stack.push(s.charAt(i));
                }
                else if(s.charAt(i) == ')')
                {
                    try {
                        stack.pop();
                    }
                    catch(EmptyStackException ex)
                    {
                        return false;
                    }
                }

            }

            boolean parenCorrect = stack.isEmpty();
            boolean spacesCorrect = true;
            char previousChar = 'a';
            char currentChar = 'b';
            for(int i = 0;i<s.length();i++)
            {
                previousChar = currentChar;
                currentChar = s.charAt(i);
                if(Character.isDigit(previousChar) || operatorsCharList.contains(previousChar))
                {
                    if(currentChar != ' ' &&  !Character.isDigit(currentChar))
                    {
                        spacesCorrect = false;
                        break;
                    }

                }
                else if(previousChar == ' ')
                {
                    if(Character.isDigit(previousChar) || operatorsCharList.contains(previousChar))
                    {
                        spacesCorrect = false;
                        break;
                    }
                }

            }
            return spacesCorrect && parenCorrect;
        }
        public static void printStringArr(String[] input)
        {
            String result = "";
            for(String s:input)
            {
                result+=s;
            }
            System.out.println(result);
        }


}


