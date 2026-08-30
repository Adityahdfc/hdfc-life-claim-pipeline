package com.hdfclife.stack;

public class ParenthesesChecker {
    public static boolean paranthesesCheck(String str) {
        ArrayClaimStack arrayStack = new ArrayClaimStack();
        int ptr = -1;
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                arrayStack.push((int)c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (arrayStack
                        .isEmpty()) {
                    return false;
                }

                char opening = (char)arrayStack.pop();

                if ((c == ')' && opening != '(') ||
                        (c == '}' && opening != '{') ||
                        (c == ']' && opening != '[')) {
                    return false;
                }
            }
        }
        return true;
    }
}
