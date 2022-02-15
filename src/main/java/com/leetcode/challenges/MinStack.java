package com.leetcode.challenges;

import java.util.Stack;


/**
 * @author sanray on 11/15/2021
 */
public class MinStack {
    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(-2);
        myStack.push(0);
        myStack.push(-3);
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.top());
        System.out.println(myStack.getMin());

    }



    static class MyStack {

        Stack<Integer> stack ;
        Stack<Integer> minstack ;
        Stack<Integer> helper;
        int minValue;


        public MyStack() {
            stack = new Stack<>();
            helper = new Stack<>();
            minstack = new Stack<>();

        }

        public void push(int val) {
            stack.push(val);
            if(minstack.isEmpty()) {
                minstack.push(val);
                return;
            }
            while(!minstack.isEmpty() && minstack.peek() < val) {
                helper.push(minstack.pop());
            }
            minstack.push(val);
            while(!helper.isEmpty()) {
                minstack.push(helper.pop());
            }

        }

        public void pop() {
            stack.pop();
            minstack.pop();
        }

        public int top() {
            return stack.peek();

        }

        public int getMin() {
            return minstack.peek();
        }
    }
}


