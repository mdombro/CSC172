//******************************************//
//        Author: Matthew Dombroski         //
//              Project 2                   //
//          Overall program control         //
//******************************************//

// This file manages I/O operations and overall program logic

import java.util.*;

public class Proj2 {
    public static void main(String [] args) {
        String test = "3.2 < 2.3";
        Queue post = inFixToPostFix(test);
        //float eval = evalPostFix(post);
        Object[] p = post.toArray();
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] +", ");
        }
        Float answer = (float)evalPostFix(post);
        System.out.println("\n" + answer);
    }

    public static Object evalPostFix(Queue post) {
      // 1. Get the token at the front of the queue.
      // 2. If the token is an operand, push it onto the stack.
      // 3. If the token is an operator, pop the appropriate number of operands from the stack (e.g. 2
         // operands for multiplication, 1 for logical NOT). Perform the operation on the popped
         // operands, and push the resulting value onto the stack.
      // +, -, *, /, <, >, =, !, |, &
        Queue q = new LinkedList();
        myStack s = new myStack<>();
        float op1;
        float op2;
        for (Object i : post) {
            if (i.getClass() == Float.class) {
                s.push(i);
            }
            if (i.getClass() == Character.class) {
                switch ((char)i) {
                    case '+':
                        op1 = (float)s.pop();
                        op2 = (float)s.pop();
                        s.push(op1+op2);
                        break;
                    case '-':
                        op1 = (float)s.pop();
                        op2 = (float)s.pop();
                        s.push(op2-op1);
                        break;
                    case '*':
                        op1 = (float)s.pop();
                        op2 = (float)s.pop();
                        s.push(op1*op2);
                        break;
                    case '/':
                        op1 = (float)s.pop();
                        op2 = (float)s.pop();
                        s.push(op2/op1);
                        break;
                    case '<':
                        op1 = (float)s.pop();
                        op2 = (float)s.pop();
                        s.push((float)(op2 < op1 ? 1.0 : 0.0));
                        break;
                    case '>':
                        op1 = (float)s.pop();
                        op2 =(float) s.pop();
                        s.push((float)(op2>op1 ? 1.0 : 0.0));
                        break;
                    case '=':
                        op1 = (float)s.pop();
                        op2 = (float)s.pop();
                        s.push((float)(op1==op2 ? 1.0 : 0.0));
                        break;
                    case '!':
                        op1 = (float)s.pop();
                        s.push((float)(op1 == 1.0 ? 0.0 : 1.0));
                        break;
                    case '|':
                        op1 = (float)s.pop();
                        op2 = (float)s.pop();
                        s.push((float)(op1 == 1.0 || op2 == 1.0 ? 1.0 : 0.0));
                        break;
                    case '&':
                        op1 = (float)s.pop();
                        op2 = (float)s.pop();
                        s.push((float)(op1 == op2 && op1 == 1.0 ? 1.0 : 0.0));
                        break;
                }
            }
        }
        return s.pop();
    }

    public static Queue inFixToPostFix(String infix) {
        List<ArrayList<Character>> c = new ArrayList<>();
        ArrayList<Character> od = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();
        int supress = 0;
        for (int i = 0; i < infix.length(); i++) {
            if (operator(infix.charAt(i)) || infix.charAt(i) == '(' || infix.charAt(i) == ')') {
                op.add(infix.charAt(i));
                System.out.println("Im adding an operator " + infix.charAt(i));
                c.add(new ArrayList<>(op));
                op.clear();
                System.out.println("I've cleared a sub list");
                supress = 0;
            }
            if (number(infix.charAt(i))) {
                if (supress == 0) {  // in the case of the first digit
                    od.add(infix.charAt(i));
                    System.out.println("Im adding a digit " + infix.charAt(i));
                    supress = 1;
                    if (i == infix.length()-1) {   // in case we are on the last single digit number
                        System.out.println("I've cleared a sub list");
                        c.add(new ArrayList<>(od));
                        od.clear();
                        supress = 0;
                        continue;
                    }
                    if (!number(infix.charAt(i+1))) { // in the case we have a one digit number
                        System.out.println("I've cleared a sub list");
                        c.add(new ArrayList<>(od));
                        od.clear();
                        supress = 0;
                    }
                    continue;
                }
                if (supress == 1 && i == infix.length() - 1) {  // in the case this is the last digit and last element of the string
                    System.out.println("Im adding a digit " + infix.charAt(i));
                    od.add(infix.charAt(i));
                    c.add(new ArrayList<>(od));
                    od.clear();
                    System.out.println("I've cleared a sub list");
                    supress = 0;
                    continue;
                }
                if (supress == 1 && !number(infix.charAt(i + 1))) {   // in the case of last digit
                    System.out.println("Im adding a digit " + infix.charAt(i));
                    od.add(infix.charAt(i));
                    c.add(new ArrayList<>(od));
                    od.clear();
                    System.out.println("I've cleared a sub list");
                    supress = 0;
                    continue;
                }
                if (supress == 1 && number(infix.charAt(i + 1))) {  // in the case a middle digit
                    System.out.println("Im adding a digit " + infix.charAt(i));
                    od.add(infix.charAt(i));
                    continue;
                }
            }
        }
        System.out.println("Length of c: " + c.size());
        for (ArrayList<Character> li : c) {
            System.out.println("Anybody here");
            for (int i = 0; i < li.size(); i++) {
                System.out.println("Whats in the sublist: " + li.get(i));
            }
        }
        String floating = "";
        float num;
        List inFix = new ArrayList<>();
        for (ArrayList<Character> li : c) {
            for (int i = 0; i < li.size(); i++) {
                if (number(li.get(i))) {
                    floating += Character.toString(li.get(i));
                    System.out.println("What is the digit: " + floating);
                }
                if (number(li.get(i)) && i == li.size() - 1) {
                    num = Float.parseFloat(floating);
                    inFix.add(num);
                    System.out.println(num);
                    floating = "";
                }
                if (operator(li.get(i)) || li.get(i) == '(' || li.get(i) == ')') {
                    inFix.add(li.get(i));
                    System.out.println(li.get(i));
                }
            }
        }
        System.out.println();
        System.out.println();
        for (Object i : inFix) {
            System.out.println(i);
        }


        myStack<Character> s = new myStack<>();
        Queue q = new LinkedList();
        String output = "";
        for (Object i : inFix) {
            System.out.println("What's in q: " + q.toString());
            if (i.getClass() == Float.class || i.getClass() == Number.class) {
                System.out.println("Queue has added: " + i);
                q.add(i);
            }
            if (i.getClass() == Character.class) {
                if ((char) i == '(') {
                    System.out.println("Stack has added 1: " + i);
                    s.push((char) i);  // ( always pushed to stack
                }
                if ((char) i == ')') {
                    while (s.peek() != '(') {  // pop from stack to queue until ( found
                        System.out.println("Queue has added 1: " + s.peek());
                        q.add(s.pop());
                    }
                    s.pop(); // pop the ( off into nothing
                }
                if (operator((char) i)) {  // if input is an operator +, -, *, /, <, >, =, !, |, &
                    if (s.isEmpty()) {
                        s.push((char) i);
                        System.out.println("Stack has added 2: " + i);
                    } else if (higherPrecedence((char) i, s.peek())) {
                        s.push((char) i); // if the input has a higher precedence than what is on top of the stack we just push to stack
                        System.out.println("Stack has added 3: " + i);
                    } else {
                        System.out.println("Queue has added 2: " + s.peek());
                        q.add(s.pop()); // otherwise pop off stack into queue
                        s.push((char) i);  // and then push read operator onto stack
                    }
                }
            }

        }
        while (!s.isEmpty()) {
            q.add(s.pop());  // empty any remaining operators onto the output queue
        }
        return q;
    }

    public static boolean number(char i) {
        String nums = "0123456789.";
        for (char k : nums.toCharArray()) {
            if (i == k) {
                return true;
            }
        }
        return false;
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
