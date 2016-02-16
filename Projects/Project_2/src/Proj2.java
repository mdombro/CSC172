//******************************************//
//        Author: Matthew Dombroski         //
//              Project 2                   //
//          Overall program control         //
//******************************************//

// This file manages I/O operations and overall program logic

import java.util.*;

public class Proj2 {
    public static void main(String [] args) {
        String test = "!((3<5)=(7>4))";
        String post = inFixToPostFix(test);
        float eval = evalPostFix(post);
        System.out.println(post);
    }

    public evalPostFix(String post) {
      // 1. Get the token at the front of the queue.
      // 2. If the token is an operand, push it onto the stack.
      // 3. If the token is an operator, pop the appropriate number of operands from the stack (e.g. 2
         // operands for multiplication, 1 for logical NOT). Perform the operation on the popped
         // operands, and push the resulting value onto the stack.
         Queue q = new LinkedList();
         myStack<Character> s = new myStack<>();
         for (char i : post.toCharArray()) {
             q.add(i);
         }
         while (!q.isEmpty()) {
             if (operator(i) && i != '!') {

             }
         }
    }

    public static String inFixToPostFix(String infix) {
        List floats = new ArrayList<String>();
        String f;
        int newString = 0;
        for (char i : infix.toCharArray()) {
            if (number(i) || i == '.') {
                f += i;
                newString = 1;
            }
            if (!number(i) && i != '.') {
                newString = 0;
            }
        }
        myStack<Character> s = new myStack<>();
        Queue q = new LinkedList();
        String output = "";
        for (char i : infix.toCharArray()) {
            System.out.println("What's in q: " + q.toString());
            if (number(i)) {  // if the input is an operand, add to queue
                q.add(i);
            }
            if (i == '(') {
                s.push(i);  // ( always pushed to stack
            }
            if (i == ')') {
                while (s.peek() != '(') {  // pop from stack to queue until ( found
                    q.add(s.pop());
                }
                s.pop(); // pop the ( off into nothing
            }
            if (operator(i)) {  // if input is an operator +, -, *, /, <, >, =, !, |, &
                if (s.isEmpty()) {
                    s.push(i);
                } else if (higherPrecedence(i, s.peek())) {
                    s.push(i); // if the input has a higher precedence than what is on top of the stack we just push to stack
                } else {
                    q.add(s.pop()); // otherwise pop off stack into queue
                    s.push(i);  // and then push read operator onto stack
                }
            }
        }
        while (!s.isEmpty()) {
            q.add(s.pop());  // empty any remaining operators onto the output queue
        }
        System.out.println(q.toString());
        while (!q.isEmpty()) {
            output += Character.toString((char)q.remove());
        }
        return output;
    }

    public static boolean number(char i) {
        if (Character.getNumericValue(i) == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean operator(char i) {
        // check if input is one of the required operators
        // +  -  *  /  <  >  =  !  |  &
        if (i == '+' || i == '-' || i == '*' || i == '/' || i=='<' || i == '>' || i == '=' || i == '!' || i == '|' || i == '&') {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean higherPrecedence(char i, char stack) {
        // Notes: this function must also determine the associativity of the input
        // which alters precedence comparison
        // for left-associativity - precedence is <=
        // for right-associativity - precedence is <
        // Precedence list for operators:
        // op  - lvl
        //  !  - 1   also right associative, so stack must be strictly less precedence
        // ( ) - 2
        //  *  - 3
        //  /  - 4
        //  +  - 5
        //  -  - 6
        // < > - 7
        //  =  - 8
        //  &  - 9
        //  |  - 10
        System.out.println(i);
        System.out.println(stack);
        if (stack == '(') {
            return true;  // ignore ( and just push to stack
        }
        int inputPrec = convToPrec(i);
        int stackPrec = convToPrec(stack);
        if (i != '!') {
            return inputPrec <= stackPrec;
        }
        else {
            return inputPrec < stackPrec;
        }
    }

    public static int convToPrec(char i) {
        switch (i) {
            case '!':
                return 1;
            case '(':
                return 2;
            case ')':
                return 2;
            case '*':
                return 3;
            case '/':
                return 4;
            case '+':
                return 5;
            case '-':
                return 6;
            case '<':
                return 7;
            case '>':
                return 7;
            case '=':
                return 8;
            case '&':
                return 9;
            case '|':
                return 10;
            default:
                return 1;
        }
    }
}
