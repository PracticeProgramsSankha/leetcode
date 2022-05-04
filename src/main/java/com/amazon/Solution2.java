package com.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.Assert;


/**
 * # Task: Write a function that test if the brackets
 * # in a given string are well-balanced and well-nested.
 * #
 * # For examples:
 * # "{(as)[we]wish}" should return TRUE
 * # "([as)we wish]" should return FALSE
 * # ...
 * <p>
 * // {} () []
 * //<>
 */

public class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        Assert.assertEquals(true, sol.testBrackets("{(as)[we]wish}"));
        Assert.assertEquals(false, sol.testBrackets("([as)we wish]"));

        System.out.println("All test pass!!");
    }

    private Map<Character, Character> bracketsMap = new HashMap<>();

    Solution2() {
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');
        bracketsMap.put(']', '[');
        bracketsMap.put('>', '<');

    }

    public boolean testBrackets(String inputString) {
        Stack<Character> stack = new Stack();

        for (Character ch : inputString.toCharArray()) {
            if (bracketsMap.values().contains(ch)) {
                stack.push(ch);
            } else if (bracketsMap.keySet().contains(ch)) {
                char topChar = stack.pop();
                if (topChar != bracketsMap.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    /*
    
     public boolean testBrackets(String inputString) {
        Stack<Character> stack = new Stack();
        
        for(Character ch : inputString.toCharArray() ) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if(ch == ')') {
                char topChar = stack.peek();
                if(topChar != bracketsMap.get(")")) {
                    return false;
                }
            } else if(ch == '}') {
                char topChar = stack.peek();
                if(topChar != bracketsMap.get("}")) {
                    return false;
                }
            } else if(ch == ']') {
                char topChar = stack.peek();
                if(topChar != bracketsMap.get("]")) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    */
}


