package com.PayPay;

/**
 *
 * You are given a two-digit integer n. Return the sum of its digits.
 *
 * Example
 *
 * For n = 29, the output should be
 * solution(n) = 11.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] integer n
 *
 * A positive two-digit integer.
 *
 * Guaranteed constraints:
 * 10 ≤ n ≤ 99.
 *
 * [output] integer
 *
 * The sum of the first and second digits of the input number.
 *
 * [Java] Syntax Tips
 *
 * // Prints help message to the console
 * // Returns a string
 * //
 * // Globals declared here will cause a compilation error,
 * // declare variables inside the function instead!
 * String helloWorld(String name) {
 *     System.out.println("This prints to the console when you Run Tests");
 *     return "Hello, " + name;
 * }
 * @author sanray on 3/8/2022
 */
public class Demo {
    public static void main(String[] args) {
        Demo sol = new Demo();
        System.out.println(sol.solution(99));
        System.out.println(sol.solution(10));
        System.out.println(sol.solution(11));
        System.out.println(sol.solution(98));
        System.out.println(sol.solution(9));

    }

    int solution(int n) {

        if(n == 0) {
            return 0;
        }

        String str= n + "";

        int result = 0;
        for(Character ch : str.toCharArray()) {
            result += ch - '0';
        }
        return result;
    }
}
