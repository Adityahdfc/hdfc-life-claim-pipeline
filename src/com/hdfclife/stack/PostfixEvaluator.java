package com.hdfclife.stack;

public class PostfixEvaluator {
    public static int evaluate(String expression) {
        LinkedClaimStack linkedClaimStack = new LinkedClaimStack();

        for(String curr :  expression.split(" ")) {
            if(curr.equals("+")) {
                int a = linkedClaimStack.pop();
                int b = linkedClaimStack.pop();

                linkedClaimStack.push(a + b);
            }
            else if(curr.equals("-")) {
                int a = linkedClaimStack.pop();
                int b = linkedClaimStack.pop();

                linkedClaimStack.push(b - a);
            }
            else if(curr.equals("*")) {
                int a = linkedClaimStack.pop();
                int b = linkedClaimStack.pop();

                linkedClaimStack.push(a * b);
            }
            else if(curr.equals("/")) {
                int a = linkedClaimStack.pop();
                int b = linkedClaimStack.pop();

                linkedClaimStack.push(b / a);
            }
            else{
                linkedClaimStack.push(Integer.parseInt(curr));
            }
        }

        return linkedClaimStack.pop();
    }

    static void main() {
        System.out.println(evaluate("25000 18000 + 1000 -"));
    }
}
